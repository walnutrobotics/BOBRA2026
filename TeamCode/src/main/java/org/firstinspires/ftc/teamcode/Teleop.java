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

    DcMotor shooterleft;
    DcMotor shooterright;
    CRServo bleft;
    CRServo bright;

    double SpeedMultiplier = 0.75;


    @Override
    public void runOpMode() throws InterruptedException {

        r1 = hardwareMap.get(DcMotor.class,"r1");
        r2 = hardwareMap.get(DcMotor.class,"r2");
        l1 = hardwareMap.get(DcMotor.class,"l1");
        l2 = hardwareMap.get(DcMotor.class,"l2");

        intake = hardwareMap.get(DcMotor.class,"intake");

        shooterleft = hardwareMap.get(DcMotor.class,"shooterleft");
        shooterright = hardwareMap.get(DcMotor.class, "shooterright");

        bleft = hardwareMap.get(CRServo.class, "bleft");
        bright = hardwareMap.get(CRServo.class, "bright");


        waitForStart();
        while(!isStopRequested()) {
            //drive code forward and back
            r1.setDirection(DcMotorSimple.Direction.REVERSE);
            r2.setDirection(DcMotorSimple.Direction.REVERSE);
            if (gamepad1.left_stick_y>0) {
                r1.setPower(gamepad1.left_stick_y);
                r2.setPower(gamepad1.left_stick_y);
                l1.setPower(-gamepad1.left_stick_y);
                l2.setPower(gamepad1.left_stick_y);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }

            //forward
            if (gamepad1.left_stick_y<0) {
                r1.setPower(-gamepad1.left_stick_y);
                r2.setPower(-gamepad1.left_stick_y);
                l1.setPower(gamepad1.left_stick_y);
                l2.setPower(-gamepad1.left_stick_y);
            }
            else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }
            //left turn
            if (gamepad1.left_stick_x>0) {
                r1.setPower(-gamepad1.left_stick_x);
                r2.setPower(-gamepad1.left_stick_x);
                l1.setPower(-gamepad1.left_stick_x);
                l2.setPower(gamepad1.left_stick_x);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(0);
            }

            if (gamepad1.left_stick_x<0) {
                r1.setPower(gamepad1.left_stick_x);
                r2.setPower(gamepad1.left_stick_x);
                l1.setPower(gamepad1.left_stick_x);
                l2.setPower(-gamepad1.left_stick_x);
            } else {
                r1.setPower(0);
                r2.setPower(0);
                l1.setPower(0);
                l2.setPower(-0);
            }

            //Turn Right
            if (gamepad1.right_trigger > 0.5) {
                r1.setPower(1);
                r2.setPower(-1);
                l1.setPower(1);
                l2.setPower(-1);
            }

            //Turn Left
            if (gamepad1.left_trigger > 0.5) {
                l1.setPower(-1);
                l2.setPower(1);
                r1.setPower(-1);
                r2.setPower(-1);

            }
            //Push Ball In
            if (gamepad2.right_trigger > 0.5) {
                intake.setPower(1);
            } else {
                intake.setPower(0);
            }

            if (gamepad2.left_trigger>0.5) {
                shooterright.setPower(-1);
                shooterleft.setPower(1);
                bleft.setPower(-1);
                bright.setPower(1);
            } else {
                shooterright.setPower(0);
                shooterleft.setPower(0);
                bleft.setPower(0);
                bright.setPower(0);
            }



        }
    }
}