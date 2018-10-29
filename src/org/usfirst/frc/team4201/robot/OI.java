/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4201.robot;

import org.usfirst.frc.team4201.robot.commands.BallIntakeControl;
import org.usfirst.frc.team4201.robot.commands.ConveyerControl;
import org.usfirst.frc.team4201.robot.commands.GearIntakeMotorControl;
import org.usfirst.frc.team4201.robot.commands.HopperWallControl;
import org.usfirst.frc.team4201.robot.commands.Kill;
import org.usfirst.frc.team4201.robot.commands.ShooterControl;
import org.usfirst.frc.team4201.robot.commands.ShooterUptakeControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick leftJoystick, rightJoystick, xBoxController;
	public Button[] xBoxButtons = new Button[10];
	
   public OI(){
	   xBoxController = new Joystick(RobotMap.xBoxController);
	   
	   for(int i = 0; i < xBoxButtons.length; i++)
		   xBoxButtons[i] = new JoystickButton(xBoxController,(i+1));
	    
	   xBoxButtons[0].whileHeld(new ShooterControl());
	   xBoxButtons[0].whileHeld(new ShooterUptakeControl());
	   xBoxButtons[0].whileHeld(new ConveyerControl());
	   xBoxButtons[1].whileHeld(new GearIntakeMotorControl());
	   xBoxButtons[1].whileHeld(new BallIntakeControl());
	   xBoxButtons[2].whileHeld(new HopperWallControl());
	   //xBoxButtons[4].whileHeld(new Kill());
	   //xBoxButtons[5].whileHeld(new Kill());
   }
   public double getXBoxLeftY() {
	  return -xBoxController.getRawAxis(1);
   }
   
   public double getXBoxRightY() {
	   return -xBoxController.getRawAxis(5);
   }
   
   public double getXBoxLeftX() {
	   return xBoxController.getRawAxis(0);
   }
   
   public double getXBoxRightX() {
	   return xBoxController.getRawAxis(4);
   }
}