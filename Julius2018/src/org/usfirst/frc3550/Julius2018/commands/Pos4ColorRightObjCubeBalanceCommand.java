// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3550.Julius2018.commands;

import org.usfirst.frc3550.Julius2018.Robot;

//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

//public final float INCHES2MM = 25.4;

/**
 *
 */
public class Pos4ColorRightObjCubeBalanceCommand extends CommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Pos4ColorRightObjCubeBalanceCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    	addSequential(new AutoDriveDistanceCommand(325, 1)); // 0:Backward / 1:Forward
    	addSequential(new AutoDriveRotateCommand(90,   0));    // 0:Left     / 1:Right
    	addSequential(new AutoDriveDistanceCommand(7, 1)); // 0:Backward / 1:Forward
    	addSequential(new DropCubeCommand());
    	//addSequential(new OuvrePince());
    }
}
