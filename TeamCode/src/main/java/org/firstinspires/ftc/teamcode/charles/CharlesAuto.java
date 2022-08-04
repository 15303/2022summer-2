package org.firstinspires.ftc.teamcode.charles;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="CharlesAuto")
public class CharlesAuto extends LinearOpMode {
    private Robot robot;

    public void runOpMode() {
        robot = new Robot(this);
        robot.enableDriveEncoders();

        waitForStart();

        robot.turnDegrees(90);
        sleep(10000);

//        robot.drive(-0.5);
//        sleep(500);
//        robot.drive(0);
//        robot.spinCarousel(0.5);
//        sleep(3000);
//        robot.spinCarousel(0);
//        robot.turnDegrees(45);
//        sleep(100);
        robot.driveFor(0.75, 300);
    }
}
