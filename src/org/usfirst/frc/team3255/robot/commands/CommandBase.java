package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

//Test

public abstract class CommandBase extends Command {
	public static final DriveTrain drivetrain = new DriveTrain();
	public static final Telemetry telemetry = new Telemetry();
	public static final PIDShooter shooter = new PIDShooter();
	public static OI oi;
	public static final PIDCassette PIDCassette = new PIDCassette();
	
	public CommandBase() {
		
	}

	public static void init() {
		oi = new OI();
	}

}
