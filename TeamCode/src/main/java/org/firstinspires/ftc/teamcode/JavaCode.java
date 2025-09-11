package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
//These imports bring in FTC libraries so we can use motors and gamepads - Android Studio will automatically import as you need them



    @TeleOp //This lets the bot know that this program should appear in the TeleOp menu instead of Autonomous



    public class JavaCode extends LinearOpMode {
//The class name MUST match the filename (JavaCode.java) --> JavaCode



        @Override

        public void runOpMode() {
            //The code here runs when you press "INIT" on the  driver station


            DcMotor Right;
            DcMotor Left;
            DcMotor Bright;
            DcMotor Bleft;
            DcMotor Cannon;
            //Declaring 2 DcMotors named Right and Left


            Cannon = hardwareMap.get(DcMotor.class, "Cannon");
            Right = hardwareMap.get(DcMotor.class, "RIght");
            Left = hardwareMap.get(DcMotor.class, "Left");
            Bright = hardwareMap.get(DcMotor.class, "Bright");
            Bleft = hardwareMap.get(DcMotor.class, "Bleft");
            //(Right / Left)- names for the code
            //(RightMotor/LeftMotor)- match the names you gave motors in the Driver Hub configuration



            Right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Bright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Bleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            Cannon.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       /*
       An OPTIONAL piece of code. ZeroPowerBehavior tells motors what to do when power = 0

       There are 2 options:

       BRAKE = stop immediately (hold position)
       FLOAT = coast to a stop (default)
       */



            Right.setDirection(DcMotorSimple.Direction.FORWARD);
            Left.setDirection(DcMotorSimple.Direction.FORWARD);
            Bleft.setDirection(DcMotorSimple.Direction.REVERSE);
            Bright.setDirection(DcMotorSimple.Direction.FORWARD);
            Cannon.setDirection(DcMotorSimple.Direction.FORWARD);
            //Sets the  default direction for the motor's rotation.(Usually one is FORWARD and one is REVERSE)



            waitForStart();
            //The code here runs when you press "START" on the  driver station



            while(opModeIsActive()) {
                //code here will loop until stop is pressed on the driver hub.



                //Tank drive: each joystick controls one motor.
                //It sets the power to the joystick's Y axis.
                //Joysticks max out at a power of 1 when the joystick is fully pressed. Motors have 1 as max power forward, -1 max power reverse.



                Right.setPower(gamepad1.right_stick_y * -0.5);
                //Y axis is inverted by default. To fix it, we multiply it by -1.



                Left.setPower(-gamepad1.left_stick_y * 0.5);
                //We can also just  add  a (-) before it.
                Bright.setPower(-gamepad1.right_stick_y * 0.5);
                Bleft.setPower(-gamepad1.left_stick_y * 0.5 );
                Cannon.setPower(-gamepad1.right_trigger * 0.5);

                if (gamepad1.right_bumper) Cannon.setDirection(DcMotorSimple.Direction.REVERSE);
                if (gamepad1.left_bumper) Cannon.setDirection(DcMotorSimple.Direction.FORWARD);
           }
        }
    }
