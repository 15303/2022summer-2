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
            absPower = least(absPower, Math.abs(getCurrentDrivePos() - targetPos)/30.0);

            opMode.telemetry.addData("absPower", absPower);
            opMode.telemetry.update();

            drive((targetPos - getCurrentDrivePos()) > 0 ? absPower : -absPower);

            opMode.sleep(10);
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
        float target = (initial + degrees) % 360;
        float diff = diff(target, getOrientation());
        opMode.telemetry.addData("diff", diff);
        opMode.telemetry.update();

        while ((Math.abs(diff) > 4 && opMode.opModeIsActive())) {
            diff = diff(target, getOrientation());
            double power = diff / 200 + 0.2 * Math.signum(diff);
            turn(power);
            opMode.sleep(10);
            opMode.telemetry.addData("diff", diff);
            opMode.telemetry.addData("orient", getOrientation());
            opMode.telemetry.addData("power", power);
            opMode.telemetry.update();
        }
        long done = System.currentTimeMillis();
        while (System.currentTimeMillis() - 500 < done) {
            diff = diff(target, getOrientation());
            double power = diff / 300 + 0.2 * Math.signum(diff);
            turn(power);
            opMode.sleep(10);
            opMode.telemetry.addData("diff", diff);
            opMode.telemetry.addData("orient", getOrientation());
            opMode.telemetry.addData("power", power);
            opMode.telemetry.update();
        }
        drive(0);
    }

    public float getOrientation() {
        return -imu.getAngularOrientation().firstAngle;
    }

    public static float diff(float a, float b) {
        float d = Math.abs(a - b) % 360;
        float r = d > 180 ? 360 - d : d;

//calculate sign
        float sign = (a - b >= 0 && a - b <= 180) || (a - b <=-180 && a- b>= -360) ? 1 : -1;
        r *= sign;
        return r;
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
