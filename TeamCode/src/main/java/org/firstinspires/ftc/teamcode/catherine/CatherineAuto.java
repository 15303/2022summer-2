package org.firstinspires.ftc.teamcode.catherine;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="CatherineAuto")
public class CatherineAuto extends LinearOpMode {
    private Robot robot;


    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();

        robot.drive(-0.5);
        sleep(500);
        robot.drive(0);
        sleep(300);
        robot.spinCarousel(.2);
        sleep(1000);
        robot.spinCarousel(.4);
        sleep(2000);
        robot.spinCarousel(0);
        sleep(500);
        robot.drive(0.5);
        sleep(500);
        robot.turnDegrees(100);
        sleep(1000);
        robot.lift(0.3);
        sleep(400);
        robot.lift(0);
        robot.drive(0.3);
        sleep(400);
        robot.drive(0);
        robot.grab(1);
        sleep(3000);
        robot.grab(0);
        robot.drive(-0.3);
        sleep(400);
        robot.drive(0);

        robot.turnDegrees(100);
        sleep(500);
        robot.drive(0.6);
        sleep(5000);
        robot.drive(0);


    }
}