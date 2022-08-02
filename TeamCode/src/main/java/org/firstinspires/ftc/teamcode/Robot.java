package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.lang.reflect.Field;

public class Robot {
    public DcMotor left, right;
    public DcMotor carousel;
    public DcMotor aimer;
    public DcMotor lifter;

    public CRServo grabber;

    private OpMode opMode;

    public Robot(OpMode opMode) {
        this.opMode = opMode;


        initMotors();
        initServos();
    }

    public void initMotors() {
        left = opMode.hardwareMap.get(DcMotor.class, "left");
        right = opMode.hardwareMap.get(DcMotor.class, "right");
        carousel = opMode.hardwareMap.get(DcMotor.class, "carousel");
        aimer = opMode.hardwareMap.get(DcMotor.class, "aimer");
        lifter = opMode.hardwareMap.get(DcMotor.class, "lifter");

        left.setDirection(DcMotor.Direction.REVERSE);

        lifter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void initServos() {
        grabber = opMode.hardwareMap.get(CRServo.class, "grabber");
    }

    public void drive(double l, double r) {
        left.setPower(l);
        right.setPower(r);
    }

    public void drive(double power) {
        drive(power, power);
    }

    public void turn(double power) {
        drive(power, -power);
    }

    public void driveComponent(double drive, double turn) {
        drive(drive + turn, drive - turn);
    }

    public void spinCarousel(double power) {
        carousel.setPower(power);
    }

    public void aim(double power) {
        aimer.setPower(power);
    }

    public void lift(double power) {
        lifter.setPower(power);
    }

    public void grab(double power) {
        grabber.setPower(power);
    }

}
