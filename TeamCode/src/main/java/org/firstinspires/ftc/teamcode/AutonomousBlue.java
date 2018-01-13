package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Delara on 12/8/2017.
 */

@Autonomous(name="Autonomous Blue", group="Pushbot")
//@Disabled

public class AutonomousBlue extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareConfig9837 robot = new HardwareConfig9837();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
        robot.horizontalServo.setPosition(0.54);
        sleep(1000);
        robot.verticalServo.setPosition(0.68);
        robot.colorSensor.enableLed(true);
        sleep(2000);
        if (robot.isRed()){
            telemetry.addData("Color on right", "blue");
            telemetry.update();
            sleep(1000);
            robot.horizontalServo.setPosition(0.70);
            sleep(1000);
            robot.verticalServo.setPosition(0);
            sleep(1000);
            robot.horizontalServo.setPosition(0);
        } else {
            telemetry.addData("Color on right", "red");
            telemetry.update();
            sleep(1000);
            robot.horizontalServo.setPosition(0.30);
            sleep(1000);
            robot.verticalServo.setPosition(0);
            sleep(1000);
            robot.horizontalServo.setPosition(0);
        }
        robot.colorSensor.enableLed(false);
        /*sleep(1000);
        robot.turnLeft(1);
        sleep(500);
        robot.moveFwd(1);
        sleep(1000); */
    }
}
