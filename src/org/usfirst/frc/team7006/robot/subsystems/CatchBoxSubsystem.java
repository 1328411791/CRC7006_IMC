package org.usfirst.frc.team7006.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CatchBoxSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP mVictorSPCatchBoxLeft;
	VictorSP mVictorSPCatchBoxRight;
	
	public CatchBoxSubsystem() {
		mVictorSPCatchBoxLeft = new VictorSP(3);
		mVictorSPCatchBoxRight = new VictorSP(4);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void catchBox(double speed) {
		mVictorSPCatchBoxLeft.setSpeed(speed);
		mVictorSPCatchBoxRight.setSpeed(speed);
	}
    
    public void stopCatchBox() {
		mVictorSPCatchBoxLeft.stopMotor();
		mVictorSPCatchBoxRight.stopMotor();
	}
}

