package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name="justincasecontrollerbreaks", group="Linear Opmode")
public class justincasewithoutslide extends LinearOpMode {

    // public void Driver() {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor leftSlide;
    private DcMotor rightSlide;



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
                leftSlide.setPower(-leftpower);
                rightSlide.setPower(-leftpower);
            } else if ((rightpower > 0) && (leftpower == 0)) {
                leftSlide.setPower(rightpower);
                rightSlide.setPower(rightpower);
            } else {
                leftSlide.setPower(0);
                rightSlide.setPower(0);
            }
            leftDrive.setPower(leftmotorpower);
            rightDrive.setPower(rightmotorpower);
            telemetry.addData("Status", "Running");
            telemetry.update();

        }

    }
}
