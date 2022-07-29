package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="RobotTest")
public class RobotTest extends LinearOpMode {
    private Robot robot; //store the robot

    public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        robot.left.setPower(0.5); //turn on the left motor
        robot.right.setPower(0.5); //turn on the right motor

        sleep(1000);

        if (gamepad1.a) {
            //this code in the curly braces will only be run if the a button is pressed down
            //except that this method only runs once so you would have to be holding down the a button
            //at the very beginning to run this code once

        }
        //so we want something that runs coninuously we do that using a while loop
        while (opModeIsActive()) {
            double eaj = -gamepad1.right_stick_y;

        }
    }

}
