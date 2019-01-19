/*import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
public class Myfirstopmodeever extends LinearOpMode {

    private Gyroscope imu;
    private DcMotor motortest;
    private DigitalChannel digitalTouch;
    private DistanceSensor sensorColorRange;
    private Servo servoTest;

    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        motortest = hardwareMap.get(DcMotor.class, "motorTest");
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");
        servoTest = hardwareMap.get(Servo.class, "servoTest");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
runOpMode.unlatch(6);




    public void unlatch(int inchesToUnlatch){


        HangingSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        HangingSlide.setTargetPosition((int) ticksPerHangingInch * -inchesToUnlatch);

        HangCamLeft.setPosition(hangCamLeftUnengagedPos);

        HangCamRight.setPosition(hangCamRightUnengagedPos);

        double timer = runtime.seconds() + 1;

        while(timer > runtime.seconds() && opModeIsActive()){

        keepMineralArmUp();

        }

        while(HangingSlide.isBusy()){

        HangingSlide.setPower(1);

        keepMineralArmUp();

        }

        HangingSlide.setPower(0);

        ArmTop.setPower(0);

        ArmBottom.setPower(0);

        }
     }
  }   */