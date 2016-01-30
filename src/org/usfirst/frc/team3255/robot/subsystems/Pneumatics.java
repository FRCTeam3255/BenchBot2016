package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
	public Pneumatics(){
		super();
		
		init();
	}
	public Pneumatics(String name) {
		super();
		
		init();
	}
	
	// Double Solenoids
	DoubleSolenoid doubleSolenoid = null;
	
	public void init() {
		doubleSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_OPEN, RobotMap.SOLENOID_CLOSE);
	}
	
	public void solenoidOpen() {
		doubleSolenoid.set(Value.kForward);
	}
	
	public void solenoidClose() {
		doubleSolenoid.set(Value.kReverse);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

