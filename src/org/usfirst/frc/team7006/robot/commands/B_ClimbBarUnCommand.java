package org.usfirst.frc.team7006.robot.commands;

import org.usfirst.frc.team7006.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class B_ClimbBarUnCommand extends Command {

    public B_ClimbBarUnCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_ClimbBarSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_ClimbBarSubsystem.climbBarSpeed(-0.6);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_ClimbBarSubsystem.mStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
