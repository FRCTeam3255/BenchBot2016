package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	public Telemetry() {
		super();
		
		init();
	}
	
	public Telemetry(String name) {
		super(name);
		
		init();
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void init() {
		// DriveTrain Commands
		SmartDashboard.putData("Drive Forward", new DriveForward());
		SmartDashboard.putData("Drive Reverse", new DriveReverse());
		SmartDashboard.putData("Drive Forward 1 Rotation", new DriveDistanceForward(1));
		SmartDashboard.putData("Drive Forward 4 Rotations", new DriveDistanceForward(4));
		SmartDashboard.putData("Drive Stop", new DriveStop());
		SmartDashboard.putData("Reset Encoders", new DriveEncoderReset());
		
		// Vision
		SmartDashboard.putNumber("Area min %", Vision.AREA_MINIMUM);

		SmartDashboard.putBoolean("Processed Image", false);
	}
	
	public void update() {
		SmartDashboard.putNumber("Drivetrain Left Speed", CommandBase.drivetrain.getLeftSpeed());
		SmartDashboard.putNumber("Drivetrain Right Speed", CommandBase.drivetrain.getRightSpeed());
		
		SmartDashboard.putNumber("Left Encoder Counts", CommandBase.drivetrain.getLeftEncoderCount());
		SmartDashboard.putNumber("Left Encoder Distance", CommandBase.drivetrain.getLeftEncoderDistance());
		SmartDashboard.putNumber("Yaw", CommandBase.navigation.getYaw());

		// Vision update
		SmartDashboard.putBoolean("IsFrontCamera", CommandBase.vision.isFrontCamera());
		SmartDashboard.putNumber("Raw particles", CommandBase.vision.getNumRawParticles());
		SmartDashboard.putNumber("Filtered particles", CommandBase.vision.getNumParticles());
		SmartDashboard.putNumber("Trapezoid", CommandBase.vision.getTrapezoidScore());
		SmartDashboard.putNumber("Long Aspect", CommandBase.vision.getLongAspectScore());
		SmartDashboard.putNumber("Short Aspect", CommandBase.vision.getShortAspectScore());
		SmartDashboard.putNumber("Convex Hull Area", CommandBase.vision.getConvexAreaScore());
		SmartDashboard.putBoolean("IsTote", CommandBase.vision.isTote());
		SmartDashboard.putNumber("Tote Distance", CommandBase.vision.getToteDistance());
		SmartDashboard.putNumber("Tote X", CommandBase.vision.getToteCenterX());
	}
	
	public double getAreaMin() {
		return SmartDashboard.getNumber("Area min %");
	}
	
	public boolean isProcessed() {
		return SmartDashboard.getBoolean("Processed Image");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
}

