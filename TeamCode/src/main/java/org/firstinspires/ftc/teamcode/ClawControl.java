package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawControl {

    private Servo clawServo;
    private static final double OPEN_POSITION = 1.0; // Adjust as needed
    private static final double CLOSE_POSITION = 0.0; // Adjust as needed

    public ClawControl(HardwareMap hardwareMap, String servoName) {
        clawServo = hardwareMap.get(Servo.class, servoName);
    }

    public void openClaw() {
        clawServo.setPosition(OPEN_POSITION);
    }

    public void closeClaw() {
        clawServo.setPosition(CLOSE_POSITION);
    }
}
