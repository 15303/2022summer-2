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
        // ay this is good code the carousel is very good//
        //now we're leaving the carousel//
        sleep(500);
        robot.drive(0.5);
        sleep(1300);
        robot.turnDegrees(90);
        sleep(1000);
        robot.lift(0.3);
        sleep(500);
        robot.lift(0);
        sleep(500);
        robot.drive(0.3);
        sleep(900);
        robot.drive(0);
        sleep(800);
        robot.lift(-0.3);
        robot.grab(1);
        sleep(400);
        robot.lift(0);
        sleep(2800);
        robot.grab(0);
        robot.drive(-0.3);
        sleep(900);
        robot.drive(0);
        //warehouse parking fr//
        robot.turnDegrees(-95);
        sleep(1000);
        robot.drive(0.4);
        sleep(3000);
        robot.drive(0);

//hi//
    }
}