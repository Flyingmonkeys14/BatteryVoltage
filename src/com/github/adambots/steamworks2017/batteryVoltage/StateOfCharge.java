package com.github.adambots.steamworks2017.batteryVoltage;

import org.usfirst.frc.team245.robot.Sensors;

public class StateOfCharge {
	
	//Constants for battery
	private static final double nominalVoltage = 12;	//12V
	private static final double nominalCapacity = 17;	// at 20 hour discharge, min17Ah, max18.2Ah
	private static final double deltaTime = 20;			//CAN updates the value every 20ms
	
	private static double initialSOC;	//this will be retroactively changed based on the Kalman Filter
	private static double currentSOC;	//this will be retroactively changed based on the amount initialSOC is changed
	private static double previousSOC;	
	private static double dischargeCurrent;
	
	public static void InitialSOC(double initial){
		initialSOC = initial;
		previousSOC = initial;
		dischargeCurrent = Sensors.getPowerDistro().getTotalCurrent();
		
		currentSOC = previousSOC + deltaTime*(dischargeCurrent/nominalCapacity);
		
	}
	
	
	
}
