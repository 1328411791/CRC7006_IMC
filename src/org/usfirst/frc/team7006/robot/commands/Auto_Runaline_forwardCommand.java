package org.usfirst.frc.team7006.robot.commands;

import org.usfirst.frc.team7006.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_Runaline_forwardCommand extends Command {

    public Auto_Runaline_forwardCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_driveSubsystem.mAutoTankDrive(0.7, 0.7);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_driveSubsystem.mStopDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
