package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
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
	CANTalon leftFlyWheelTalon = null;
	CANTalon rightFlyWheelTalon = null;
	
	private static final int ENCODER_COUNT_PER_ROTATION = 750;
	private static final double MAX_SHOOTER_PID_SPEED = 0.6;
	
	public void init(){
		leftFlyWheelTalon = new CANTalon(RobotMap.SHOOTER_LEFT_FLYWHEEL_CANTALON);
		rightFlyWheelTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_FLYWHEEL_CANTALON);
		
		leftFlyWheelTalon.setSafetyEnabled(false);
		rightFlyWheelTalon.setSafetyEnabled(false);
		
		LiveWindow.addActuator("Shooter", "Flywheel Talon", leftFlyWheelTalon);
		
		LiveWindow.addActuator("Shooter", "Shooter PID Controller", this.getPIDController());
	}
	
	public void setControlMode(TalonControlMode mode) {
		leftFlyWheelTalon.changeControlMode(mode);
		rightFlyWheelTalon.changeControlMode(mode);
	}
	
	public void set(double s) {
		// For Talon in Voltage Mode
		// If battery voltage is 12.6V, output will be 47.6 with value of 6.0
		leftFlyWheelTalon.set(s);
		rightFlyWheelTalon.set(-s);
    	DriverStation.reportError("Set = " + s + "\n", false);
	}
	
	public double getMagEncoderPosition() {
		return leftFlyWheelTalon.getEncPosition();
	}
	
	public double getMagEncoderVelocity() {
		return leftFlyWheelTalon.getEncVelocity();
	}
	
	public double getInputVoltage() {
		return leftFlyWheelTalon.getBusVoltage();
	}
	
	public double getOutputVoltage() {
		return leftFlyWheelTalon.getOutputVoltage();
	}
	
	public double getOutputCurrent() {
		return leftFlyWheelTalon.getOutputCurrent();
	}
	
	public void setTalonVoltageRamp(double v) {
		// 0V to 12V in 500ms with value of 24.0
		leftFlyWheelTalon.setVoltageCompensationRampRate(v);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0.0;
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		set(Math.min(output, MAX_SHOOTER_PID_SPEED));
	}
}

