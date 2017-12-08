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


        /*
        // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
        double leftX = -gamepad1.left_stick_x;
        double x = -gamepad1.right_stick_x;

        // Power = the distance of the joystick's position from the origin (using Pythagorean theorem)
        double power = Math.pow((Math.pow(-gamepad1.right_stick_y, 2) + Math.pow(-gamepad1.right_stick_x, 2)), 0.5);

        // Theta = angle of joystick using tan inverse; used for cases that are not straight up or down
        double theta = Math.atan(-gamepad1.right_stick_y / -gamepad2.right_stick_x);

        //Theta 2 = angle of joystick using sin inverse; used for vertical cases
        double theta2 = Math.asin(-gamepad1.right_stick_y / power);

        // DRIVING

        // Direction Cases (Right joystick)
        if (x > 0) {
            if ((-3 * Math.PI / 8) < theta && theta < (-Math.PI / 8)) {                        //case A: diagonal right down
                robot.leftFrontMotor.setPower(0);
                robot.leftBackMotor.setPower(-power);
                robot.rightFrontMotor.setPower(power);
                robot.rightBackMotor.setPower(0);
            } else if ((-Math.PI / 8) < theta && theta < (Math.PI / 8)) {                     //case B: to the right
                robot.leftFrontMotor.setPower(power);
                robot.leftBackMotor.setPower(-power);
                robot.rightFrontMotor.setPower(power);
                robot.rightBackMotor.setPower(-power);
            } else if ((Math.PI / 8) < theta && theta < (3 * Math.PI / 8)) {                  //case C: to the right up
                robot.leftFrontMotor.setPower(power);
                robot.leftBackMotor.setPower(0);
                robot.rightFrontMotor.setPower(0);
                robot.rightBackMotor.setPower(-power);
            } else if ((3 * Math.PI / 8) < theta2) {                                          //case G: moving forward
                robot.leftFrontMotor.setPower(power);
                robot.leftBackMotor.setPower(power);
                robot.rightFrontMotor.setPower(-power);
                robot.rightBackMotor.setPower(-power);
            }
        } if (x < 0) {
            if ((-3 * Math.PI / 8) < theta && theta < (Math.PI / 8)) {                        //case D: diagonal right up
                robot.leftFrontMotor.setPower(0);
                robot.leftBackMotor.setPower(power);
                robot.rightFrontMotor.setPower(-power);
                robot.rightBackMotor.setPower(0);
            } else if ((-Math.PI / 8) < theta && theta < (Math.PI / 8)) {                     //case E: to the left
                robot.leftFrontMotor.setPower(-power);
                robot.leftBackMotor.setPower(power);
                robot.rightFrontMotor.setPower(-power);
                robot.rightBackMotor.setPower(power);
            } else if ((Math.PI / 8) < theta && theta < (3 * Math.PI / 8)) {                  //case F: to the left down
                robot.leftFrontMotor.setPower(-power);
                robot.leftBackMotor.setPower(0);
                robot.rightFrontMotor.setPower(0);
                robot.rightBackMotor.setPower(power);
            } else if ((-3 * Math.PI / 8) < theta2) {                                         //case H: moving backward
                robot.leftFrontMotor.setPower(-power);
                robot.leftBackMotor.setPower(-power);
                robot.rightFrontMotor.setPower(power);
                robot.rightBackMotor.setPower(power);
            }
        }

        // Turning Cases (Left Joystick)
        if (leftX > 0) {                                                                      //case 1: turning clockwise
            robot.leftFrontMotor.setPower(power);
            robot.leftBackMotor.setPower(power);
            robot.rightFrontMotor.setPower(power);
            robot.rightBackMotor.setPower(power);
        } else if (leftX < 0){
            robot.leftFrontMotor.setPower(-power);
            robot.leftBackMotor.setPower(-power);
            robot.rightFrontMotor.setPower(-power);
            robot.rightBackMotor.setPower(-power);
        }

        if (x == 0 && leftX == 0) {
            robot.leftFrontMotor.setPower(0);
            robot.leftBackMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
        }*/

        if (gamepad1.dpad_right == true) {               //spool move in; grab glyph
            robot.grabber.setPosition(0);
        }
        else if (gamepad1.dpad_left == true){          //spool move out; release glyph
            robot.grabber.setPosition(1);
        }
        else if (gamepad1.dpad_right == false && gamepad1.dpad_left == false){
            robot.grabber.setPosition(0.5);
        }

        if (gamepad1.dpad_up == false && gamepad1.dpad_down == false){
            robot.lift.setPower(0);
        }
        else if (gamepad1.dpad_up == true){
            robot.lift.setPower(1);
        } else if (gamepad1.dpad_down == true){
            robot.lift.setPower(-1);
        }

        // Lift
        //1-19 debug:  bug in the if conditionals for lift
        /*if (gamepad1.a == true) {
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
        }*/

        // Send telemetry message to signify robot running;
        telemetry.addData("right X",  "%.2f", gamepad1.right_stick_x);
        //telemetry.addData("right", "%.2f", right);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */

    @Override
    public void stop(){
    }
}
