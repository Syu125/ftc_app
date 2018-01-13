package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Delara on 12/15/2017.
 */

@TeleOp(name="Test Atan2", group="Pushbot")
@Disabled

public class ATan2Test extends OpMode{

    /* Declare OpMode members. */
    HardwareConfig9837 robot = new HardwareConfig9837(); // use the class created to define a Pushbot's hardware
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
        double y = -gamepad1.right_stick_y;
        double x = gamepad1.right_stick_x;
        double angle = Math.atan2(y,x);
        double power = Math.pow((x*x) + (y*y), 0.5);

        if ((-Math.PI/8) < angle && angle < (Math.PI/8)) {
            robot.leftBackMotor.setPower(-power);
            robot.leftFrontMotor.setPower(power);
            robot.rightBackMotor.setPower(power);
            robot.rightFrontMotor.setPower(-power);
        } else {
            robot.leftBackMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);
        }
    }

    @Override
    public void stop(){
    }

}