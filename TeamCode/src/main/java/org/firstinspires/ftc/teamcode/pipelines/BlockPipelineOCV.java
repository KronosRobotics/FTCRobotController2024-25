package org.firstinspires.ftc.teamcode.pipelines;

import static org.opencv.core.Core.inRange;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2HSV;
import static org.opencv.imgproc.Imgproc.cvtColor;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Scalar;
import org.opencv.core.MatOfPoint;

import java.util.ArrayList;
import java.util.List;

public class BlockPipelineOCV extends OpenCvPipeline {
    @Override
    public Mat processFrame(Mat inputMat) {
        Mat frameHSV = new Mat();
        cvtColor(inputMat, frameHSV, COLOR_BGR2HSV);
        Mat thresh = new Mat();
        int H_MIN = 110;
        int H_MAX = 160;
        int S_MIN = 0;
        int S_MAX = 70;
        int V_MIN = 110;
        int V_MAX = 256;
        // blue
        // inRange(frameHSV, new Scalar(0,50,70), new Scalar(50,255,255), thresh);
        // yellow
        // inRange(frameHSV, new Scalar(50, 90, 30), new Scalar(110, 255, 255), thresh);
        // red
        inRange(frameHSV, new Scalar(110, 90, 30), new Scalar(160, 255, 255), thresh);
        Mat returnImage = frameHSV.clone();
        Mat img_new = new Mat();
        returnImage.copyTo(img_new, thresh);
        Mat MatOfPoint = new Mat();
        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        Mat binaryMat = new Mat();
        Imgproc.cvtColor(returnImage, returnImage, Imgproc.COLOR_RGBA2GRAY);;
        Imgproc.findContours(thresh, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        Moments moments = Imgproc.moments(contours.get(0));
        return thresh;
    }
}
