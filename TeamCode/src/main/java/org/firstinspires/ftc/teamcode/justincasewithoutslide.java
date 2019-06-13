package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="justincasewithoutslide", group="Linear Opmode")
public class justincasewithoutslide extends LinearOpMode {

    // public void Driver() {
    private DcMotor leftDrive;
    private DcMotor rightDrive;


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while (opModeIsActive()) {
            double rightmotorpower = gamepad1.right_stick_y;
            double leftmotorpower = gamepad1.left_stick_y;
            double reverse;
            double leftpower = gamepad1.left_trigger;
            double rightpower = gamepad1.right_trigger;
            if ((leftpower > 0) && (rightpower == 0)) {

            }
            leftDrive.setPower(leftmotorpower);
            rightDrive.setPower(rightmotorpower);
            telemetry.addData("Status", "Running");
            telemetry.update();

        }

    }
}
