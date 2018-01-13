package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by vaina on 10/13/2017.
 */

public class HardwareConfig9837 {
    /* Public OpMode members. */
    public DcMotor leftFrontMotor   = null;
    public DcMotor leftBackMotor = null;
    public DcMotor rightFrontMotor = null;
    public DcMotor rightBackMotor  = null;
    public DcMotor lift = null;
    public ColorSensor colorSensor = null;
    public Servo verticalServo = null;
    public Servo horizontalServo = null;
    public Servo leftServo = null;
    public Servo rightServo = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareConfig9837(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors and Sensors
        leftFrontMotor   = hwMap.dcMotor.get("left front");
        leftBackMotor = hwMap.dcMotor.get("left back");
        rightFrontMotor  = hwMap.dcMotor.get("right front");
        rightBackMotor  = hwMap.dcMotor.get("right back");
        lift = hwMap.dcMotor.get("lift");
        colorSensor = hwMap.colorSensor.get("color sensor");
        verticalServo = hwMap.servo.get("vertical servo");
        horizontalServo = hwMap.servo.get("horizontal servo");
        leftServo = hwMap.servo.get("left servo");
        rightServo = hwMap.servo.get("right servo");

        // Set directions of motors
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.REVERSE); //counterclockwise = up

        // Set all motors to zero power
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
        lift.setPower(0);

        //Set initial positions of servos
        verticalServo.setPosition(0);
        horizontalServo.setPosition(0);
        leftServo.setPosition(0);
        rightServo.setPosition(1);

        // Set wheel motors to run with encoders.
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void moveFwd (double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void turnRight(double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(-power);
        rightBackMotor.setPower(-power);
    }

    public void turnLeft(double power) {
        leftFrontMotor.setPower(-power);
        leftBackMotor.setPower(-power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void stop() {
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
    }
    
    public void strafeRight(double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(-power);
        rightFrontMotor.setPower(-power);
        rightBackMotor.setPower(power);
    }

    public void strafeLeft(double power) {
        leftFrontMotor.setPower(-power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(-power);
    }

    public boolean isRed() {
        int RED = colorSensor.red() * 50;
        int BLUE = colorSensor.blue() * 50;
        int GREEN = colorSensor.green() * 50;
        if (RED > BLUE && RED > GREEN){
            return true;
        } else {
            return false;
        }
    }

        /***
         *
         * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
         * periodic tick.  This is used to compensate for varying processing times for each cycle.
         * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
         *
         * @param periodMs  Length of wait cycle in mSec.
         */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

