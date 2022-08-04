package org.firstinspires.ftc.teamcode.Victoria;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="VictoriaAuto")
public class VictoriaAuto extends LinearOpMode {
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
        sleep(1000);

        robot.spinCarousel(0);
        sleep(600);
        robot.drive(0.6);
        sleep(700);
        robot.turnDegrees(105);
        sleep(100);
        robot.drive(0.4);
        sleep(100);
        robot.lift(0.3);
        sleep(600);
        robot.grab(1);
        sleep(2000);
        robot.grab(0);
        robot.drive(-0.4);
        sleep(500);
        robot.turnDegrees(100);
        sleep(500);
        robot.drive(0.6);
        sleep(5000);
        robot.drive(0);



    }
}
