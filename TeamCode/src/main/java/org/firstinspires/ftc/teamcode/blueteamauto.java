package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "blueteam", group = "1")
public class blueteamauto extends LinearOpMode {
    public DcMotor r1 = null;
    public DcMotor r2 = null;
    public DcMotor l1 = null;
    public DcMotor l2 = null;

    public DcMotor gear;

    @Override
    public void runOpMode() throws InterruptedException {
        r1 = hardwareMap.get(DcMotor.class, "r1");
        r2 = hardwareMap.get(DcMotor.class, "r2");
        l1 = hardwareMap.get(DcMotor.class, "l1");
        l2 = hardwareMap.get(DcMotor.class, "l2");
        gear = hardwareMap.get(DcMotor.class,"gear");

        waitForStart();

        if (opModeIsActive()) {
            forward(1000);
            sleep(1000);
            stopDrive();
            left(35);
            sleep(1000);
            stopDrive();
            launch(1500);
        }
    }
    public void stopDrive() {
        r1.setPower(0);
        r2.setPower(0);
        l1.setPower(0);
        l2.setPower(0);
    }
    public void forward(long time) {
        r1.setPower(1);
        r2.setPower(-1);
        l1.setPower(1);
        l2.setPower(1);

        sleep(time);
        stopDrive();
    }
    public void left(long time) {
        r1.setPower(1);
        r2.setPower(-1);
        l1.setPower(-1);
        l2.setPower(-1);

        sleep(time);
        stopDrive();
    }
    public void launch(long time) {
        gear.setPower(-1);
        sleep(time);
        stopDrive();
    }

}