/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7006.robot.subsystems;

import org.usfirst.frc.team7006.robot.commands.A_TeleopDriveCommand;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	Spark mSparkLeft = new Spark(1);
	Spark mSparkRight = new Spark(0);

	DifferentialDrive mDrive =new DifferentialDrive(mSparkLeft, mSparkRight);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new A_TeleopDriveCommand());
	}
	
	public void mTeleopDrive(Joystick mJoystick) {
		mDrive.tankDrive(-mJoystick.getY()*0.6, -mJoystick.getThrottle()*0.6);
	}
	
	public void mAutoTankDrive(double leftSpeed,double rightSpeed) {
		mDrive.tankDrive(leftSpeed, rightSpeed);
	}
	
	public void mStopDrive() {
		mDrive.stopMotor();
	}
}
