package org.usfirst.frc.team7006.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_TestWorking_Z_MIddlestartCommandGroup extends CommandGroup {

    public Auto_TestWorking_Z_MIddlestartCommandGroup() {
    	addSequential(new Auto_Runaline_forwardCommand(),2);
    	addParallel(new B_LiftArmUpCommand(), 1.3);
    	addSequential(new B_CastBoxCommand());
    	addSequential(new Auto_Runaline_backwardCommand(), 1);
    	addParallel(new B_LiftArmDownCommand(),1.3);
    	addSequential(new C_PenuLoosenBoxCommand());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
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
