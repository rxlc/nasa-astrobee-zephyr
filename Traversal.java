package jp.jaxa.iss.kibo.rpc.testing;

import java.util.ArrayList;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import gov.nasa.arc.astrobee.Result;
import java.util.List;

public class Traversal {
    public static ArrayList<State> returnTrajectory(int startId, int goalId) {
        //All computations done on: https://colab.research.google.com/drive/1DCgAljUgt8WrGdHzco6iFIpMWlBrGZ1r#scrollTo=DXh6oHjiYfnZ
        ArrayList<State> trajectory = new ArrayList<State>();

        if (startId == 0) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(10.845312500000007, -10.051562499999998, 4.852812500000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -10.051562499999998, 5.109062500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.460937500000005, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.460937500000005, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.396875000000005, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(10.653125000000006, -9.474999999999994, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -9.154687499999993, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
        }
        if (startId == 1) {
            if (goalId == 2) {
                trajectory.add(new State(new Point(11.16562500000001, -9.539062499999995, 4.9168750000000045), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.909375000000008, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.589062500000006, -6.84843749999998, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.29375000000001, -7.296874999999982, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 2) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.22968750000001, -9.603124999999995, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.653125000000006, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.653125000000006, -8.129687499999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.589062500000006, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.037500000000009, -8.193749999999987, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(10.781250000000007, -9.218749999999993, 4.596562500000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -9.218749999999993, 4.596562500000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(10.781250000000007, -8.57812499999999, 4.468437500000002), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(10.781250000000007, -8.57812499999999, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.845312500000007, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.909375000000008, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 3) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(10.781250000000007, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.717187500000007, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.717187500000007, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.717187500000007, -7.296874999999982, 4.852812500000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.717187500000007, -7.232812499999982, 4.9168750000000045), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(10.973437500000008, -7.617187499999984, 5.045000000000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.973437500000008, -7.617187499999984, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -7.681249999999984, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.16562500000001, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.16562500000001, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 4) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(10.781250000000007, -8.898437499999991, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.525000000000006, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.525000000000006, -7.232812499999982, 4.9168750000000045), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.525000000000006, -7.296874999999982, 4.852812500000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.037500000000009, -7.745312499999985, 4.980937500000005), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.22968750000001, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 5) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(11.037500000000009, -8.129687499999987, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.973437500000008, -8.193749999999987, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(11.037500000000009, -7.681249999999984, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.973437500000008, -7.617187499999984, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.781250000000007, -7.617187499999984, 4.596562500000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.101562500000009, -8.129687499999987, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -8.193749999999987, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 6) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.781250000000007, -9.026562499999992, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.973437500000008, -8.129687499999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.589062500000006, -6.84843749999998, 5.109062500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 7) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.781250000000007, -8.57812499999999, 4.468437500000002), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(11.16562500000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.973437500000008, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(11.16562500000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.35781250000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.35781250000001, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.193749999999987, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.16562500000001, -8.129687499999987, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.29375000000001, -8.514062499999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.449999999999989, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }

        return trajectory;
    }

    public static int returnDuration(int startId, int goalId) {
        if (startId == 0) {
            if (goalId == 1) return 30;
            if (goalId == 2) return 20;
            if (goalId == 6) return 26;
        }
        if (startId == 1) {
            if (goalId == 2) return 33;
            if (goalId == 3) return 46;
            if (goalId == 4) return 50;
            if (goalId == 5) return 29;
            if (goalId == 6) return 24;
        }
        if (startId == 2) {
            if (goalId == 1) return 33;
            if (goalId == 3) return 55;
            if (goalId == 4) return 55;
            if (goalId == 5) return 3;
            if (goalId == 6) return 31;
        }
        if (startId == 3) {
            if (goalId == 1) return 46;
            if (goalId == 2) return 55;
            if (goalId == 4) return 42;
            if (goalId == 5) return 52;
            if (goalId == 6) return 33;
        }
        if (startId == 4) {
            if (goalId == 1) return 50;
            if (goalId == 2) return 60;
            if (goalId == 3) return 42;
            if (goalId == 5) return 27;
            if (goalId == 6) return 50;
        }
        if (startId == 5) {
            if (goalId == 1) return 30;
            if (goalId == 2) return 3;
            if (goalId == 3) return 52;
            if (goalId == 4) return 27;
            if (goalId == 6) return 23;
        }
        if (startId == 6) {
            if (goalId == 1) return 24;
            if (goalId == 2) return 31;
            if (goalId == 3) return 33;
            if (goalId == 4) return 50;
            if (goalId == 5) return 23;
        }

        return 50;
    }

    public static int findClosest(int startId, List<Integer> options) {
        int lowest = 100;
        int lowestIndex = 0;

        for (int i=0; i<options.size(); i++) {
            if (returnDuration(startId, options.get(i)) < lowest) {
                lowest = returnDuration(startId, options.get(i));
                lowestIndex = i;
            }
        }

        return options.get(lowestIndex);
    }
}
