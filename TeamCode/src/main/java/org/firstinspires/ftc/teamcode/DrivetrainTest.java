package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="DrivetrainTest")
public class DrivetrainTest extends LinearOpMode {
    DcMotor left;
    DcMotor right;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        left.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            double drive = -gamepad1.right_stick_y - 0.4 * gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x + 0.4 * gamepad1.left_stick_x;

            left.setPower(drive + turn);
            right.setPower(drive - turn);
        }
    }
}
