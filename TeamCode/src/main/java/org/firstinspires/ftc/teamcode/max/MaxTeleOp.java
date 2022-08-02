package org.firstinspires.ftc.teamcode.max;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name="MaxTeleOp")
public class MaxTeleOp extends LinearOpMode {
    private Robot robot; //store the robot
    private boolean lockGrabber = false;
    private float driveMultFactor = 1;

    public void runOpMode() {
        robot = new Robot(this); //create a new Robot

        waitForStart(); //required

        //so we want something that runs continuously we do that using a while loop
        while (opModeIsActive()) {
            //normally gamepad1.right_stick_y is reversed, so we make it negative
            double drive = -gamepad1.right_stick_y * 0.6 * driveMultFactor;
            double turn = gamepad1.right_stick_x * 0.6 * driveMultFactor;
            robot.driveComponent(drive, turn); //power the drive motors given the joystick controls

            if (gamepad1.x) { //Move the arm to the desired position, hopefully works?
                robot.aimer.setTargetPosition(robot.aimer.getCurrentPosition());
            } else if (gamepad1.y) {
                robot.aimer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                if (robot.aimer.getCurrentPosition() < robot.aimer.getTargetPosition()) {
                    robot.aimer.setPower(0.03);
                } else {
                    robot.aimer.setPower(-0.03);
                }
            }

            if (abs(-gamepad1.left_stick_y) < 0.4) {
                robot.aim(gamepad1.left_stick_x * 0.2);
            }
            robot.lift(-gamepad1.left_stick_y * 0.5);
            robot.spinCarousel(gamepad1.right_trigger - gamepad1.left_trigger);

            if (gamepad1.dpad_down) { //Dpad logic to turn on grabber locks, precision mode
                lockGrabber = true;
            } else if (gamepad1.dpad_up) {
                lockGrabber = false;
            }
            if (gamepad1.dpad_left) {
                driveMultFactor = 0.3f;
            } else if (gamepad1.dpad_right) {
                driveMultFactor = 1;
            }

            if (gamepad1.a) {
                robot.grab(1);
            } else if (gamepad1.b) {
                robot.grab(-1);
            } else if (!lockGrabber){
                robot.grab(0);
            }


            //Controls:
            /* Right stick y drives the robot, up = forwards, left and right turn
            Left stick turns the arm, left and right turn the arm if not currently lifting it,
            up and down move the arm as expected
            A should grab, B should release by controlling the servo
            Dpad down locks the grabber so it keeps rotating as currently is, Dpad up negates this
            Dpad left turns on precision driving mode, making driving 0.3 times slower, Dpad right negates thsi
            Carousel driven by the big buttons on the top of the controller.
            Pressing x will set the desired position of the arm mover thing, can set it while at the optimal grabber pos
            Pressing y will make the arm seek that position
             */
        }
    }

    public float abs(float num) {
        if (num >= 0) {
            return num;
        } else {
            return -num;
        }
    }

}
