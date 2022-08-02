package org.firstinspires.ftc.teamcode.alex;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="AlexTeleOp")
public class AlexTeleOp extends LinearOpMode {
    private Robot robot; //store the robot

    public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        //so we want something that runs continuously we do that using a while loop
        while (opModeIsActive()) {
            //normally gamepad1.right_stick_y is reversed, so we make it negative
            double drive = -gamepad1.right_stick_y * 0.5;
            double turn = gamepad1.right_stick_x * 0.5;
            double driveSlow = -gamepad1.left_stick_y * 0.25;
            double turnSlow = gamepad1.left_stick_x * 0.25;
            robot.driveComponent(drive + driveSlow, turn + turnSlow); //power the drive motors given the joystick controls

            float left_stick_x = gamepad2.left_stick_x;
            robot.aim( left_stick_x * 0.3);
            float left_stick_y = gamepad2.left_stick_y;
            robot.lift(left_stick_y * 0.4);
            robot.spinCarousel(gamepad2.right_trigger - gamepad2.left_trigger);

            if (gamepad2.a) {
                robot.grab(1);
            } else if (gamepad2.b) {
                robot.grab(-1);
            } else if (gamepad2.right_bumper) {
                robot.grab(0);
            }
        }
    }

}
