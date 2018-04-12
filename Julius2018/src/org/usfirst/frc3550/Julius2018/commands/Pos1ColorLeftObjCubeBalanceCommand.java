
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

import edu.wpi.first.wpilibj.command.CommandGroup;

//public final float INCHES2MM = 25.4;

/**
 *
 */
public class Pos1ColorLeftObjCubeBalanceCommand extends CommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Pos1ColorLeftObjCubeBalanceCommand() {

    	addSequential(new AutoDriveDistanceCommand(150,1));//29 //150// 0:Backward / 1:Forward //150--15
    	//addParallel(new DropCubeCommand()); //Regis commented this when testing
    	addSequential(new AutoDriveRotateCommand(90,1)); // 0:Left     / 1:Right
    	//addParallel(new PickupCubeCommand());//DropCubeCommand||the real is PickupCommand in 2018
    	addSequential(new AutoDriveDistanceCommand(10,1));//10 //20
    	//addParallel(new DropCubeCommand()); Regis commented this when testing
    	/*addSequential(new AutoDriveDistanceCommand(325, 1)); // 0:Backward / 1:Forward
    	addSequential(new RotateController(90, 1)); // 0:Left     / 1:Right
    	addSequential(new AutoDriveDistanceCommand(7, 1));
    	addSequential(new OuvrePince());*/
    	
    	
    	
//    	addSequential(new AutoDriveDistanceCommand(29,1));//29 //150// 0:Backward / 1:Forward
//    	//addParallel(new DropCubeCommand());
//    	addSequential(new AutoDriveRotateCommand(90,1)); // 0:Left     / 1:Right
//    	addParallel(new PickupCubeCommand());//DropCubeCommand||the real is PickupCommand in 2018
//    	addSequential(new AutoDriveDistanceCommand(10,1));//10 //20
    }


}
