package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	//Ordered by Subsystems
	
	//Camera
	public static String cameraName() {
		return Preferences.getInstance().getString("CameraName", "cam0");
	}
	
	//Drivetrain
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}

}
