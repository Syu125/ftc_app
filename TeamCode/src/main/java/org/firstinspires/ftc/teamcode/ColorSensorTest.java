package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Delara on 1/8/2018.
 */

@TeleOp(name="Color Sensor Test", group="Pushbot")
//@Disabled

public class ColorSensorTest extends OpMode {

    /* Declare OpMode members. */
    HardwareConfig9837 robot = new HardwareConfig9837();

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
        robot.colorSensor.enableLed(true);
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Red", robot.isRed());
        telemetry.addData("Red", robot.colorSensor.red());
        telemetry.addData("Green", robot.colorSensor.green());
        telemetry.addData("Blue", robot.colorSensor.blue());
    }

    @Override
    public void stop(){
    }

}
