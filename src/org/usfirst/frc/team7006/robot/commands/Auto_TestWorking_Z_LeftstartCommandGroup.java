package org.usfirst.frc.team7006.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_TestWorking_Z_LeftstartCommandGroup extends CommandGroup {

    public Auto_TestWorking_Z_LeftstartCommandGroup() {
    	addSequential(new Auto_Runaline_forwardCommand(), 2.8);
    	addParallel(new C_PenuGetBoxCommand());
    	addParallel(new B_LiftArmUpCommand(), 1.3);      
    	addSequential(new A_RotateToP90());
    	addSequential(new B_CastBoxCommand(),1);
    	addSequential(new A_RotateToZero());
    	addParallel(new B_LiftArmDownCommand(), 1.3);
    	addParallel(new C_PenuLoosenBoxCommand());
    	addSequential(new A_RotateTo135());
    	addSequential(new Auto_Runaline_forwardCommand(), 0.6);
    	addParallel(new C_PenuGetBoxCommand());
    	addSequential(new B_CatchBoxCommand(),1.0);
    	addSequential(new B_LiftArmUpCommand(),1.3);
    	addSequential(new B_CastBoxCommand());
    	addParallel(new Auto_Runaline_backwardCommand(), 0.6);
    	addSequential(new B_LiftArmDownCommand(),1.3);
    	
    	// Add Commands here:        // e.g. addSequential(new Command1());        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
