package org.usfirst.frc.team3255.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceForward extends CommandBase {

	double d;
	
    public DriveDistanceForward(double distance) {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
        
    	d = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    	drivetrain.setSpeed(0.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (drivetrain.getLeftEncoderDistance() > d);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
