package org.usfirst.frc.team7006.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftArmSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX mTalonSRXLiftArm;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public LiftArmSubsystem() {
    	mTalonSRXLiftArm = new TalonSRX(1);
		mTalonSRXLiftArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
	}
    
	public void setLiftArmSpeed(double speed) {
		mTalonSRXLiftArm.set(ControlMode.PercentOutput, speed);
		
		SmartDashboard.putNumber("LeftSpeed Power", speed);
	}
	
	public void mStop() {
		mTalonSRXLiftArm.set(ControlMode.PercentOutput, 0);
	}
}

