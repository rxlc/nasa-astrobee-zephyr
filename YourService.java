package jp.jaxa.iss.kibo.rpc.testing;

import gov.nasa.arc.astrobee.Result;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import java.util.List;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import android.util.Log;
import org.opencv.core.Mat;

import org.opencv.aruco.Aruco;
import org.opencv.aruco.Dictionary;
import gov.nasa.arc.astrobee.Kinematics;

import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import android.graphics.Bitmap;

import java.util.ArrayList;
/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override

    protected void runPlan1(){
        api.startMission();

        final int START_ID = 0;
        final int QRCODE_ID = 7;
        final int GOAL_ID = 8;

        int currentId = START_ID;
        State currentState;

        int loopCount = 0;
        int MAX_ITERATIONS = 8;

        double[][] intrinstics = api.getNavCamIntrinsics();

        String reportContent = "";

        int CLOSE_OFF_LIMIT = 165 * 1000;
        boolean qrScanned = false;

        int imageCount = 0;

        while (true){
            //Conditions determining if astrobee should start moving to goal
            List<Long> timeRemaining = api.getTimeRemaining();
            loopCount++;

            if (loopCount >= MAX_ITERATIONS) break;

            //Determining destination from active targets/other parameters
            List<Integer> list = api.getActiveTargets();

            int destinationId = 7;

            if (timeRemaining.get(1) > CLOSE_OFF_LIMIT) {
                if (contains(list, 1) || contains(list,2) || contains(list, 6)) {
                    List<Integer> choices = filterZone(list, 0);
                    destinationId = Traversal.findClosest(currentId, choices);
                } else if (qrScanned == false) {
                    ArrayList<State> QRtrajectory = Traversal.returnTrajectory(currentId, QRCODE_ID);
                    traverseTrajectory(QRtrajectory);
                    currentId = QRCODE_ID;
                    currentState = QRtrajectory.get(QRtrajectory.size()-1);

                    Mat image = api.getMatNavCam();
                    api.saveMatImage(image, "qr");
                    reportContent = QrCode.readQRCode(image);

                    qrScanned = true;
                    continue;
                } else {
                    destinationId = list.get(0);
                }
            } else {
                if (qrScanned == false) {
                    ArrayList<State> QRtrajectory = Traversal.returnTrajectory(currentId, QRCODE_ID);
                    traverseTrajectory(QRtrajectory);
                    currentId = QRCODE_ID;
                    currentState = QRtrajectory.get(QRtrajectory.size() - 1);

                    Mat image = api.getMatNavCam();
                    api.saveMatImage(image, "qr");
                    reportContent = QrCode.readQRCode(image);

                    qrScanned = true;
                    continue;
                } else if (timeRemaining.get(1) < 86 * 1000 || !(contains(list, 3) || contains(list, 4) || contains(list, 5))){
                    break;
                } else {
                    List<Integer> choices = filterZone(list, 1);
                    destinationId = Traversal.findClosest(currentId, choices);
                }
            }

            //int destinationId = list.get(0);

            Log.i("ZephyrTarget", "Target is now " + destinationId);

            //Once destinationId is set, traverse to it
            ArrayList<State> trajectory = Traversal.returnTrajectory(currentId, destinationId);
            traverseTrajectory(trajectory);

            currentId = destinationId;
            currentState = trajectory.get(trajectory.size()-1);

            int arLoopCounter = 0;
            int maxArIterations = 2;

            Mat currentMatImage = api.getMatNavCam();
            api.saveMatImage(currentMatImage, "image" + imageCount);

            while (arLoopCounter < maxArIterations) {
                Mat image = api.getMatNavCam();
                Mat undistortedImage = ArTag.undistort(image, intrinstics);

                //api.saveMatImage(undistortedImage, "undistortedimage" + imageCount);

                Mat ids = new Mat();
                List<Mat> corners = new ArrayList<Mat>();

                Dictionary dictionary = Aruco.getPredefinedDictionary(Aruco.DICT_5X5_250);
                Aruco.detectMarkers(undistortedImage, dictionary, corners, ids); //change to Aruco.DICT_5X5_250 for actual program

                Mat drawnImage = undistortedImage.clone();
                Aruco.drawDetectedMarkers(drawnImage, corners, ids);

                api.saveMatImage(drawnImage, "drawnImage" + imageCount);

                List<List<Double>> tags = ArTag.tags(undistortedImage, currentId);

                if (tags != null) {
                    double[] xyDiff = ArTag.findXYDiff(tags);
                    Point adjustedPoint = ArTag.adjustForFiring(xyDiff, currentState.getPoint(), currentId);

                    double dx = Math.abs(adjustedPoint.getX() - currentState.getPoint().getX());
                    double dy = Math.abs(adjustedPoint.getY() - currentState.getPoint().getY());
                    double dz = Math.abs(adjustedPoint.getZ() - currentState.getPoint().getZ());
                    double mag = Math.sqrt(dx*dx + dy*dy + dz*dz);

                    Log.i("mag of adjustment", "" + mag);

                    if (mag < 0.05) break;

                    if (currentId == 2) {
                        Point newAdjustedPoint = new Point(currentState.getPoint().getX(), adjustedPoint.getY(), adjustedPoint.getZ());
                        adjustedPoint = newAdjustedPoint;
                    }

                    traverseWithPrecision(adjustedPoint, currentState.getQuaternion(), true, 0.05);

                    currentState = new State(adjustedPoint, currentState.getQuaternion());

                    Mat adjustedUImage = api.getMatNavCam();
                    Mat adjustedImage = ArTag.undistort(adjustedUImage, intrinstics);
                    api.saveMatImage(adjustedImage, "adjustedimage" + imageCount + "_" + arLoopCounter);
                }

                arLoopCounter++;
            }

            imageCount++;

            if (currentId == 2) {
                Quaternion adjustedOrientation = ArTag.adjustRotation(new Point(11.2625, -10.58, 5.3625), currentState.getPoint());
                traverseTo(currentState.getPoint(), adjustedOrientation, true);

                currentState = new State(currentState.getPoint(), adjustedOrientation);
            }

            api.laserControl(true);
            api.takeTargetSnapshot(destinationId);
            api.laserControl(false);
        }

        /*
        ArrayList<State> QRtrajectory = traversal.returnTrajectory(currentId, QRCODE_ID);
        traverseTrajectory(QRtrajectory);
        currentId = QRCODE_ID;
        currentState = QRtrajectory.get(QRtrajectory.size()-1);

        Mat image = api.getMatNavCam();
        api.saveMatImage(image, "qr");
        reportContent = QrCode.readQRCode(image);
        */

        //Astrobee starts moving to goal
        api.notifyGoingToGoal();

        ArrayList<State> trajectory = Traversal.returnTrajectory(currentId, GOAL_ID);
        traverseTrajectory(trajectory);

        // send mission completion
        long remainingTime = api.getTimeRemaining().get(1);
        Log.i("completed", "mission completed with time remaining: " + remainingTime/1000);
        api.reportMissionCompletion(reportContent);
    }

    public List<Integer> filterZone(List<Integer> nums, int zone) {
        List<Integer> newNums = new ArrayList<>();

        for (int i=0; i<nums.size(); i++) {
            if (zone == 0) {
                if (nums.get(i) == 1 || nums.get(i) == 2 || nums.get(i) == 6) {
                    newNums.add(nums.get(i));
                }
            } else {
                if (nums.get(i) == 3 || nums.get(i) == 4 || nums.get(i) == 5) {
                    newNums.add(nums.get(i));
                }
            }
        }
        
        return newNums;
    }

    public void traverseTo(Point point, Quaternion quaternion, boolean printRobotPos) {
        int loopCount = 0;
        int MAX_ITERATIONS = 3;
        Result result;

        do {
            result = api.moveTo(point, quaternion, printRobotPos);
            loopCount++;
        } while (loopCount < MAX_ITERATIONS && !result.hasSucceeded());
    }

    public void traverseWithPrecision(Point point, Quaternion quaternion, boolean printRobotPos, double precision) {
        int loopCount = 0;
        int MAX_ITERATIONS = 3;

        do {
            api.moveTo(point, quaternion, printRobotPos);
            loopCount++;

            if (loopCount < MAX_ITERATIONS) {
                Kinematics currentK = api.getRobotKinematics();
                double dx = Math.abs(currentK.getPosition().getX() - point.getX());
                double dy = Math.abs(currentK.getPosition().getY() - point.getY());
                double dz = Math.abs(currentK.getPosition().getZ() - point.getZ());

                if (dx <= precision && dy <= precision && dz <= precision) {
                    Log.i("Traverse", "Aligned" + dx + " " + dy + " " + dz);
                    break;
                }
            }
        } while (loopCount < MAX_ITERATIONS);
    }

    public void traverseTrajectory(ArrayList<State> trajectory) {
        for (int i=0; i<trajectory.size(); i++) {
            traverseTo(trajectory.get(i).getPoint(), trajectory.get(i).getQuaternion(), true);
        }
    }

    public static boolean contains(List<Integer> list, int target) {
        for (int num : list) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void runPlan2(){
        // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }
}
