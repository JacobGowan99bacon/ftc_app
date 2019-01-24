package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="justincasecontrollerbreaks", group="Linear Opmode")
public class justincasecontrollerbreaks extends LinearOpMode {

    // public void Driver() {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor leftSlide;
    private DcMotor rightSlide;
    private DcMotor rightreverse;
    private DcMotor leftreverse;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        leftSlide = hardwareMap.get(DcMotor.class, "linearslideleft");
        rightSlide = hardwareMap.get(DcMotor.class, "linearslideright");

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftreverse = hardwareMap.get(DcMotor.class, "left_drive");
        rightreverse = hardwareMap.get(DcMotor.class, "right_drive");




        leftSlide.setDirection(DcMotor.Direction.FORWARD);
        rightSlide.setDirection(DcMotor.Direction.REVERSE);

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        leftreverse.setDirection(DcMotor.Direction.FORWARD);
        rightreverse.setDirection(DcMotor.Direction.REVERSE);




        waitForStart();

        while (opModeIsActive()) {
            double power = gamepad1.right_stick_y;
            double rightmotorpower = gamepad1.right_trigger;
            double leftmotorpower = gamepad1.left_trigger;
            boolean rightmotorreverse = gamepad1.right_bumper;
            boolean leftmotorreverse = gamepad1.left_bumper;

            leftSlide.setPower(power);
            rightSlide.setPower(power);

            leftDrive.setPower(leftmotorpower);
            rightDrive.setPower(rightmotorpower);

            leftreverse.setPower(leftmotorpower);
            rightreverse.setPower(rightmotorpower);
            telemetry.addData("Status", "Running");
            telemetry.update();


        }

    }
}
