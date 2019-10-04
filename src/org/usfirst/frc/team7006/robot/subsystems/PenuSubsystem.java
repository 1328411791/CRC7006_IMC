package org.usfirst.frc.team7006.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PenuSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Compressor mCompressor = new Compressor();
	DoubleSolenoid mDoubleSolenoidGetBox;
	DoubleSolenoid mDoubleSolenoidGetBar;
	
	public PenuSubsystem() {
		mDoubleSolenoidGetBox = new DoubleSolenoid(6, 7);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void getBox(Value onoff) {
		mDoubleSolenoidGetBox.set(onoff);
	}
    
    public void mStopGetBox() {
		mDoubleSolenoidGetBox.set(Value.kOff);
	}
    
}