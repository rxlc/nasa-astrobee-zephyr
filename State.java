package jp.jaxa.iss.kibo.rpc.testing;

import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;

public class State {
    private Point point;
    private Quaternion quaternion;

    public State(Point newPoint, Quaternion newQuaternion) {
        point = newPoint;
        quaternion = newQuaternion;
    }

    public Point getPoint() {
        return point;
    }

    public Quaternion getQuaternion() {
        return quaternion;
    }
}
