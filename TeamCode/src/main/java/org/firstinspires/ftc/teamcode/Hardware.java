package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public DcMotor right_motor, left_motor, pixel_dropper, samMotor;
    public Servo gusServo, fringServo, silly;

    public Hardware(HardwareMap hardwareMap) {
        right_motor = hardwareMap.dcMotor.get("leftMotor");
        left_motor = hardwareMap.dcMotor.get("rightMotor");
        pixel_dropper = hardwareMap.dcMotor.get("flintLockwoodMotor");

        samMotor = hardwareMap.dcMotor.get("samMotor");
        gusServo = hardwareMap.get(Servo.class,"gus");
        fringServo = hardwareMap.get(Servo.class, "fring");
        silly = hardwareMap.get(Servo.class, "silly");
    }
}
