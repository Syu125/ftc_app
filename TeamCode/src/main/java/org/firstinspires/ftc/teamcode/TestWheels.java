package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Delara on 11/3/2017.
 */

@TeleOp(name="TestWheels", group="Pushbot")
@Disabled

public class TestWheels extends OpMode{

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
        double leftY = -gamepad1.left_stick_y;
        double rightY = -gamepad1.right_stick_y;

        if (leftY > 0) {
            robot.leftFrontMotor.setPower(1);
        } else if (leftY < 0) {
            robot.leftBackMotor.setPower(1);
        } else {
            robot.leftFrontMotor.setPower(0);
            robot.leftBackMotor.setPower(0);
        }

        if (rightY > 0){
            robot.rightFrontMotor.setPower(1);
        } else if (rightY < 0) {
            robot.rightBackMotor.setPower(1);
        } else {
            robot.rightFrontMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
        }
    }

    @Override
    public void stop(){
    }

}