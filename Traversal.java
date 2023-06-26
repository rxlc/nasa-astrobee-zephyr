package jp.jaxa.iss.kibo.rpc.testing;

import java.util.ArrayList;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import gov.nasa.arc.astrobee.Result;

public class Traversal {
    public ArrayList<State> returnTrajectory(int startId, int goalId) {
        //All computations done on: https://colab.research.google.com/drive/1DCgAljUgt8WrGdHzco6iFIpMWlBrGZ1r#scrollTo=DXh6oHjiYfnZ
        ArrayList<State> trajectory = new ArrayList<State>();

        if (startId == 0) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(10.781250000000007, -9.859374999999996, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.845312500000007, -9.923437499999997, 4.852812500000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.653125000000006, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.653125000000006, -8.193749999999987, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.396875000000005, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
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
                trajectory.add(new State(new Point(11.16562500000001, -8.898437499999991, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
        }
        if (startId == 1) {
            if (goalId == 2) {
                trajectory.add(new State(new Point(11.037500000000009, -9.667187499999995, 5.109062500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.781250000000007, -7.873437499999985, 4.596562500000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
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
                trajectory.add(new State(new Point(11.29375000000001, -7.1687499999999815, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 2) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.29375000000001, -9.859374999999996, 5.237187500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.653125000000006, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.653125000000006, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.589062500000006, -8.193749999999987, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(10.973437500000008, -9.026562499999992, 4.788750000000004), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(10.845312500000007, -8.83437499999999, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -8.70624999999999, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(10.909375000000008, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 3) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(10.717187500000007, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.717187500000007, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.717187500000007, -8.449999999999989, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(10.973437500000008, -7.681249999999984, 5.109062500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.037500000000009, -7.745312499999985, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.101562500000009, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.22968750000001, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.369, -8.5518, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }
        if (startId == 4) {
            if (goalId == 1) {
                trajectory.add(new State(new Point(11.2746, -9.92284, 5.2988), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
            if (goalId == 2) {
                trajectory.add(new State(new Point(10.525000000000006, -8.898437499999991, 4.596562500000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.22968750000001, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.29375000000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
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
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.973437500000008, -7.745312499999985, 5.173125000000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.909375000000008, -7.681249999999984, 5.109062500000006), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 7) {
                trajectory.add(new State(new Point(11.35781250000001, -8.57812499999999, 4.532500000000002), new Quaternion(0, 0, -0.707f, 0.707f)));
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
                trajectory.add(new State(new Point(10.781250000000007, -9.026562499999992, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(10.973437500000008, -8.257812499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
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
                trajectory.add(new State(new Point(10.973437500000008, -8.962499999999991, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.845312500000007, -8.962499999999991, 4.340312500000001), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.612, -9.0709, 4.48), new Quaternion(0.5f, 0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 3) {
                trajectory.add(new State(new Point(11.16562500000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.101562500000009, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.973437500000008, -8.193749999999987, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.71, -7.7, 4.48), new Quaternion(0, 0.707f, 0, 0.707f)));
            }
            if (goalId == 4) {
                trajectory.add(new State(new Point(11.29375000000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.22968750000001, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(10.51, -6.7185, 5.1804), new Quaternion(0, 0, -1, 0)));
            }
            if (goalId == 5) {
                trajectory.add(new State(new Point(11.22968750000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.114, -7.9756, 5.3393), new Quaternion(-0.5f, -0.5f, -0.5f, 0.5f)));
            }
            if (goalId == 6) {
                trajectory.add(new State(new Point(11.355, -8.9929, 4.7818), new Quaternion(0, 0, 0, 1)));
            }
            if (goalId == 8) {
                trajectory.add(new State(new Point(11.35781250000001, -8.449999999999989, 4.660625000000003), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.35781250000001, -8.385937499999988, 4.7246875000000035), new Quaternion(0, 0, -0.707f, 0.707f)));
                trajectory.add(new State(new Point(11.143, -6.7607, 4.9654), new Quaternion(0, 0, -0.707f, 0.707f)));
            }
        }

        return trajectory;
    }
}
