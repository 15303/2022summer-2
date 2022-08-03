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

        robot.drive(-0.5, 0.5);
        sleep(500);
        robot.drive(0, 0);
        robot.lift(0.5);
        sleep(300);
        robot.lift(0);
        robot.grab(-1);
        sleep(2000);
        robot.grab(0);

    }
}
