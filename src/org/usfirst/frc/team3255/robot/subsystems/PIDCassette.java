package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PIDCassette extends PIDSubsystem {
    
	//Motor Controllers
	Talon leftLiftTalon = null;
	Talon rightLiftTalon = null;
	
	//Encoders
	Encoder liftEncoder = null;
	
	private static final int ENCODER_COUNT_PER_ROTATION = 532;
	private static final double MAX_CASSETTE_PID_SPEED = 0.3;
	
    public PIDCassette() {
		super(0, 0, 0);
		
		init();
	}
	
	public PIDCassette(String name) {
		super(name, 0, 0, 0);
		
		init();
	}
	
	public void init() {
		leftLiftTalon = new Talon(RobotMap.CASSETTE_LEFT_LIFT_TALON);
		rightLiftTalon = new Talon(RobotMap.CASSETTE_RIGHT_LIFT_TALON);
		
		leftLiftTalon.setSafetyEnabled(false);
		rightLiftTalon.setSafetyEnabled(false);
		
		liftEncoder = new Encoder(RobotMap.CASSETTE_LIFT_ENCODER_CHA, RobotMap.CASSETTE_LIFT_ENCODER_CHB);
		liftEncoder.setDistancePerPulse(12.0 / ENCODER_COUNT_PER_ROTATION);
		
		LiveWindow.addActuator("Cassette", "Left Lift Talon", leftLiftTalon);
		
		LiveWindow.addSensor("Cassette", "Lift Encoder", liftEncoder);
		LiveWindow.addActuator("Cassette", "Cassette PID Controller", this.getPIDController());
	}
    
	public void setSpeed(double s) {
		leftLiftTalon.set(s);
		rightLiftTalon.set(s);
	}
	
	public double getLiftEncoderCount() {
		return liftEncoder.get();
	}
	
	public double getLiftEncoderDistance() {
		return liftEncoder.getDistance();
	}
	
	public void resetEncoders() {
		liftEncoder.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return getLiftEncoderDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	setSpeed(Math.min(output, MAX_CASSETTE_PID_SPEED));
    }
}
