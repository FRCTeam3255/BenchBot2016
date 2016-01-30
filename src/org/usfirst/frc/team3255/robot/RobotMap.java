package org.usfirst.frc.team3255.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
	
	//Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	
	// PWM Ports
	public static final int DRIVETRAIN_FRONT_LEFT_TALON = 0;
	public static final int DRIVETRAIN_BACK_LEFT_TALON = 1;
	public static final int DRIVETRAIN_FRONT_RIGHT_TALON = 2;
	public static final int DRIVETRAIN_BACK_RIGHT_TALON = 3;

	public static final int CASSETTE_LEFT_LIFT_TALON = 6;
	public static final int CASSETTE_RIGHT_LIFT_TALON = 7;
	
	// CAN Bus IDs
	public static final int DRIVETRAIN_FRONT_LEFT_CANTALON = 0;
	public static final int DRIVETRAIN_BACK_LEFT_CANTALON = 1;
	public static final int DRIVETRAIN_FRONT_RIGHT_CANTALON = 2;
	public static final int DRIVETRAIN_BACK_RIGHT_CANTALON = 3;
	
	public static final int SHOOTER_LEFT_FLYWHEEL_CANTALON = 4;
	public static final int SHOOTER_RIGHT_FLYWHEEL_CANTALON = 5;
	
	// Digital IO Ports
	public static final int DRIVETRAIN_LEFT_ENCODER_CHA = 2;
	public static final int DRIVETRAIN_LEFT_ENCODER_CHB = 3;
	
	public static final int CASSETTE_LIFT_ENCODER_CHA = 8;
	public static final int CASSETTE_LIFT_ENCODER_CHB = 9;
	
	public static final int SHOOTER_FLYWHEEL_ENCODER_CHA = 4;
	public static final int SHOOTER_FLYWHEEL_ENCODER_CHB = 5;
	
	//Axies
	public static final int AXIS_ARCADE_MOVE = 1;
	public static final int AXIS_ARCADE_ROTATE = 2;

	// If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
