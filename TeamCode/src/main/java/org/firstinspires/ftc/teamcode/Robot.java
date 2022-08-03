package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
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

    public BNO055IMU imu;

    private LinearOpMode opMode;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;


        initMotors();
        initServos();
        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
    }

    public void initMotors() {
        left = opMode.hardwareMap.get(DcMotor.class, "left");
        right = opMode.hardwareMap.get(DcMotor.class, "right");
        carousel = opMode.hardwareMap.get(DcMotor.class, "carousel");
        aimer = opMode.hardwareMap.get(DcMotor.class, "aimer");
        lifter = opMode.hardwareMap.get(DcMotor.class, "lifter");

        left.setDirection(DcMotor.Direction.REVERSE);

        lifter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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

    public void turnDegrees(float degrees) {
        float initial = getOrientation();
        float target = initial + degrees;
        float diff = diff(target, getOrientation());
        while (Math.abs(diff) > 5) {
            diff = diff(target, getOrientation());
            turn(diff > 0 ? 0.5 : -0.5);
            opMode.sleep(10);
        }
    }

    public float getOrientation() {
        return imu.getAngularOrientation().firstAngle;
    }

    private float diff(float angle1, float angle2) {
        float res = angle1 - angle2;
        res %= 360;
        if (res > 180) {
            res -= 360;
        } else if (res < -180) {
            res += 360;
        }
        return res;
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
