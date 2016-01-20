package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.commands.CommandBase;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class PWMDriveTrain extends PIDSubsystem {
	
	// Motor Controls
	Talon frontLeftTalon = null;
	Talon backLeftTalon = null;
	Talon frontRightTalon = null;
	Talon backRightTalon = null;
	
	// Encoders
	Encoder leftEncoder = null;
	
	//Robot Drive
	RobotDrive robotDrive = null;
	
	private static final int ENCODER_COUNTS_PER_ROTATION = 750;
	private static final double MAX_PID_SPEED = 0.3;
	private static final double YAW_COEFFICENT = 0.03;
    
	// Define constructors here
	public PWMDriveTrain() {
		super(0, 0, 0);
		
		init();
	}
	
	public PWMDriveTrain(String name) {
		super(name, 0, 0, 0);
		
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
		
		LiveWindow.addActuator("Drivetrain", "Front Left Talon", frontLeftTalon);
		// LiveWindow.addActuator("Drivetrain", "Back Left Talon", backLeftTalon);
		//LiveWindow.addActuator("Drivetrain", "Front Right Talon", frontRightTalon);
		// LiveWindow.addActuator("Drivetrain", "Back Right Talon", backRightTalon);
		LiveWindow.addSensor("Drivetrain", "Left Encoder", leftEncoder);
		LiveWindow.addActuator("Drivetrain", "PID Controller", this.getPIDController());
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
	
	public void straightDrive(){
		double moveSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE);
		double moveRotate = CommandBase.navigation.getYaw()*YAW_COEFFICENT;
		
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
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }

	@Override
	protected double returnPIDInput() {
		return getLeftEncoderDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		setSpeed(Math.min(output, MAX_PID_SPEED));
	}
}

