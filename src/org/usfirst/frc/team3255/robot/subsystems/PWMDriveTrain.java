package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PWMDriveTrain extends Subsystem {
	
	public PWMDriveTrain() {
		super();
		
		init();
	}
	
	public PWMDriveTrain(String name) {
		super(name);
		
		init();
	}
	
	// Motor Controls
	Talon frontLeftTalon = null;
	Talon backLeftTalon = null;
	Talon frontRightTalon = null;
	Talon backRightTalon = null;
	
	//Robot Drive
	RobotDrive robotDrive = null;
    
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
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

