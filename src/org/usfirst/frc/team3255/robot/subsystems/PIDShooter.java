package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class PIDShooter extends PIDSubsystem {
    
	public PIDShooter(){
		super(0, 0, 0);
		
		init();
	}
	public PIDShooter(String name) {
		super(name, 0, 0, 0);
		
		init();
	}
	
	// Motor Controls
	CANTalon flyWheelTalon = null;
	
	Encoder shooterEncoder = null;
	
	private static final int ENCODER_COUNT_PER_ROTATION = 750;
	private static final double MAX_SHOOTER_PID_SPEED = 0.6;
	
	public void init(){
		flyWheelTalon = new CANTalon(RobotMap.SHOOTER_FLYWHEEL_CANTALON);
		
		flyWheelTalon.setSafetyEnabled(false);
		
		shooterEncoder = new Encoder(RobotMap.SHOOTER_FLYWHEEL_ENCODER_CHA, RobotMap.SHOOTER_FLYWHEEL_ENCODER_CHB);
		shooterEncoder.setDistancePerPulse(1.0 / ENCODER_COUNT_PER_ROTATION);
		
		LiveWindow.addActuator("Shooter", "Flywheel Talon", flyWheelTalon);
		
		LiveWindow.addSensor("Shooter", "Shooter Encoder", shooterEncoder);
		LiveWindow.addActuator("Shooter", "Cassette PID Controller", this.getPIDController());
	}
	
	public void setSpeed(double s) {
		flyWheelTalon.set(s);
	}
	
	public double getShooterEncoderCount() {
		return shooterEncoder.get();
	}
	
	public double getShooterEncoderDistance() {
		return shooterEncoder.getDistance();
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return getShooterEncoderDistance();
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		setSpeed(Math.min(output, MAX_SHOOTER_PID_SPEED));
	}
}

