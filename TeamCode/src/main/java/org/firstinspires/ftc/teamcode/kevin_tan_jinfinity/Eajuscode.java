package org.firstinspires.ftc.teamcode.kevin_tan_jinfinity;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="Eajuscode")
public class Eajuscode extends LinearOpMode {
    private Robot robot;


    @Override
    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();
        robot.drive(0.6,0.6);
        sleep(500);
        //drive to alliance shipping hub
        robot.drive(0);
        robot.lift(0.5);
        sleep(750);
        //lift arm
        robot.drive(0.25,0.25);
        sleep(250);
        //precision
        robot.drive(0);
        robot.grab(-1);
        sleep(250);
        robot.grab(0);
        //drop element
        robot.drive(-0.5,-0.3);
        sleep(500);
        robot.drive(0);
        robot.drive(-0.5);
        sleep(300);
        robot.drive(0);
        robot.spinCarousel(0.3);
        sleep(3000);
        robot.drive(0.4);
        sleep(3000);
        robot.drive(0);
    }

    public void dlkfjioasdhfopus(int x, Robot y) {
        y.drive(x);
    }
}

