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
		SmartDashboard.putNumber("Tote hue min", Vision.TOTE_HUE_RANGE.minValue);
		SmartDashboard.putNumber("Tote hue max", Vision.TOTE_HUE_RANGE.maxValue);
		SmartDashboard.putNumber("Tote sat min", Vision.TOTE_SAT_RANGE.minValue);
		SmartDashboard.putNumber("Tote sat max", Vision.TOTE_SAT_RANGE.maxValue);
		SmartDashboard.putNumber("Tote val min", Vision.TOTE_VAL_RANGE.minValue);
		SmartDashboard.putNumber("Tote val max", Vision.TOTE_VAL_RANGE.maxValue);
		SmartDashboard.putNumber("Area min %", Vision.AREA_MINIMUM);

		SmartDashboard.putBoolean("Processed Image", false);
	}
	
	public void update() {
		SmartDashboard.putNumber("Left Encoder Counts", CommandBase.drivetrain.getLeftEncoderCount());
		SmartDashboard.putNumber("Left Encoder Distance", CommandBase.drivetrain.getLeftEncoderDistance());
		SmartDashboard.putNumber("Yaw", CommandBase.navigation.getYaw());

		// Vision update
		SmartDashboard.putNumber("Raw particles", CommandBase.vision.getNumRawParticles());
		SmartDashboard.putNumber("Filtered particles", CommandBase.vision.getNumParticles());
		SmartDashboard.putNumber("Trapezoid", CommandBase.vision.getTrapezoidScore());
		SmartDashboard.putNumber("Long Aspect", CommandBase.vision.getLongAspectScore());
		SmartDashboard.putNumber("Short Aspect", CommandBase.vision.getShortAspectScore());
		SmartDashboard.putNumber("Convex Hull Area", CommandBase.vision.getConvexAreaScore());
		SmartDashboard.putBoolean("IsTote", CommandBase.vision.isTote());
		SmartDashboard.putNumber("Distance", CommandBase.vision.getDistance());
		SmartDashboard.putNumber("ToteSpeed", CommandBase.vision.getToteSpeed());
		SmartDashboard.putNumber("ToteX", CommandBase.vision.getToteCenterX());
		SmartDashboard.putBoolean("IsFrontCamera", CommandBase.vision.isFrontCamera());
	}

	public double getHueMin() {
		return SmartDashboard.getNumber("Tote hue min");
	}
	
	public double getHueMax() {
		return SmartDashboard.getNumber("Tote hue max");
	}
	
	public double getSatMin() {
		return SmartDashboard.getNumber("Tote sat min");
	}
	
	public double getSatMax() {
		return SmartDashboard.getNumber("Tote sat max");
	}
	
	public double getValMin() {
		return SmartDashboard.getNumber("Tote val min");
	}
	
	public double getValMax() {
		return SmartDashboard.getNumber("Tote val max");
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

