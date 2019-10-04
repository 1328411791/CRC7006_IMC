package org.usfirst.frc.team7006.robot.commands;

import org.usfirst.frc.team7006.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class C_PenuLoosenBoxCommand extends Command {

    public C_PenuLoosenBoxCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_PenuSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.m_PenuSubsystem.getBox(Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.m_PenuSubsystem.mStopGetBox();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
