package org.firstinspires.ftc.teamcode.pipelines;

import static org.opencv.core.Core.inRange;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2HSV;
import static org.opencv.imgproc.Imgproc.cvtColor;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.opencv.core.Scalar;

public class BlockPipeline extends OpenCvPipeline {
    //TODO: Actually implement once Sid gets blocks
    @Override
    public Mat processFrame(Mat inputMat) {
        Mat frameHSV = new Mat();
        Imgproc.cvtColor(inputMat, frameHSV, Imgproc.COLOR_BGR2HSV);
        Mat thresh = new Mat();
        cvtColor(inputMat, frameHSV, COLOR_BGR2HSV);
        inRange(frameHSV, new Scalar(0, 50, 50), new Scalar(30, 255, 255), thresh);
        // Just returns contours rn
        return frameHSV;
    }

    public String getAnalysis() {
        return "";
    }
}
