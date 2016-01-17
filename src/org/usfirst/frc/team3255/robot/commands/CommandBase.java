package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Telemetry telemetry = new Telemetry();
	public static final Shooter shooter = new Shooter();
	public static OI oi;
	
	public CommandBase() {
		
	}

	public static void init() {
		oi = new OI();
	}

}
