package org.firstinspires.ftc.teamcode.kevin_tan_jinfinity;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

//hi


@TeleOp(name="eid")
public class eaj extends LinearOpMode {
    private Robot robot; //store the robot

    public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        //so we want something that runs coninuously we do that using a while loop
        while (opModeIsActive()) {
            //normally gamepad1.right_stick_y is reversed, so we make it negative
            int x = 0;
            double drive;
            double turn;
            if (x == 0) {
                drive = -gamepad1.right_stick_y * 0.5;
                 turn = gamepad1.right_stick_x * 0.5;
            }
            else if (x == 1) {
                drive = -gamepad1.right_stick_y * 0.75;
                turn = gamepad1.right_stick_x * 0.75;
            }
            else {
                drive = -gamepad1.right_stick_y;
                turn = gamepad1.right_stick_x;
            }
            robot.driveComponent(drive, turn); //power the drive motors given the joystick controls
            if (gamepad1.left_bumper) {
                if (x > 2) {
                    x = 0;
                }
                else {
                    x++;
                }
            }
            robot.aim(gamepad2.left_stick_x);
            robot.lift(-gamepad2.left_stick_y);
            robot.spinCarousel(gamepad2.right_trigger - gamepad2.left_trigger);

            if (gamepad2.a) {
                robot.grab(1);
            } else if (gamepad2.b) {
                robot.grab(-1);
            } else {
                robot.grab(0);
            }
        }
    }

}
