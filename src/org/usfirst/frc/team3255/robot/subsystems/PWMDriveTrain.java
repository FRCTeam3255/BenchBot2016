package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.commands.CommandBase;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PWMDriveTrain extends Subsystem {
	
	// Motor Controls
	Talon frontLeftTalon = null;
	Talon backLeftTalon = null;
	Talon frontRightTalon = null;
	Talon backRightTalon = null;
	
	// Encoders
	Encoder leftEncoder = null;
	
	//Robot Drive
	RobotDrive robotDrive = null;
	
	// PIDController for vision based turning to keep a vision target centered in the image
	// Note this PIDController will only control rotate speed (nor forward/reverse)
	VisionRotatePID visionRotatePID = null;
	
	// PIDController to maintain a specified distance from a vision target
	// Note this PIDController will only control forward/reverse speed (no rotate)
	VisionDistancePID visionDistancePID = null;
	
	// PIDController to drive a specified distance
	EncoderDistancePID encoderDistancePID = null;
	
	private static final int ENCODER_COUNTS_PER_ROTATION = 750;
	private static final double MAX_PID_MOVE_SPEED = 0.7;
	private static final double MAX_PID_ROTATE_SPEED = 0.6;
	private static final double VISION_DISTANCE = 6.0;
    
	// Define constructors here
	public PWMDriveTrain() {
		super();
		
		init();
	}
	
	public PWMDriveTrain(String name) {
		super(name);
		
		init();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void init() {
		frontLeftTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_LEFT_TALON);
		backLeftTalon = new Talon(RobotMap.DRIVETRAIN_BACK_LEFT_TALON);
		frontRightTalon = new Talon(RobotMap.DRIVETRAIN_FRONT_RIGHT_TALON);
		backRightTalon = new Talon(RobotMap.DRIVETRAIN_BACK_RIGHT_TALON);
		
		frontLeftTalon.setSafetyEnabled(false);
		backLeftTalon.setSafetyEnabled(false);
		frontRightTalon.setSafetyEnabled(false);
		backRightTalon.setSafetyEnabled(false);
		
		robotDrive = new RobotDrive(frontLeftTalon, backLeftTalon, frontRightTalon, backRightTalon);
		robotDrive.setSafetyEnabled(false);
		
		leftEncoder = new Encoder(RobotMap.DRIVETRAIN_LEFT_ENCODER_CHA, RobotMap.DRIVETRAIN_LEFT_ENCODER_CHB);
		leftEncoder.setDistancePerPulse(1.0 / ENCODER_COUNTS_PER_ROTATION);
		
		// PIDController for vision based turning
		visionRotatePID = new VisionRotatePID();
		visionRotatePID.setOutputRange(-MAX_PID_ROTATE_SPEED, MAX_PID_ROTATE_SPEED);
		
		// PIDController for vision based forward/reverse speed
		visionDistancePID = new VisionDistancePID(VISION_DISTANCE);
		visionDistancePID.setOutputRange(-MAX_PID_MOVE_SPEED, MAX_PID_MOVE_SPEED);
		
		// PIDController to drive to a specified encoder distance
		encoderDistancePID = new EncoderDistancePID(leftEncoder);		
		encoderDistancePID.setOutputRange(-MAX_PID_MOVE_SPEED, MAX_PID_MOVE_SPEED);
		
		LiveWindow.addActuator("Drivetrain", "Front Left Talon", frontLeftTalon);
		// LiveWindow.addActuator("Drivetrain", "Back Left Talon", backLeftTalon);
		//LiveWindow.addActuator("Drivetrain", "Front Right Talon", frontRightTalon);
		// LiveWindow.addActuator("Drivetrain", "Back Right Talon", backRightTalon);
		LiveWindow.addSensor("Drivetrain", "Left Encoder", leftEncoder);
		LiveWindow.addActuator("Drivetrain", "Vision Rotate PID", visionRotatePID.getPIDController());
		LiveWindow.addActuator("Drivetrain", "Vision Distance PID", visionDistancePID.getPIDController());
		LiveWindow.addActuator("Drivetrain", "Encoder Distance PID", encoderDistancePID.getPIDController());
	}
	
	public void setSpeed(double s) {
		frontLeftTalon.set(s);
		backLeftTalon.set(s);
		frontRightTalon.set(-s);
		backRightTalon.set(-s);
	}
	
	public void arcadeDrive(){
		double moveSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE);
		double moveRotate = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_ROTATE);
		
		robotDrive.arcadeDrive(moveSpeed, moveRotate);
	}
	
	public void visionDrive(){
		double moveSpeed = visionDistancePID.getOuptut();
		double moveRotate = -visionRotatePID.getOuptut();
		
		robotDrive.arcadeDrive(moveSpeed, moveRotate);
	}
	
	public double getLeftEncoderCount() {
		return leftEncoder.get();
	}
	
	public double getLeftEncoderDistance() {
		return leftEncoder.getDistance();
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
	}
	
	public void startVisionPID() {
		// reset each of the vision PIDs
		visionRotatePID.getPIDController().reset();
		visionDistancePID.getPIDController().reset();
		
		// enable each of the vision PIDs
		visionRotatePID.enable();
		visionDistancePID.enable();
	}
	
	public void stopVisionPID() {
		// reset each of the vision PIDs (which also disables them)
		visionRotatePID.getPIDController().reset();
		visionDistancePID.getPIDController().reset();		
	}
	
	public void startEncoderPID() {
		// reset the encoder PID
		encoderDistancePID.getPIDController().reset();
		
		// enable the encoder PID
		encoderDistancePID.enable();
	}
	
	public void stopEncoderPID() {
		// reset the encoder PID (which also disables it)
		encoderDistancePID.getPIDController().reset();
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}
