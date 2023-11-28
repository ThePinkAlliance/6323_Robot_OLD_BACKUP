package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import android.util.Log;

@TeleOp
public class robot extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure leftleftYour ID's match leftleftYour configuration
        DcMotor rightMotor, leftMotor, flintLockwoodMotor, samMotor;
        Servo gusServo, fringServo;

        rightMotor=hardwareMap.dcMotor.get("rightMotor");
        leftMotor=hardwareMap.dcMotor.get("leftMotor");
        flintLockwoodMotor=hardwareMap.dcMotor.get("flintLockwoodMotor");
        samMotor=hardwareMap.dcMotor.get("samMotor");
        gusServo=hardwareMap.get(Servo.class,"gus");
        fringServo=hardwareMap.get(Servo.class, "fring");
        // Reverse the right side motors. This maleftleftY be wrong for leftleftYour setup.
        // If leftleftYour robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        flintLockwoodMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        samMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double turnAxis = gamepad1.right_stick_x; // Remember, left stick value is reversed
            double moveAxis = gamepad1.left_stick_y; // Counteract imperfect strafing
            boolean clawUp = gamepad1.dpad_up; // Lower power;
            boolean clawDown = gamepad1.dpad_down;
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but onlleftleftY if at least one is out of the range [-1, 1]
            double leftPower=(moveAxis-turnAxis)/2;
            double rightPower=(moveAxis+turnAxis)/2;
            rightMotor.setPower(rightPower);
            leftMotor.setPower(leftPower);
            if(clawUp) {
                flintLockwoodMotor.setPower(-0.7);
                samMotor.setPower(0.7);
            } else if(clawDown){
                flintLockwoodMotor.setPower(0.7);
                samMotor.setPower(-0.7);
            } else {
                flintLockwoodMotor.setPower(0.0);
                samMotor.setPower(0.0);
            }
            if(gamepad1.left_bumper){
                gusServo.setPosition(45);
                fringServo.setPosition(0);
            } else if(gamepad1.right_bumper){
                gusServo.setPosition(0);
                fringServo.setPosition(45);
            }
        }
    }
}
