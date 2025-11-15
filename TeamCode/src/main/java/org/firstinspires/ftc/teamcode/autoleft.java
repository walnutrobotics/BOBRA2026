package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "autoleft", group = "1")
public class autoleft extends LinearOpMode {
    public DcMotor r1 = null;
    public DcMotor r2 = null;
    public DcMotor l1 = null;
    public DcMotor l2 = null;

    public double powermultiplier = 0.15;

    @Override
    public void runOpMode() throws InterruptedException {
        r1 = hardwareMap.get(DcMotor.class, "r1");
        r2 = hardwareMap.get(DcMotor.class, "r2");
        l1 = hardwareMap.get(DcMotor.class, "l1");
        l2 = hardwareMap.get(DcMotor.class, "l2");

        waitForStart();

        if (opModeIsActive()) {
            moveleft(0.5,7000);

        }
    }
    public void moveleft(double power, long time) {
        r1.setPower(-power);
        r2.setPower(-power);
        l1.setPower(power);
        l2.setPower(power);

        sleep(time);
    }

}