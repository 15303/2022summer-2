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
        sleep(400);
        robot.lift(0);
        robot.drive(0.45);
        sleep(650);
        robot.drive(0);
        robot.lift(-0.25);
        sleep(300);
        robot.lift(0);
        robot.grab(1);
        sleep(4000);
        robot.grab(0);

        robot.drive(-0.45);
        sleep(600);
        robot.drive(0);
        robot.drive(0, 0.5);
        sleep(700);
        robot.drive(0, 0);
        robot.drive(-0.35);
        sleep(3000);
        robot.drive(0);
        robot.spinCarousel(0.5);
        sleep(4000);
        robot.spinCarousel(0);

        robot.drive(0, 0.5);
        sleep(400);
        robot.drive(0.5);
        sleep (7000);
    }
}
