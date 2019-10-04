package org.usfirst.frc.team7006.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbBarSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX mTalonSRXClimbBar;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ClimbBarSubsystem() {
    	mTalonSRXClimbBar = new TalonSRX(3);
		mTalonSRXClimbBar.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
	}
    
	public void climbBarSpeed(double speed) {
		mTalonSRXClimbBar.set(ControlMode.PercentOutput, speed);
		
		SmartDashboard.putNumber("climbBar Speed Power", speed);
	}
	
	public void mStop() {
		mTalonSRXClimbBar.set(ControlMode.PercentOutput, 0);
	}
}

