package org.usfirst.frc.team7006.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CatchBarSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	TalonSRX mTalonSRXCatchBar;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public CatchBarSubsystem() {
    	mTalonSRXCatchBar = new TalonSRX(2);
		mTalonSRXCatchBar.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
	}
    
	public void catchBarSpeed(double speed) {
		mTalonSRXCatchBar.set(ControlMode.PercentOutput, speed);
		
		SmartDashboard.putNumber("Catch Bar Speed Power", speed);
	}
	
	public double getEncoderValues() {
		return mTalonSRXCatchBar.getSensorCollection().getQuadraturePosition();
	}
	public void setEncoders(int newPosition, int timeoutMs) {
		mTalonSRXCatchBar.getSensorCollection().setQuadraturePosition(newPosition, timeoutMs);
	}
	
	public void mStop() {
		mTalonSRXCatchBar.set(ControlMode.PercentOutput, 0);
	}
}

