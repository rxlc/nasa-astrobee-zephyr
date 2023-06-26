package jp.jaxa.iss.kibo.rpc.testing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

import android.util.Log;

import org.opencv.aruco.Aruco;
import org.opencv.aruco.Dictionary;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

public class ArTag {
    public static void main(String[] args) {

    }

    public static void logIdMatrix(Mat ids) {
        try {
            for (int i = 0; i < ids.size().height; i++) {
                Log.i("IdMatrix", "Height" + i);
                for (int j = 0; j < ids.size().width; j++) {
                    Log.i("IdMatrix", "Width" + j);
                    if (ids.get(i,j) != null) {
                        for (int k = 0; k < ids.get(i,j).length; k++) {
                            Log.i("IdMatrix", "k" + k);
                            Log.i("IdMatrix", "" + ids.get(i,j)[k]);
                        }
                    } else {
                        Log.i("IdMatrix", "null");
                    }
                }
            }
        }
        catch (Exception e) {
            Log.i("IdMatrix", "Method failed");
        }
    }

    public static void logCorners(List<Mat> corners) {
        Log.i("CornerMatrix", "arraylist size = " + corners.size());
        try {
            for (int x = 0; x < corners.size(); x++) {
                Log.i("CornerMatrix", "x" + x);
                for (int i = 0; i < corners.get(x).size().height; i++) {
                    Log.i("CornerMatrix", "i" + i);
                    for (int j = 0; j < corners.get(x).size().width; j++) {
                        Log.i("CornerMatrix", "j" + j);
                        if (corners.get(x).get(i, j) != null) {
                            for (int k = 0; k < corners.get(x).get(i, j).length; k++) {
                                Log.i("CornerMatrix", "k" + k);
                                Log.i("CornerMatrix", "" + corners.get(x).get(i, j)[k]);
                            }
                        } else {
                            Log.i("CornerMatrix", "null");
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.i("CornerMatrix", "Method 1 error");
        }
    }

    public static List<List<Double>> tags(Mat image, int target_num) {
        Mat ids = new Mat();
        List<Mat> corners = new ArrayList<Mat>();

        Dictionary dictionary = Aruco.getPredefinedDictionary(Aruco.DICT_5X5_250);
        Aruco.detectMarkers(image, dictionary, corners, ids); //change to Aruco.DICT_5X5_250 for actual program

        logIdMatrix(ids);
        logCorners(corners);

        List<List<Double>> result = new ArrayList<>();
        double xDif = 0;
        double yDif = 0;
        for (int i = 0; i<ids.height(); i++) { //this is correct, ids is a matrix consisting of a width of 1
            if (((int)ids.get(i,0)[0]-1)/4 + 1 == target_num) {
                List<Double> temp = new ArrayList<>();
                if (ids.get(i, 0) == null) {
                    break;
                }

                int numCorners = 0;

                temp.add(ids.get(i, 0)[0]); //our assumption that the double array would be of length 1 is correct, it is also indeed the latter value of ids that needs to iterate
                for (int j = 0; j < corners.get(i).size().width; j++) { //technically corners.size() should always evaluate to 4, it should be fine
                    Mat coords = corners.get(i); // this matrix consists of a height of 1, and a width of 4, but that might change given more active tags, I'm assuming the 4 width means that there is one row per ar tag
                    if (coords.get(0, j) != null) { //therefore, (j, i) should yield the first value of each matrix, which should provide the coords of each ar tag
                        for (double val : coords.get(0, j)) {
                            temp.add(val); // coords should be in x, y order
                        }
                        numCorners++;
                    }
                }

                for (Double val : temp) {
                    Log.i("StoredValues", "" + val);
                }

                if (numCorners < 4) {
                    return null;
                }

                xDif = (Math.abs(temp.get(1) - temp.get(3))+Math.abs(temp.get(5)-temp.get(7)))/2; //provides the average of the differences in x values so that it is more accurate.
                // the ratio will be pixelSize : 5cm, so to convert to metres, 20/pixelSize
                yDif = (Math.abs(temp.get(2) - temp.get(6)) + Math.abs(temp.get(4)-temp.get(8)))/2;


                xDif*=20;
                yDif*=20;

                Log.i("XDif", " " + xDif);
                Log.i("YDif", " " + yDif);

                for (int j = 1; j< temp.size(); j+=2) {
                    temp.set(j, (temp.get(j) - 640) / xDif);
                }
                for (int j = 2; j< temp.size(); j+=2) {
                    temp.set(j, ((temp.get(j)) - 480) / yDif);
                }
                result.add(temp); // for each arraylist in result, it contains 9 values, [id, x1, y1, x2, y2, x3, y3, x4, y4]

                for (Double val : temp) {
                    Log.i("Values of temp", " " + val);
                }
                //break;
            }
        }
        return result; // result contains 1 to 4 ar tags
    }

    public static Mat undistort(Mat image, double[][] info) {
        Mat K = new Mat(3, 3, CvType.CV_32FC1);
        K.put(0,0, info[0]);
        Mat D = new Mat(1, 5, CvType.CV_32FC1);
        D.put(0,0, info[1]);
        Mat solution = new Mat(1280, 960, CvType.CV_8UC1);
        Imgproc.undistort(image, solution, K, D); //can change if needed
        return solution;
    }

    public static double[] findXYDiff(List<List<Double>> tags) {
        ArrayList<Double> xDiffs = new ArrayList<>();
        ArrayList<Double> yDiffs = new ArrayList<>();

        for (int n = 0; n < tags.size(); n++) {
            int pos; // will be the position in which it is in
            /*
            [ 2, 1 ]
            [ 3, 4 ]
             */

            int tag_num = (int) tags.get(n).remove(0).shortValue(); // id of tha ar tag

            if (tag_num % 4 == 1) {
                pos = 1;
            } else if (tag_num % 4 == 2) {
                pos = 2;
            } else if (tag_num % 4 == 3) {
                pos = 3;
            } else {
                pos = 4;
            }

            Log.i("Tag Position", " " + pos);

            double[] xPositions = new double[4];
            double[] yPositions = new double[4];

            for (int i = 0; i < tags.get(n).size(); i++) {
                if (i % 2 == 0) {
                    xPositions[i / 2] = tags.get(n).get(i);
                    Log.i("XPositions", " " + tags.get(n).get(i));
                } else {
                    yPositions[i / 2] = tags.get(n).get(i);
                    Log.i("YPositions", " " + tags.get(n).get(i));
                }

            }
            for (double val : xPositions) {
                Log.i("xPositions", " " + val);
            }
            for (double val : yPositions) {
                Log.i("yPositions", " " + val);
            }
            // Now lets aim the laser at the centre of the ar tag
            double x_pos = (xPositions[1] + xPositions[0]) * 0.5;
            double y_pos = (yPositions[3] + yPositions[1]) * 0.5;

            Log.i("positions", "x_pos " + x_pos);
            Log.i("positions", "y_pos" + y_pos);

            if (pos == 1 || pos == 4) {
                x_pos -= 0.10;
            } else {
                x_pos += 0.10;
            }

            if (pos == 1 || pos == 2) {
                y_pos += 0.0375;
            } else {
                y_pos -= 0.0375;
            }

            //adjustment from heart of ar tag to centre of target
            Log.i("positions", "x_pos " + x_pos);
            Log.i("positions", "y_pos" + y_pos);

            x_pos -= 0.0994;
            y_pos += 0.0285;

            xDiffs.add(x_pos);
            yDiffs.add(y_pos);

            Log.i("positions", "x_pos " + x_pos);
            Log.i("positions", "y_pos" + y_pos);
        }

        double xAvg = findAverage(xDiffs);
        double yAvg = findAverage(yDiffs);

        Log.i("positions", "x_avg " + xAvg);
        Log.i("positions", "y_avg" + yAvg);

        return new double[]{xAvg, yAvg};
    }

    public static Point adjustForFiring(double[] xyPos, Point currentPoint, int target_num) {
        double x = currentPoint.getX();
        double y = currentPoint.getY();
        double z = currentPoint.getZ(); //eliminated z element since it does not seem to change target
        Log.i("Current Positions", "xPos " + x);
        Log.i("Current Positions", "yPos " + y);
        Log.i("Current Positions", "zPos " + z);

        double x_pos = xyPos[0];
        double y_pos = xyPos[1];

        //final adjustments based on laser position
        if (target_num == 2 ) {
            x-= x_pos;
            y-= y_pos;
        }
        else if (target_num == 3) {
            y+=x_pos;
            x+=y_pos;
        }
        else if (target_num == 5) {
            y+= y_pos;
            x+= x_pos;
        }
        else if ( target_num == 6) {
            y+= x_pos;
            z+= y_pos;
        }
        else if (target_num == 4) {
            y-= x_pos;
            z+= y_pos;
        }
        else {
            x+= x_pos;
            z+= y_pos;
        }

        Log.i("Final Positions", "xPos " + x);
        Log.i("Final Positions", "yPos " + y);
        Log.i("Final Positions", "zPos " + z);
        return new Point(x,y,z);
    }

    public static Quaternion adjustRotation(Point target, Point currentPoint, int target_num) {
        double[] position = {currentPoint.getX() + 0.1302, currentPoint.getY() + 0.0572, currentPoint.getZ() -0.1111};

        double zDif;
        if (target_num == 2) {
            zDif = 4.48 - position[2];
        }
        else {
            zDif = 11.355 - position[0];
        }

        double x_pos;
        if (target_num == 2) {
            x_pos = target.getX() - currentPoint.getX();
        }
        else {
            x_pos = target.getY() - currentPoint.getY();
        }

        double theta = Math.asin(x_pos/zDif);

        Quaternion result;
        result = eulerToQuaternion(0,90 + Math.toDegrees(theta), 0);

        /*
        if (target_num == 2) {
            result = eulerToQuaternion(0,90 + theta, 0);
        }
        else {
            result = new Quaternion(0f, 0f, -1f, (float)Math.cos(theta*0.5));
        }
        */

        return result;
    }

    public static Quaternion eulerToQuaternion(double x, double y, double z) {
        double yaw = Math.toRadians(z);
        double pitch = Math.toRadians(y);
        double roll = Math.toRadians(x);

        double cy = Math.cos(yaw * 0.5);
        double sy = Math.sin(yaw * 0.5);
        double cp = Math.cos(pitch * 0.5);
        double sp = Math.sin(pitch * 0.5);
        double cr = Math.cos(roll * 0.5);
        double sr = Math.sin(roll * 0.5);

        double qx = sr * cp * cy - cr * sp * sy;
        double qy = cr * sp * cy + sr * cp * sy;
        double qz = cr * cp * sy - sr * sp * cy;
        double qw = cr * cp * cy + sr * sp * sy;

        return new Quaternion((float) qx, (float) qy, (float) qz, (float) qw);
    }

    public static double findAverage(ArrayList<Double> arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        return sum / arr.size();
    }
}
