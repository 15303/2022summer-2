package org.firstinspires.ftc.teamcode.max;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name="MaxAuto")
public class MaxAuto extends LinearOpMode {
private Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(this);

        waitForStart();

        initialize();

        robot.lifter.setPower(0.3); //Lifting up the arm for hub
        sleep(300);
        robot.lifter.setPower(0);

        robot.drive(0.4); //Driving to hub carefully
        sleep(200);
        robot.drive(0.25);
        sleep(1500);

        robot.drive(0); //Offloading the game object onto the hub
        robot.grabber.setPower(1);
        sleep(4000);
        robot.grabber.setPower(0);

        sleep(4000); //Transition

        robot.drive(-0.35);//Turning and driving to be orientated toward the ball
        sleep(1000);
        robot.drive(0);
        robot.lifter.setPower(-0.3);//Reset the lifter
        sleep(300);
        robot.lifter.setPower(0);

        robot.turnDegrees(90);

        sleep(4000); //Transition

        robot.drive(-0.4); //Going to the carousel and spinning it
        sleep(1500);
        robot.drive(0);
        robot.spinCarousel(0.3);
        sleep(2500);
        robot.spinCarousel(1);
        sleep(1000);
        robot.spinCarousel(0);

        robot.drive(0.4); //To the end
        sleep(3000);


    }

    public void initialize() {
        robot.left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.lifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
}
