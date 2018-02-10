package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Delara on 1/10/2018.
 */

@TeleOp(name="Servo Test", group="Pushbot")
//@Disabled

public class ServoTest extends OpMode {

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
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        double left = -gamepad1.left_stick_y;
        double right = -gamepad1.right_stick_y;

        if (left < 0) {
            robot.verticalServo.setPosition(robot.verticalServo.getPosition() <= 0.01 ? 0 : robot.verticalServo.getPosition() - .01);
        }
        else if (left > 0){
            robot.verticalServo.setPosition(robot.verticalServo.getPosition() >= .99 ? 1 : robot.verticalServo.getPosition() + .01);
        }
        else {
            robot.verticalServo.setPosition(robot.verticalServo.getPosition());
        }

        if (right < 0) {
            robot.horizontalServo.setPosition(robot.horizontalServo.getPosition() <= 0.01 ? 0 : robot.horizontalServo.getPosition() - .01);
        }
        else if (right > 0){
            robot.horizontalServo.setPosition(robot.horizontalServo.getPosition() >= .99 ? 1 : robot.horizontalServo.getPosition() + .01);
        }
        else {
            robot.horizontalServo.setPosition(robot.horizontalServo.getPosition());
        }

        if (gamepad1.dpad_left == true) {
            robot.leftServo.setPosition(robot.leftServo.getPosition() >= 0.99 ? 1 : robot.leftServo.getPosition() + .01);
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition() >= 0.99 ? 1 : robot.topLeftServo.getPosition() + .01);
        }
        else if (gamepad1.dpad_right == true){
            robot.leftServo.setPosition(robot.leftServo.getPosition() <= 0.01 ? 0 : robot.leftServo.getPosition() - .01);
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition() <= 0.01 ? 0 : robot.topLeftServo.getPosition() - .01);
        }
        else {
            robot.leftServo.setPosition(robot.leftServo.getPosition());
            robot.topLeftServo.setPosition(robot.topLeftServo.getPosition());
        }

        if (gamepad1.dpad_down == true) {
            robot.rightServo.setPosition(robot.rightServo.getPosition() <= 0.01 ? 1 : robot.rightServo.getPosition() - .01);
            robot.topRightServo.setPosition(robot.topRightServo.getPosition() <= 0.01 ? 1 : robot.topRightServo.getPosition() - .01);
        }
        else if (gamepad1.dpad_up == true){
            robot.rightServo.setPosition(robot.rightServo.getPosition() >= .99 ? 1 : robot.rightServo.getPosition() + .01);
            robot.topRightServo.setPosition(robot.topRightServo.getPosition() >= .99 ? 1 : robot.topRightServo.getPosition() + .01);
        }
        else {
            robot.rightServo.setPosition(robot.rightServo.getPosition());
            robot.topRightServo.setPosition(robot.topRightServo.getPosition());
        }

        telemetry.addData("vertical servo position", robot.verticalServo.getPosition());
        telemetry.addData("horizontal servo position", robot.horizontalServo.getPosition());
        telemetry.addData("left servo position", robot.leftServo.getPosition());
        telemetry.addData("top left servo position", robot.topLeftServo.getPosition());
        telemetry.addData("right servo position", robot.rightServo.getPosition());
        telemetry.addData("top right servo position", robot.topRightServo.getPosition());
    }

    @Override
    public void stop(){
    }

}
