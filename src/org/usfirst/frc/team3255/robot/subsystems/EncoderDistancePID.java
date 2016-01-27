package org.usfirst.frc.team3255.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class EncoderDistancePID extends PIDSubsystem {
    
	private static final double DEFAULT_P = 0.0;
	private static final double DEFAULT_I = 0.0;
	private static final double DEFAULT_D = 0.0;
	
	private static final double OUTPUT_MIN = -0.8;
	private static final double OUTPUT_MAX = 0.8;

	Encoder encoder = null;
	
	private double output = 0;
	
	public EncoderDistancePID(Encoder encoder) {
		super(DEFAULT_P, DEFAULT_I, DEFAULT_D);
		this.setOutputRange(OUTPUT_MIN, OUTPUT_MAX);
		
		this.encoder = encoder;
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
