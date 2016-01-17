package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
	public Shooter(){
		super();
		
		init();
	}
	public Shooter(String name) {
		super(name);
		
		init();
	}
	
	// Motor Controls
	CANTalon leftTalon = null;
	CANTalon rightTalon = null;
	
	public void init(){
		leftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_CANTALON);
		rightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_CANTALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
	}
	
	public void setSpeed(double s) {
		leftTalon.set(s);
		rightTalon.set(-s);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

