package org.firstinspires.ftc.teamcode.charles;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="CharlesAuto")
public class CharlesAuto extends LinearOpMode {
    private Robot robot;

    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();

        robot.drive(-0.5);
        sleep(500);
        robot.drive(0);
    }
}
