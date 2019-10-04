/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7006.robot;



import org.usfirst.frc.team7006.robot.commands.B_CastBoxCommand;
import org.usfirst.frc.team7006.robot.commands.B_CatchBoxCommand;
import org.usfirst.frc.team7006.robot.commands.B_ClimbBarCommand;
import org.usfirst.frc.team7006.robot.commands.B_ClimbBarUnCommand;
import org.usfirst.frc.team7006.robot.commands.B_LiftArmDownCommand;
import org.usfirst.frc.team7006.robot.commands.B_LiftArmUpCommand;
import org.usfirst.frc.team7006.robot.commands.C_PenuGetBoxCommand;
import org.usfirst.frc.team7006.robot.commands.C_PenuLoosenBoxCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick mJoystick1 =new Joystick(1);
	Joystick mJoystick0 =new Joystick(0);
	public Joystick getJoystick() {
		return mJoystick0;
	}
	
	public OI() {
		new JoystickButton(mJoystick1, 4).whileHeld(new B_LiftArmUpCommand());
		new JoystickButton(mJoystick1, 2).whileHeld(new B_LiftArmDownCommand());
		new JoystickButton(mJoystick1, 1).whileHeld(new B_ClimbBarCommand());
		new JoystickButton(mJoystick1, 3).whileHeld(new B_ClimbBarUnCommand());
		
		new JoystickButton(mJoystick1, 5).whileHeld(new B_CatchBoxCommand());
		new JoystickButton(mJoystick1, 6).whenPressed(new C_PenuGetBoxCommand());
		
		new JoystickButton(mJoystick1, 7).whileHeld(new B_CastBoxCommand());
		new JoystickButton(mJoystick1, 8).whenPressed(new C_PenuLoosenBoxCommand());
		
	}
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
	// button.whenPressed(new TeleopDriveCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new TeleopDriveCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new TeleopDriveCommand());
}
