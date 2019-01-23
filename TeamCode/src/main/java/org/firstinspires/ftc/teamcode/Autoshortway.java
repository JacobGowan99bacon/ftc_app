package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;



@Autonomous(name="Autoshortway", group="Pushbot")
public class Autoshortway extends LinearOpMode {

    HardwarePushbot robot = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double SLIDE_SPEED = 0.5;
    static final double DRIVE_SPEED = 0.2;
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
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
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
        while (opModeIsActive() && (runtime.seconds() < 0.3)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
            leftDrive.setPower(DRIVE_SPEED);
            rightDrive.setPower(DRIVE_SPEED);


        } telemetry.addData("Path", "Complete");
        telemetry.update();
    }
}




