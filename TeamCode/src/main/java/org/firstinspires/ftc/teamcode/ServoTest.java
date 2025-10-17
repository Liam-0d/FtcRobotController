package org.firstinspires.ftc.teamcode;

import android.service.notification.Condition;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
//These imports bring in FTC libraries so we can use motors and gamepads - Android Studio will automatically import as you need them



@TeleOp //This lets the bot know that this program should appear in the TeleOp menu instead of Autonomous



public class ServoTest extends LinearOpMode {
//The class name MUST match the filename (JavaCode.java) --> JavaCode


    @Override

    public void runOpMode() {
        //The code here runs when you press "INIT" on the  driver station


        CRServo LadlePull1;
        CRServo LadlePull2;
        //Declaring 2 DcMotors named Right and Left


       LadlePull1 = hardwareMap.get(CRServo.class, "LadlePull1");
       LadlePull2 = hardwareMap.get(CRServo.class, "LadlePull2");

        //(Right / Left)- names for the code
        //(RightMotor/LeftMotor)- match the names you gave motors in the Driver Hub configuration



       /*
       An OPTIONAL piece of code. ZeroPowerBehavior tells motors what to do when power = 0

       There are 2 options:

       BRAKE = stop immediately (hold position)
       FLOAT = coast to a stop (default)
       */



        //Sets the  default direction for the motor's rotation.(Usually one is FORWARD and one is REVERSE)
      LadlePull1.setDirection(CRServo.Direction.FORWARD);
      LadlePull2.setDirection(CRServo.Direction.FORWARD);

        waitForStart();
        //The code here runs when you press "START" on the  driver station


        while (opModeIsActive()) {
            //code here will loop until stop is pressed on the driver hub.


            //Tank drive: each joystick controls one motor.
            //It sets the power to the joystick's Y axis.
            //Joysticks max out at a power of 1 when the joystick is fully pressed. Motors have 1 as max power forward, -1 max power reverse.
            LadlePull1.setPower(-gamepad1.left_trigger * 0.5);
            LadlePull2.setPower(-gamepad1.left_trigger * 0.5);
       if (gamepad1.dpad_up) LadlePull1.setDirection(CRServo.Direction.REVERSE);
       if (gamepad1.dpad_up) LadlePull2.setDirection(CRServo.Direction.REVERSE);
       if (gamepad1.dpad_down) LadlePull1.setDirection(CRServo.Direction.FORWARD);
       if (gamepad1.dpad_down) LadlePull2.setDirection(CRServo.Direction.FORWARD);


        }
    }
}