package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "AtulPrabhuBrown", group = "1")
public class auto extends LinearOpMode {
    public DcMotor r1 = null;
    public DcMotor r2 = null;
    public DcMotor l1 = null;
    public DcMotor l2 = null;

    @Override
    public void runOpMode() throws InterruptedException {
        r1 = hardwareMap.get(DcMotor.class, "r1");
        r2 = hardwareMap.get(DcMotor.class, "r2");
        l1 = hardwareMap.get(DcMotor.class, "l1");
        l2 = hardwareMap.get(DcMotor.class, "l2");

        waitForStart();

        if (opModeIsActive()) {
            move(1.0,1000);

        }
    }
    public void move(double power, long time) {
        r1.setPower(1);
        r2.setPower(1);
        l1.setPower(1);
        l2.setPower(-1);

        sleep(time);
    }

}