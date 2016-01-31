package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	// P value for Encoder Distance PID
	public static double EncoderPIDP() {
		return Preferences.getInstance().getDouble("EncoderP", 0.0);
	}

	// I value for Encoder Distance PID
	public static double EncoderPIDI() {
		return Preferences.getInstance().getDouble("EncoderI", 0.0);
	}

	// D value for Encoder Distance PID
	public static double EncoderPIDD() {
		return Preferences.getInstance().getDouble("EncoderD", 0.0);
	}
	
	// Setpoint for Encoder Distance PID
	public static double EncoderDistance() {
		return Preferences.getInstance().getDouble("EncoderDistance", 0.0);
	}
	
	// defines the absolute value of the maximum output for the rotate PID
	public static double EncoderSpeedMax() {
		return Preferences.getInstance().getDouble("EncoderMax", 0.7);
	}

	// ================== Vision System ==================
	
	// Name of front camera
	public static String frontCamera() {
		return Preferences.getInstance().getString("FrontCamera", "cam0");
	}
	
	// Name of rear camera
	public static String rearCamera() {
		return Preferences.getInstance().getString("RearCamera", "cam1");
	}
	
	// Min Hue value for Vision
	public static int VisionHueMin() {
		return Preferences.getInstance().getInt("HueMin", 30);
	}

	// Max Hue value for Vision
	public static int VisionHueMax() {
		return Preferences.getInstance().getInt("HueMax", 60);
	}

	// Min Sat value for Vision
	public static int VisionSatMin() {
		return Preferences.getInstance().getInt("SatMin", 30);
	}

	// Max Sat value for Vision
	public static int VisionSatMax() {
		return Preferences.getInstance().getInt("SatMax", 60);
	}

	// Min Val value for Vision
	public static int VisionValMin() {
		return Preferences.getInstance().getInt("ValMin", 30);
	}

	// Max Val value for Vision
	public static int VisionValMax() {
		return Preferences.getInstance().getInt("ValMax", 60);
	}

	// P value for Vision Rotate PID
	public static double VisionRotatePIDP() {
		return Preferences.getInstance().getDouble("RotateP", 0.8);
	}

	// I value for Vision Rotate PID
	public static double VisionRotatePIDI() {
		return Preferences.getInstance().getDouble("RotateI", 0.0);
	}

	// D value for Vision Rotate PID
	public static double VisionRotatePIDD() {
		return Preferences.getInstance().getDouble("RotateD", 0.6);
	}

	// defines the absolute value of the maximum output for the rotate PID
	public static double RotateSpeedMax() {
		return Preferences.getInstance().getDouble("RotateMax", 0.6);
	}

	// P value for Vision Distance PID
	public static double VisionDistancePIDP() {
		return Preferences.getInstance().getDouble("DistanceP", 0.4);
	}

	// I value for Vision Distance PID
	public static double VisionDistancePIDI() {
		return Preferences.getInstance().getDouble("DistanceI", 0.0);
	}

	// D value for Vision Distance PID
	public static double VisionDistancePIDD() {
		return Preferences.getInstance().getDouble("DistanceD", 0.6);
	}
	
	public static double VisionDistance() {
		return Preferences.getInstance().getDouble("VisionDistance", 5.0);
	}
	
	// defines the absolute value of the maximum output for the rotate PID
	public static double MoveSpeedMax() {
		return Preferences.getInstance().getDouble("MoveMax", 0.6);
	}
	
	// enables and disables the VisionUpdate command
	public static boolean VisionEnabled() {
		return Preferences.getInstance().getBoolean("VisionEnabled", true);
	}
}
