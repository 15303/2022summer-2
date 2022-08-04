package org.firstinspires.ftc.teamcode.catherine;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="CatherineTeleOp")
public class CatherineTeleOp extends LinearOpMode {
    private Robot robot; //store the robot

     public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        //so we want something that runs coninuously we do that using a while loop
        while (opModeIsActive()) {
            //normally gamepad1.right_stick_y is reversed, so we make it negative
            double drive = -gamepad1.right_stick_y * 0.4;
            double turn = gamepad1.right_stick_x * 0.4;
            robot.driveComponent(drive, turn); //power the drive motors given the joystick controls

            robot.aim(gamepad2.left_stick_x * 0.3);
            robot.lift(-gamepad2.right_stick_y * 0.3);
            robot.spinCarousel(gamepad1.right_trigger - gamepad1.left_trigger);

            if (gamepad2.a) {
                robot.grab(1);
            } else if (gamepad2.b) {
                robot.grab(-1);
            } else if (gamepad2.right_trigger>0){
                robot.grab(0);
            }
        }
    }

}
