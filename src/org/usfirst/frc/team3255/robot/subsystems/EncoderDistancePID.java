package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class EncoderDistancePID extends PIDSubsystem {
    
	Encoder encoder = null;
	
	private double output = 0;
	
	public EncoderDistancePID(Encoder encoder) {
		super(0, 0, 0);
		updatePIDValues();
		
		this.encoder = encoder;
	}
	
	// update the PID coefficients by reading values from the dashboard
	public void updatePIDValues() {
		this.getPIDController().setPID(
				RobotPreferences.EncoderPIDP(),
				RobotPreferences.EncoderPIDI(),
				RobotPreferences.EncoderPIDD());
		
		double maxSpeed = RobotPreferences.EncoderSpeedMax();
		this.setOutputRange(-maxSpeed, maxSpeed);
	}

	@Override
	protected double returnPIDInput() {
		return encoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		this.output = output;
	}
	
	/*
	 * This method returns the most recent cached value from the PID output
	 */
	public double getOuptut() {
		// return 0 if the PID controller is disabled
		if(this.getPIDController().isEnabled() == false) {
			return 0;
		}
		return output;
	}

	@Override
	protected void initDefaultCommand() {
	}
}
