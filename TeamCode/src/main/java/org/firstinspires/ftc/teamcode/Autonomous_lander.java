public class unlatch(int inchesToUnlatch){


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
