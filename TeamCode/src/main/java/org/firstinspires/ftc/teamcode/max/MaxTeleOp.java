package org.firstinspires.ftc.teamcode.max;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="MaxTeleOp")
public class MaxTeleOp extends LinearOpMode {
    private Robot robot; //store the robot

    public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        //so we want something that runs coninuously we do that using a while loop
        while (opModeIsActive()) {
            //normally gamepad1.right_stick_y is reversed, so we make it negative
            double drive = -gamepad1.right_stick_y * 0.6;
            double turn = gamepad1.right_stick_x * 0.6;
            robot.driveComponent(drive, turn); //power the drive motors given the joystick controls

            robot.aim(gamepad1.left_stick_x * 0.5);
            robot.lift(-gamepad1.left_stick_y * 0.5);
            robot.spinCarousel(gamepad1.right_trigger - gamepad1.left_trigger);

            if (gamepad1.a) {
                robot.grab(1);
            } else if (gamepad1.b) {
                robot.grab(-1);
            } else {
                robot.grab(0);
            }
        }
    }

}
