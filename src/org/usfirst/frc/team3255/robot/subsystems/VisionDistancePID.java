package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionDistancePID extends PIDSubsystem {
    
	private static final double DEFAULT_P = 0.0;
	private static final double DEFAULT_I = 0.0;
	private static final double DEFAULT_D = 0.0;

	private double output = 0;
	private boolean outputValid = false;
	
	public VisionDistancePID(double desiredDistance) {
		super(DEFAULT_P, DEFAULT_I, DEFAULT_D);

		// This controller uses the distance to the vision target as the sensed value.
		// Therefore the setpoint is set to the desired distance from the vision target.
		this.setSetpoint(desiredDistance);
	}

	@Override
	protected double returnPIDInput() {
		// if the vision system did not detect a tote, then return the current
		// setpoint as the PID input so that no additional error is accumulated
		// in the PID controller. Also mark the output as invalid to make sure
		// the output of the PID controller is forced to zero.
		if (CommandBase.vision.isTote() == false) {
			outputValid = false;
			return this.getSetpoint();
		}

		// mark the output of the PID controller as valid because a tote was found
		outputValid = true;		
		
		// return the distance to the tote
		return CommandBase.vision.getToteDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		this.output = output;
	}
	
	/*
	 * This method returns the most recent cached value from the PID output
	 */
	public double getOuptut() {
		// return 0 if the PID controller is disabled or if the cached value is not valid
		if((this.getPIDController().isEnabled() == false) || (outputValid == false)) {
			return 0;
		}
		return output;
	}

	@Override
	protected void initDefaultCommand() {
	}
}
