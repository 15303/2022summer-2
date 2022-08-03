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
        robot.drive(0);
        robot.lift(0.5);
        sleep(750);
        robot.drive(0.4,0.40);
        sleep(250);
        robot.drive(0);
        robot.grab(-1);
        sleep(250);
        robot.grab(0);
        robot.drive(-0.7,-0.3);
        sleep(400);
        robot.drive(0);
        robot.drive(-0.5);
        sleep(700);
        robot.drive(0);
        robot.spinCarousel(-0.3);
        sleep(1000);
        robot.drive(0.7);
        sleep(3000);
        robot.drive(0);
    }
}
