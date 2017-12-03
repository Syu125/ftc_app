package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by vaina on 10/13/2017.
 */

public class HardwareConfig9837 {
    /* Public OpMode members. */
    public DcMotor leftFrontMotor   = null;
    public DcMotor leftBackMotor = null;
    public DcMotor rightFrontMotor = null;
    public DcMotor  rightBackMotor  = null;
    //public LightSensor lightSensor = null;
    //public TouchSensor touchSensor = null;
    /*public DcMotor spool, spool2 = null;
    public DcMotor claw = null;
    public Servo arm1 = null;
    public Servo arm2 = null;
    public Servo beacon1 = null;
    public Servo beacon2 = null;*/

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

        // Define and Initialize Motors
        leftFrontMotor   = hwMap.dcMotor.get("left front");
        leftBackMotor = hwMap.dcMotor.get("left back");
        rightFrontMotor  = hwMap.dcMotor.get("right front");
        rightBackMotor  = hwMap.dcMotor.get("right back");
        /*spool = hwMap.dcMotor.get("spool");
        spool2 = hwMap.dcMotor.get("spool2");
        claw = hwMap.dcMotor.get("claw");
        arm1 = hwMap.servo.get("arm_1");
        arm2 = hwMap.servo.get("arm_2");
        beacon1 = hwMap.servo.get("beacon_1");
        beacon2 = hwMap.servo.get("beacon_2");*/

        // Set directions of motors
        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
      /*  spool.setDirection(DcMotor.Direction.FORWARD);
        claw.setDirection(DcMotor.Direction.FORWARD);
        arm1.setDirection(Servo.Direction.REVERSE);*/

        // Set all motors to zero power
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
        /*spool.setPower(0);
        spool2.setPower(0);
        claw.setPower(0);*/

        /*Set initial positions of servos
        arm1.setPosition(1);
        arm2.setPosition(1);
        beacon1.setPosition(1);
        beacon2.setPosition(0);*/

        // Set wheel motors to run with encoders.
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Define and Initialize Sensors
        //lightSensor = hwMap.lightSensor.get("light_sensor");
        //touchSensor = hwMap.touchSensor.get("touch_sensor");

        //Turn on LED of light sensor
        //lightSensor.enableLed(true);
    }

    public void moveFwd (double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void stop() {
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
    }

    public void pointTurnLeft(double power) {
        leftFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void pointTurnRight (double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(0);
        rightBackMotor.setPower(0);
    }

    public void swingTurnLeft (double power) {
        leftFrontMotor.setPower(-power);
        leftBackMotor.setPower(-power);
        rightFrontMotor.setPower(power);
        rightBackMotor.setPower(power);
    }

    public void swingTurnRight (double power) {
        leftFrontMotor.setPower(power);
        leftBackMotor.setPower(power);
        rightFrontMotor.setPower(-power);
        rightBackMotor.setPower(-power);
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

