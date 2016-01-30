package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Ordered by Subsystems
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("shooterVoltageRamp", 0.0);
	}

	public static double talonVoltageSpeed() {
		return Preferences.getInstance().getDouble("shooterVoltageSpeed", 0.0);
	}
	
}
