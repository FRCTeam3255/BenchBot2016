package org.usfirst.frc.team3255.robot.commands;

import org.usfirst.frc.team3255.robot.OI;
import org.usfirst.frc.team3255.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

//Test

public abstract class CommandBase extends Command {
	public static PWMDriveTrain drivetrain;
	public static Navigation navigation;
	public static PIDCassette PIDCassette;
	public static PIDShooter PIDShooter;
	public static Pneumatics pneumatics;
	public static Telemetry telemetry;
	public static OI oi;
	
	public CommandBase() {
		
	}

	public static void init() {
		navigation = new Navigation();
		drivetrain = new PWMDriveTrain();
		PIDCassette = new PIDCassette();
		PIDShooter = new PIDShooter();
		pneumatics = new Pneumatics();
		telemetry = new Telemetry();
		oi = new OI();
	}

}
