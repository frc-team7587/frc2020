package frc.robot;

public class Constants {
    public Constants() {
    }

    // Drivetrain constants
    public static final int DRIVE_LEFT1 = 0;
    public static final int DRIVE_LEFT2 = 1;
    public static final int DRIVE_RIGHT1 = 2;
    public static final int DRIVE_RIGHT2 = 3;

    // Intake constants
    public static final int INTAKE_TALON_ID = 3;
    public static final double INTAKE_MAX_SPEED = 0.5;

    // Hanger constants
    public static final int HANGER_TALON_ID = 2;
    public static final double HANGER_MAX_SPEED = 0.75;

    // Arm constants
    public static final int ARM_SPARK_PWM_ID = 4;
    public static final double ARM_MAX_SPEED = 0.40;

    // Joystick constants
    public static final int LOGIJOY_PORT = 0;

    // Gamepad constants
    public static final int BTN_A = 1;
    public static final int BTN_B = 2;
    public static final int BTN_X = 3;
    public static final int BTN_Y = 4;
    public static final int BUMP_LEFT = 5;
    public static final int BUMP_RIGHT = 6;
}