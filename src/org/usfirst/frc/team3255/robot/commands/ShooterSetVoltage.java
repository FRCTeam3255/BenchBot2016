package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.RobotPreferences;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class ShooterSetVoltage extends CommandBase {

    public ShooterSetVoltage() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(PIDShooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PIDShooter.setControlMode(TalonControlMode.Voltage);
    	PIDShooter.setTalonVoltageRamp(RobotPreferences.shooterVoltageRamp());
    	PIDShooter.set(RobotPreferences.talonVoltageSpeed());
    	DriverStation.reportError("Voltage = " + RobotPreferences.talonVoltageSpeed(), false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
