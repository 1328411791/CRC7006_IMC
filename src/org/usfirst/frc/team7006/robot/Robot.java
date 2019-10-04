/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7006.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team7006.robot.commands.A_TeleopDriveCommand;
import org.usfirst.frc.team7006.robot.commands.Auto_Runaline_forwardCommand;
import org.usfirst.frc.team7006.robot.commands.Auto_TestWorking_Z_LeftstartCommandGroup;
import org.usfirst.frc.team7006.robot.subsystems.CatchBarSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.CatchBoxSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.ClimbBarSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.GyroDriveSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.LiftArmSubsystem;
import org.usfirst.frc.team7006.robot.subsystems.PenuSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static DriveSubsystem m_driveSubsystem;
	public static LiftArmSubsystem m_LiftArmSubsystem;
	public static CatchBarSubsystem m_CatchBarSubsystem;
	public static ClimbBarSubsystem m_ClimbBarSubsystem;
	public static CatchBoxSubsystem m_CatchBoxSubsystem;
	public static PenuSubsystem m_PenuSubsystem;
	public static GyroDriveSubsystem m_GyroDriveSubsystem;
	public static OI m_oi;
	
	public String autoSelected;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_driveSubsystem = new DriveSubsystem();
		m_LiftArmSubsystem = new LiftArmSubsystem();
		m_CatchBarSubsystem = new CatchBarSubsystem();
		m_ClimbBarSubsystem = new ClimbBarSubsystem();
		m_CatchBoxSubsystem = new CatchBoxSubsystem();
		m_PenuSubsystem = new PenuSubsystem();
		m_GyroDriveSubsystem = new GyroDriveSubsystem();
		m_oi = new OI();
		m_chooser.addDefault("Default Auto", new A_TeleopDriveCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L') {
			autoSelected = "My Auto1";
    	}else{
    		autoSelected = "My Auto2";
		}
		
		switch(autoSelected) { 
		case "My Auto1": m_autonomousCommand = new Auto_TestWorking_Z_LeftstartCommandGroup();
			 break; 
		case "My Auto2": m_autonomousCommand = new Auto_Runaline_forwardCommand();
			 break; 
		case "Default Auto": default: m_autonomousCommand = new A_TeleopDriveCommand(); 
			 break; 
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
