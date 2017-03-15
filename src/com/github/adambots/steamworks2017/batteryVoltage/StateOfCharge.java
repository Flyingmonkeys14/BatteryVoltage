package com.github.adambots.steamworks2017.batteryVoltage;

import org.usfirst.frc.team245.robot.Sensors;

/*
 * THIS SHOULD BE CALLED IN robotPeriodic()
 * 
 */
public class StateOfCharge {
	
	//Constants for battery
	private static final double NOMINAL_VOLTAGE = 12;	//12V
	private static final double NOMINAL_CAPACITY = 17.2;	// at 20 hour discharge, min17Ah, max18.2Ah
	private static final double DELTA_TIME = 50;			//CAN updates the value every 20ms, but the periodic function iterates at 50hz
	
	private static double initialSOC;	//this will be retroactively changed based on the Kalman Filter
	private static double currentSOC;	//this will be retroactively changed based on the amount initialSOC is changed
	private static double previousSOC;	
	private static double dischargeCurrent;
	
	public static void InitialSOC(double initial){
		initialSOC = initial;
		previousSOC = initial;
		dischargeCurrent = Sensors.getPowerDistro().getTotalCurrent();
		//calculation for the first call after robot is enabled
		currentSOC = previousSOC + DELTA_TIME*(dischargeCurrent/NOMINAL_CAPACITY);
		
	}
	
	
	
}
