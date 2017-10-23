package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by vaina on 10/13/2017.
 */

@TeleOp(name="TeleOpMode", group="Pushbot")
//@Disabled

public class TeleOpMode9837 extends OpMode{
    /**
     * This file provides basic Telop driving for a Pushbot robot.
     * The code is structured as an Iterative OpMode
     *
     * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
     * All device access is managed through the HardwarePushbot class.
     *
     * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
     * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
     */



        /* Declare OpMode members. */
    HardwareConfig9837 robot       = new HardwareConfig9837(); // use the class created to define a Pushbot's hardware
    // could also use HardwarePushbotMatrix class.

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;

        // Claw trigger controls
        double clawOpen = gamepad1.left_trigger;
        double clawClose = -gamepad1.right_trigger;

        // GAMEPAD1 CONTROLS

        // Driving
        if (gamepad1.left_stick_x < 0 && gamepad1.right_stick_x < 0) {
            robot.leftFrontMotor.setPower(-1);
            robot.leftBackMotor.setPower(1);
            robot.rightFrontMotor.setPower(1);
            robot.rightBackMotor.setPower(-1);
        } else if (gamepad1.left_stick_x > 0 && gamepad1.right_stick_x > 0) {
            robot.leftFrontMotor.setPower(1);
            robot.leftBackMotor.setPower(-1);
            robot.rightFrontMotor.setPower(-1);
            robot.rightBackMotor.setPower(1);
        } else {
            robot.leftFrontMotor.setPower(left);
            robot.leftBackMotor.setPower(left);
            robot.rightFrontMotor.setPower(right);
            robot.rightBackMotor.setPower(right);
        }

        // Lift
        //1-19 debug:  bug in the if conditionals for lift
       /* if (gamepad1.a == true) {
            robot.spool.setPower(-1);
            robot.spool2.setPower(-1);
        }
        else if (gamepad1.b == true) {
            robot.spool.setPower(1);
            robot.spool2.setPower(1);
        }
        else {
            robot.spool.setPower(0);
            robot.spool2.setPower(0);
        }

        // Claw
        //1-19 debug:  clawOpen and clawClose are setup as variable declarations above???
        if (gamepad1.left_trigger > 0) {
            robot.claw.setPower(clawOpen);
        }
        else if (gamepad1.right_trigger > 0) {
            robot.claw.setPower(clawClose);
        }
        else {
            robot.claw.setPower(0);
        }

        // Arm Servos
        if (gamepad1.left_bumper == true) {
            robot.arm1.setPosition(robot.arm1.getPosition() >= .99  ? 1 : robot.arm1.getPosition() + .01);
            robot.arm2.setPosition(robot.arm2.getPosition() >= .99  ? 1 : robot.arm2.getPosition() + .01);
        }
        else if (gamepad1.right_bumper == true) {
            robot.arm1.setPosition(robot.arm1.getPosition() <= .01  ? 0 : robot.arm1.getPosition() - .01);
            robot.arm2.setPosition(robot.arm2.getPosition() <= .01  ? 0 : robot.arm2.getPosition() - .01);
        }

        // Beacon Presser
        //1-19 debug:  set everything to gamepad1???
        if (gamepad1.x == true) {
            robot.beacon1.setPosition(robot.beacon1.getPosition() >= .99  ? 1 : robot.beacon1.getPosition() + .01);
        }
        if (gamepad1.y == true) {
            robot.beacon1.setPosition(robot.beacon1.getPosition() <= .01  ? 0 : robot.beacon1.getPosition() - .01);
        }

        // Send telemetry message to signify robot running;
        telemetry.addData("left",  "%.2f", left);
        telemetry.addData("right", "%.2f", right); */
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
}
