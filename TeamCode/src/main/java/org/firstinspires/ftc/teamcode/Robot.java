package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import java.lang.reflect.Field;

public class Robot {
    public DcMotor left, right;
    public DcMotor carousel;
    public DcMotor aimer;
    public DcMotor lifter;

    public CRServo grabber;

    public ColorRangeSensor sensor;
    public BNO055IMU imu;

    private LinearOpMode opMode;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;


        initMotors();
        initServos();
        imu = opMode.hardwareMap.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(parameters);
        sensor = opMode.hardwareMap.get(ColorRangeSensor.class, "sensor");
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

    public void enableDriveEncoders() {
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double l, double r) {
        left.setPower(l);
        right.setPower(r);
    }

    public void drive(double power) {
        drive(power, power);
    }

    public void driveFor(double maxPower, int distance) {
        int initialPos = getCurrentDrivePos();
        int targetPos = initialPos + 2 * distance;
        long startTime = System.currentTimeMillis();

        while (Math.abs(getCurrentDrivePos() - targetPos) > 10 && opMode.opModeIsActive()) {
            double absPower = maxPower;
            //linearly accelerate to 1 power in 1000 ms
            absPower = least(absPower, (System.currentTimeMillis() - startTime) / 1000.0);
            //cap power based on distance
        }
        drive(0);
    }

    private int getCurrentDrivePos() {
        return left.getCurrentPosition() + right.getCurrentPosition();
    }

    private double least(double one, double two) {
        if (Math.abs(one) < Math.abs(two)) {
            return one;
        }
        return two;
    }

    public void turn(double power) {
        drive(power, -power);
    }

    public void turnDegrees(float degrees) {
        float initial = getOrientation();
        float target = initial + degrees;
        float diff = diff(target, getOrientation());
        while (Math.abs(diff) > 8 && opMode.opModeIsActive()) {
            diff = diff(target, getOrientation());
            turn(diff/100 + 0.2);
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
