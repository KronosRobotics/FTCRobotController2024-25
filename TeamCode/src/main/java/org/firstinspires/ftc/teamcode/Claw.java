package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Claw {

    private Servo clawServo;
    private static final double OPEN_POSITION = 1.0;
    private static final double CLOSE_POSITION = 0.0;
    
    public Claw(HardwareMap hardwareMap, String servoName) {
        clawServo = hardwareMap.get(Servo.class, servoName);
    }

    public class ClawOpen implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            clawServo.setPosition(OPEN_POSITION);
            return false;
        }
    }

    public class ClawClose implements Action{
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            clawServo.setPosition(CLOSE_POSITION);
            return false;
        }
    }

    public Action OpenClaw() {
        return new ClawOpen();
    }

    public Action CloseClaw() {
        return new ClawClose();
    }
}
