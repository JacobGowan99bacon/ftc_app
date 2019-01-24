package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="Autolongway", group="Pushbot")
public class Autolongway extends LinearOpMode {

    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double SLIDE_SPEED = 0.5;
    static final double LANDER_SPEED = 0.3;
    static final double MINERAL_SPEED = 0.5;
    static final double CRATER_SPEED = 1;
    static final double TURN_SPEED = 0.5;
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor rightSlide = null;
    private DcMotor leftSlide = null;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftSlide = hardwareMap.get(DcMotor.class, "linearslideleft");
        rightSlide = hardwareMap.get(DcMotor.class, "linearslideright");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");


        leftSlide.setDirection(DcMotor.Direction.REVERSE);
        rightSlide.setDirection(DcMotor.Direction.FORWARD);

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        waitForStart();
        runtime.reset();


        while (opModeIsActive() && (runtime.seconds() < 4.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftSlide.setPower(SLIDE_SPEED);
            rightSlide.setPower(SLIDE_SPEED);
        }

        leftSlide.setPower(0);
        rightSlide.setPower(0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(250);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.7)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(LANDER_SPEED);
            rightDrive.setPower(LANDER_SPEED);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 4.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftSlide.setPower(-SLIDE_SPEED);
            rightSlide.setPower(-SLIDE_SPEED);

        }

        leftSlide.setPower(0);
        rightSlide.setPower(0);


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(-LANDER_SPEED);
            rightDrive.setPower(-LANDER_SPEED);

        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        sleep(250);


        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(TURN_SPEED);
            rightDrive.setPower(-TURN_SPEED);


        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(MINERAL_SPEED);
            rightDrive.setPower(MINERAL_SPEED);

        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(250);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.9)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(-TURN_SPEED);
            rightDrive.setPower(TURN_SPEED);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(250);

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(-CRATER_SPEED);
            rightDrive.setPower(-CRATER_SPEED);
        }

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        sleep(250);

        telemetry.addData("Path", "Complete");
        telemetry.update();
    }
}





