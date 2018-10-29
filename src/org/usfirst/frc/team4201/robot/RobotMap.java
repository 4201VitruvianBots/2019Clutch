/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int xBoxController = 2;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	public static final int driveTrainLeftFront = 20;	// 20
	public static final int driveTrainLeftRear = 21;	// 21
	public static final int driveTrainRightFront = 22;  // 22
	public static final int driveTrainRightRear = 23;	// 23

	public static final int flywheelMaster = 32;//
	public static final int flywheelSlave = 33; //30?

	public static final int conveyerMotor = 28;
	public static final int shooterUptake = 30;
	//right climber 35
	//left climber 34
	public static final int gearIntakeMotor = 24;
	public static final int ballIntakeMotor = 26;

	public static final int PCMOne = 11;
		public static final int driveTrainShifterForward = 1;
		public static final int driveTrainShifterReverse = 0;
		public static final int gearClampPistonForward = 4;
		public static final int gearClampPistonReverse = 5;
		public static final int gearIntakePistonForward = 3;
		public static final int gearIntakePistonReverse = 2;
		public static final int hopperWallForward = 7;
		public static final int hopperWallReverse = 6;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	

	
}
    //33