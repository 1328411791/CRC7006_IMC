package org.usfirst.frc.team7006.robot.subsystems;

import org.usfirst.frc.team7006.robot.Robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroDriveSubsystem extends Subsystem implements PIDOutput
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	ADXRS450_Gyro mGyro;
	PIDController mPidController1;
	PIDController mPidController2;
	double rotateToAngleRate;
	//gyroDriveStaight mPidController1 parameter
	static final double mKp1 = 0.01f;
	static final double mKi1 = 0.0006f;
	static final double mKd1 = 0.000;
	static final double mKf1 = 0.000;
	static final double mAbsvalue1 = 2.0f;
	//gyroDriveStaight mPidController2 parameter
	static final double mKp2 = 0.03f;
	static final double mKi2 = 0.000f;
	static final double mKd2 = 0.000f;
	static final double mKf2 = 0.000f;
	static final double mAbsvalue2 = 2.0f;
	
	public GyroDriveSubsystem() 
	{
		mGyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
		//groDriveSTAIGHT mpidcontroller1
		mPidController1 = new PIDController(mKp1, mKi1, mKd1, mKf1, mGyro, this);
		mPidController1.setInputRange(Double.MIN_VALUE, Double.MAX_VALUE);
		mPidController1.setOutputRange(-1.0, 1.0);
		mPidController1.setAbsoluteTolerance(mAbsvalue1);
		mPidController1.setContinuous(true);
		mPidController1.disable();
		//groDriveSTAIGHT mpidcontroller2
		mPidController2 = new PIDController(mKp2, mKi2, mKd2, mKf2, mGyro, this);
		mPidController2.setInputRange(-180.0f, 180.0f);
		mPidController2.setOutputRange(-1.0, 1.0);
		mPidController2.setAbsoluteTolerance(mAbsvalue2);
		mPidController2.setContinuous(true);
		mPidController2.disable();
		
		
	}
    public void initDefaultCommand()
    {
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void gyroDriveStaight(Double driveSpeed, double gyroDriveAngle) 
    {
    	mPidController1.enable();
    	mPidController1.setSetpoint(gyroDriveAngle);
        Robot.m_driveSubsystem.mDrive.
    		tankDrive(-driveSpeed - rotateToAngleRate, -driveSpeed + rotateToAngleRate);
    	Timer.delay(0.005);
    	
    }
    public void gyroRotateToAngle(Double targetAngle)
    {
    	mPidController2.enable();
    	mPidController2.setSetpoint(targetAngle);
    	double mLeftSpeed = ((-0.43f - rotateToAngleRate) < -0.7 ? -0.7 : (-0.43f - rotateToAngleRate));
    	double mRightSpeed = ((0.43f + rotateToAngleRate) >  0.7 ?  0.7 : (-0.43f + rotateToAngleRate));
    	Robot.m_driveSubsystem.mDrive.
    		tankDrive(mLeftSpeed , mRightSpeed);
    	Timer.delay(0.005);
    	
    }
    public void resetGyro() 
    {
    	mGyro.reset();
    }
    public void disablePIDController1() 
    {
    	mPidController1.disable();
    }
    public void disablePIDController2() 
    {
    	mPidController2.disable();
    }
    public void stopGyroDrive() 
    {
    	Robot.m_driveSubsystem.mStopDrive();
    }

	public void pidWrite(double output) 
	{
		rotateToAngleRate = output;
	}
}

