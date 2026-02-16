package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name  = "teleop1", group = "1")
public class Teleop extends LinearOpMode {

    DcMotor r1;
    DcMotor r2;
    DcMotor l1;
    DcMotor l2;
    DcMotor intake;

    DcMotor gear;


    double SpeedMultiplier = 0.75;


    @Override
    public void runOpMode() throws InterruptedException {

        r1 = hardwareMap.get(DcMotor.class,"r1");
        r2 = hardwareMap.get(DcMotor.class,"r2");
        l1 = hardwareMap.get(DcMotor.class,"l1");
        l2 = hardwareMap.get(DcMotor.class,"l2");

        intake = hardwareMap.get(DcMotor.class,"intake");

        gear = hardwareMap.get(DcMotor.class,"gear");

        waitForStart();
        while(!isStopRequested()) {
            //drive code forward and back
            r1.setDirection(DcMotorSimple.Direction.REVERSE);
            r2.setDirection(DcMotorSimple.Direction.REVERSE);
            //backward
            if (gamepad1.dpad_down) {
                r1.setPower(1);
                r2.setPower(-1);
                l1.setPower(-1);
                l2.setPower(-1);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }

            //forward
            if (gamepad1.dpad_up) {
                r1.setPower(-1);
                r2.setPower(1);
                l1.setPower(1);
                l2.setPower(1);
            }
            else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }
            //left turn
            if (gamepad1.dpad_left) {
                r1.setPower(-1);
                r2.setPower(1);
                l1.setPower(-1);
                l2.setPower(-1);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }
            //right turn
            if (gamepad1.dpad_right) {
                r1.setPower(1);
                r2.setPower(-1);
                l1.setPower(1);
                l2.setPower(1);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(-0);
            }

            //Push Ball Inside
            if (gamepad2.right_bumper) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }
            if (gamepad2.left_bumper) {
                intake.setPower(-1);
            } else {
                intake.setPower(0);
            }

            //launch!
            if (gamepad2.left_trigger>0.5) {
                gear.setPower(1);
            } else {
                gear.setPower(0);
                gear.setPower(0);
            }
            if (gamepad2.right_trigger > 0.5) {
                gear.setPower(-1);
            } else {
                gear.setPower(0);
            }
            if (gamepad2.a) {
                gear.setPower(0.2);
            } else {
                gear.setPower(0);
            }


            //pull back!

        }
    }
}