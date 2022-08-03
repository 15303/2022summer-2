package org.firstinspires.ftc.teamcode.alex;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "AlexAuto")
public class AlexAuto extends LinearOpMode {
    private Robot robot;

    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();
        robot.lift(0.3);
        sleep(600);
        robot.lift(0);
        robot.drive(0.49);
        sleep(600);
        robot.drive(0);
        robot.lift(-0.2);
        sleep(100);
        robot.lift(0);
        robot.grab(1);
        sleep(4000);
        robot.grab(0);
    }
}
