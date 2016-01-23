package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

//Test

public abstract class CommandBase extends Command {
	public static PWMDriveTrain drivetrain;
	public static PIDShooter shooter;
	public static Navigation navigation;
	public static PIDCassette PIDCassette;
	public static Vision vision;
	public static Telemetry telemetry;
	public static OI oi;
	
	public CommandBase() {
		
	}

	public static void init() {
		navigation = new Navigation();
		drivetrain = new PWMDriveTrain();
		shooter = new PIDShooter();
		PIDCassette = new PIDCassette();
		vision = new Vision();
		telemetry = new Telemetry();
		oi = new OI();
	}

}
