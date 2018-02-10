package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Delara on 12/7/2017.
 */

@TeleOp(name="TeleOp: Mecanum Wheels", group="Pushbot")
//@Disabled

public class TeleOp2 extends OpMode{

    /* Declare OpMode members. */
    HardwareConfig9837 robot = new HardwareConfig9837(); // use the class created to define a Pushbot's hardware

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

        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;
        double rightX = gamepad1.right_stick_x;

        // Driving
        if (rightX > 0.5 || rightX < -0.5) {
            double slowRightX = rightX/1.5;
            robot.leftFrontMotor.setPower(slowRightX);
            robot.leftBackMotor.setPower(-slowRightX);
            robot.rightFrontMotor.setPower(-slowRightX);
            robot.rightBackMotor.setPower(slowRightX);
        } else {
            double slowLeft = left/1.5;
            double slowRight = right/1.5;
            robot.leftFrontMotor.setPower(slowLeft);
            robot.leftBackMotor.setPower(slowLeft);
            robot.rightFrontMotor.setPower(slowRight);
            robot.rightBackMotor.setPower(slowRight);
        }

        // Grabber
        if (gamepad1.dpad_right == true) {       // servos move in
            robot.leftServo.setPosition(robot.leftServo.getPosition() >= 0.98 ? 1.0 : robot.leftServo.getPosition() + .1);
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition() >= 0.98 ? 1.0 : robot.topLeftServo.getPosition() + .1);
            robot.rightServo.setPosition(robot.rightServo.getPosition() <= 0.02 ? 0.0 : robot.rightServo.getPosition() - .1);
            robot.topRightServo.setPosition(robot.topRightServo.getPosition() <= 0.02 ? 0.0 : robot.topRightServo.getPosition() - .1);
        }
        else if (gamepad1.dpad_left == true){    // servos move out
            robot.leftServo.setPosition(robot.leftServo.getPosition() <= 0.02 ? 0.0 : robot.leftServo.getPosition() - .1);
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition() <= 0.02 ? 0.0 : robot.topLeftServo.getPosition() - .1);
            robot.rightServo.setPosition(robot.rightServo.getPosition() >= .98 ? 1.0 : robot.rightServo.getPosition() + .1);
            robot.topRightServo.setPosition(robot.topRightServo.getPosition() >= .98 ? 1.0 : robot.topRightServo.getPosition() + .1);
        } else {
            robot.leftServo.setPosition(robot.leftServo.getPosition());
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition());
            robot.rightServo.setPosition(robot.rightServo.getPosition());
            robot.topRightServo.setPosition(robot.topRightServo.getPosition());
        }

        // Lift
        if (gamepad1.dpad_up == true) {
            robot.lift.setPower(1);
        } else if (gamepad1.dpad_down == true) {
            robot.lift.setPower(-1);
        } else {
            robot.lift.setPower(0);
        }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
