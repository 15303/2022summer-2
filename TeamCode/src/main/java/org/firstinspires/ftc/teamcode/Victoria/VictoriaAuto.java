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
        robot.spinCarousel(0.3);
        sleep(800);
        robot.spinCarousel(0.6);
        sleep(500);
        robot.spinCarousel(0);
    }
}