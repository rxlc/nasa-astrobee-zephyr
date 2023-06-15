package jp.jaxa.iss.kibo.rpc.testing;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

import java.util.List;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import gov.nasa.arc.astrobee.Kinematics;

import android.util.Log;

import java.util.ArrayList;
import jp.jaxa.iss.kibo.rpc.testing.State;
/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        api.startMission();

        final int START = 0;
        final int GOAL = 8;

        int loop_counter = 0;
        int currentPos = START;

        int destination;

        while (true){
            List<Integer> list = api.getActiveTargets();
            destination = list.get(0);

            Log.i("ZephyrTarget", "target is now " + destination);

            ArrayList<State> trajectory = this.returnTrajectory(currentPos, destination);

            for (int i=0; i<trajectory.size(); i++) {
                moveTo(trajectory.get(i).getPoint(), trajectory.get(i).getQuaternion(), true);
            }

            Log.i("ZephyrMove", "Trajectory completed.");

            currentPos = destination;

            /*
            // get a camera image
            Mat image = api.getMatNavCam(   );

            // irradiate the laser
            api.laserControl(true);

            // take active target snapshot
            api.takeTargetSnapshot(destination);
            */

            List<Long> timeRemaining = api.getTimeRemaining();

            // check the remaining milliseconds of mission time
            if (timeRemaining.get(1) < 60000){
                break;
            }

            loop_counter++;
            if (loop_counter >= 8){
                break;
            }
        }
        // turn on the front flash light
        api.flashlightControlFront(0.05f);
        
        // get QR code content
        String mQrContent = yourMethod();

        // turn off the front flash light
        api.flashlightControlFront(0.00f);

        // notify that astrobee is heading to the goal
        api.notifyGoingToGoal();

        //Move to goal
        ArrayList<State> trajectory = this.returnTrajectory(currentPos, GOAL);

        for (int i=0; i<trajectory.size(); i++) {
            moveTo(trajectory.get(i).getPoint(), trajectory.get(i).getQuaternion(), true);
        }

        Log.i("ZephyrMove", "Trajectory completed.");

        // send mission completion
        api.reportMissionCompletion(mQrContent);
    }

    public ArrayList<State> returnTrajectory(int start, int goal) {
        //All computations done on: https://colab.research.google.com/drive/1DCgAljUgt8WrGdHzco6iFIpMWlBrGZ1r#scrollTo=DXh6oHjiYfnZ
        ArrayList<State> trajectory = new ArrayList<State>();

        if (start == 0) {
            if (goal == 1) {
                trajectory.add(new State(new Point(10.69583333333334, -9.816666666666663, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.276250000000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.354166666666671, -9.560416666666661, 4.361666666666668), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.354166666666671, -9.560416666666661, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.439583333333339, -8.193749999999987, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.354166666666671, -9.560416666666661, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.447083333333335), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.361666666666668), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.208333333333343, -9.133333333333326, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(10.268750000000004, -9.645833333333329, 4.276250000000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.354166666666671, -9.560416666666661, 4.361666666666668), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -9.218749999999993, 4.361666666666668), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -9.133333333333326, 4.361666666666668), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 1) {
            if (goal == 2) {
                trajectory.add(new State(new Point(11.208333333333343, -9.645833333333329, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -9.560416666666661, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(10.866666666666674, -8.10833333333332, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.610416666666673, -6.91249999999998, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.29375000000001, -7.424999999999983, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 2) {
            if (goal == 1) {
                trajectory.add(new State(new Point(11.122916666666676, -9.560416666666661, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.208333333333343, -9.645833333333329, 5.130416666666672), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(10.610416666666673, -8.364583333333321, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.610416666666673, -8.10833333333332, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.610416666666673, -8.364583333333321, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(10.866666666666674, -8.535416666666656, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(10.69583333333334, -9.047916666666659, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.781250000000007, -9.047916666666659, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(10.69583333333334, -8.620833333333323, 4.447083333333335), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -8.535416666666656, 4.447083333333335), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(10.69583333333334, -8.877083333333324, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.781250000000007, -8.791666666666657, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 3) {
            if (goal == 1) {
                trajectory.add(new State(new Point(11.037500000000009, -8.279166666666654, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(10.69583333333334, -8.279166666666654, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.69583333333334, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.610416666666673, -7.1687499999999815, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(11.037500000000009, -8.10833333333332, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(11.122916666666676, -8.279166666666654, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(11.122916666666676, -8.279166666666654, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 4) {
            if (goal == 1) {
                trajectory.add(new State(new Point(10.781250000000007, -8.791666666666657, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(10.610416666666673, -8.620833333333323, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(10.525000000000006, -7.254166666666649, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(11.037500000000009, -7.681249999999984, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(11.208333333333343, -8.10833333333332, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 5) {
            if (goal == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.69583333333334, -8.70624999999999, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.952083333333341, -8.10833333333332, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.208333333333343, -8.193749999999987, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.379166666666677, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.122916666666676, -7.083333333333314, 5.130416666666672), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 6) {
            if (goal == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(10.781250000000007, -8.962499999999991, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.69583333333334, -8.962499999999991, 4.703333333333337), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(10.952083333333341, -7.595833333333317, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 7) {
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (start == 7) {
            if (goal == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 2) {
                trajectory.add(new State(new Point(10.781250000000007, -8.535416666666656, 4.447083333333335), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.69583333333334, -8.70624999999999, 4.447083333333335), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 3) {
                trajectory.add(new State(new Point(11.208333333333343, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 4.874166666666671), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 4) {
                trajectory.add(new State(new Point(11.208333333333343, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.525000000000006, -6.741666666666646, 5.130416666666672), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 5) {
                trajectory.add(new State(new Point(11.379166666666677, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.208333333333343, -8.193749999999987, 5.2158333333333395), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.122916666666676, -8.10833333333332, 5.301250000000007), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goal == 8) {
                trajectory.add(new State(new Point(11.379166666666677, -8.535416666666656, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.208333333333343, -6.91249999999998, 4.959583333333338), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }

        return trajectory;
    }

    public void moveTo(Point x, Quaternion y, boolean z) {
        Log.i("ZephyrMove", "moving to " + x.getX() + ", " + x.getY() + ", " + x.getZ() + " with " + y.getX() + ", " + y.getY() + ", " + y.getZ() + ", " + y.getW());

        api.moveTo(x, y, z);

        /*
        final int LOOP_MAX = 3;
        final double precision = 0.05;

        int counter = 0;
        double dx = Math.abs(x.getX());
        double dy = Math.abs(x.getY());
        double dz = Math.abs(x.getZ());
        while((dx > precision && dy > precision && dz > precision)) {
            api.moveTo(x, y, z);
            Kinematics k = api.getRobotKinematics();
            dx = Math.abs(k.getPosition().getX() - dx);
            dy = Math.abs(k.getPosition().getY() - dy);
            dz = Math.abs(k.getPosition().getZ() - dz);
            counter++;

            Log.i("ZephyrAdjust", "" + x.getX() + ", " + x.getY() + ", " + x.getZ() + " with " + y.getX() + ", " + y.getY() + ", " + y.getZ() + ", " + y.getW());

            if (counter == LOOP_MAX) {
                Log.i("ZephyrAdjust", "adjusting failed");
                break;
            }
        }
        */
    }

    @Override
    protected void runPlan2(){
       // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }

    // You can add your method
    private String yourMethod(){
        return "your method";
    }
}
