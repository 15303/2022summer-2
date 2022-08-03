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
        robot.spinCarousel(.3);
        sleep(1000);
        robot.spinCarousel(.6);
        sleep(1000);
        robot.spinCarousel(0);
        sleep(500);
        robot.drive(0.6);
        sleep(700);
        robot.turnDegrees(90);
        robot.drive(0.4);
        sleep(600);
        robot.lift(0.15);
        sleep(600);





    }
}