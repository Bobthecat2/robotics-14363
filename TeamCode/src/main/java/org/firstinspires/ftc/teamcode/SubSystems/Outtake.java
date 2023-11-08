package org.firstinspires.ftc.teamcode.SubSystems;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;



public class Outtake {
    DcMotorEx rightSlide, leftSlide;
    //Number is copied, maybe change it?
    private int countsPerRevolution = 384;
    //number is copied, maybe change it?
    double power = 0.9;
    //constants to set the position of the arm
    public static int highLeft = 0;
    public static int highRight = 0;
    public static int mediumLeft = 0;
    public static int mediumRight = 0;
    public static int stationLeft = 0;
    public static int stationRight = 0;

    public Outtake(HardwareMap hardwareMap){
        //get the two servos
        rightSlide = hardwareMap.get(DcMotorEx.class, "rightOuttakeSlide");
        leftSlide = hardwareMap.get(DcMotorEx.class, "leftOuttakeSlide");

        //makes motor run based on speed
        rightSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //change torque
        rightSlide.setTargetPositionTolerance(5);
        leftSlide.setTargetPositionTolerance(5);
    }

    public void setSlidePosition(String position, String state){
        //change arm position based on the given position
        switch (state) {
            case "retracted":
                break;
            case "extending":
                switch (position){
                    case "high":
                        leftSlide.setTargetPosition(highLeft);
                        rightSlide.setTargetPosition(highRight);

                        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                        leftSlide.setPower(power);
                        rightSlide.setPower(power);

                        state = "extended";
                        break;
                    case "medium":
                        leftSlide.setTargetPosition(mediumLeft);
                        rightSlide.setTargetPosition(mediumRight);

                        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                        leftSlide.setPower(power);
                        rightSlide.setPower(power);

                        state = "extended";
                        break;
                    case "station":
                        leftSlide.setTargetPosition(stationLeft);
                        leftSlide.setTargetPosition(stationRight);

                        leftSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                        rightSlide.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                        leftSlide.setPower(power);
                        rightSlide.setPower(power);
                        state = "retracted";
                        break;
                }
            case "extended":
                break;
        }

    }
    public double getLeftSlidePosition () {
        double position = leftSlide.getCurrentPosition();
        return position;
    }
    public double getRightSlidePosition(){
        double position = rightSlide.getCurrentPosition();
        return position;
    }

}