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
        if (rightX != 0) {
            robot.leftFrontMotor.setPower(rightX);
            robot.leftBackMotor.setPower(-rightX);
            robot.rightFrontMotor.setPower(-rightX);
            robot.rightBackMotor.setPower(rightX);
        } else {
            robot.leftFrontMotor.setPower(left);
            robot.leftBackMotor.setPower(left);
            robot.rightFrontMotor.setPower(right);
            robot.rightBackMotor.setPower(right);
        }

        // Grabber
        if (gamepad1.dpad_right == true) {                  //spool move in; grab glyph
            robot.grabber.setPower(0.1);
        } else if (gamepad1.dpad_left == true) {            //spool move out; release glyph
            robot.grabber.setPower(-0.1);
        } else if (gamepad1.dpad_right == false && gamepad1.dpad_left == false) {
            robot.grabber.setPower(0);
        }

        // Lift
        if (gamepad1.dpad_up == false && gamepad1.dpad_down == false) {
            robot.lift.setPower(0);
        } else if (gamepad1.dpad_up == true) {
            robot.lift.setPower(1);
        } else if (gamepad1.dpad_down == true) {
            robot.lift.setPower(-1);
        }
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop(){
    }
}
