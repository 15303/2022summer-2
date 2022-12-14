package org.firstinspires.ftc.teamcode.charles;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="sensortest")
public class Test extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot(this);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("distance", robot.sensor.getDistance(DistanceUnit.CM));
            telemetry.update();
        }
    }
}
