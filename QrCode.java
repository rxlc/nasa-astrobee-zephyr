package jp.jaxa.iss.kibo.rpc.testing;

import org.opencv.aruco.Aruco;
import org.opencv.aruco.Dictionary;
import org.opencv.core.Mat;
import org.opencv.objdetect.QRCodeDetector;

import android.util.Log;

public class QrCode {
    public static void main(String[] args) {

    }

    public static String readQRCode(Mat image) {
        QRCodeDetector qrCodeDetector = new QRCodeDetector();
        String qrContent = qrCodeDetector.detectAndDecode(image);
        String reportContent;

        Log.i("qrContent", qrContent);

        switch (qrContent) {
            case "JEM":
                reportContent = "STAY_AT_JEM";
                break;
            case "COLUMBUS":
                reportContent = "GO_TO_COLUMBUS";
                break;
            case "RACK1":
                reportContent = "CHECK_RACK_1";
                break;
            case "ASTROBEE":
                reportContent = "I_AM_HERE";
                break;
            case "INTBALL":
                reportContent = "LOOKING_FORWARD_TO_SEE_YOU";
                break;
            case "BLANK":
                reportContent = "NO_PROBLEM";
                break;
            default:
                reportContent = "";
                break;
        }

        return reportContent;
    }
}
