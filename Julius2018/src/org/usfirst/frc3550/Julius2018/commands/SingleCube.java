package org.usfirst.frc3550.Julius2018.commands;

import java.util.function.Function;

//import org.usfirst.frc.team340.robot.commands.claw.ClawShootScore;
//import org.usfirst.frc.team340.robot.commands.elevator.ElevatorGoToBottom;
//import org.usfirst.frc.team340.robot.commands.elevator.ElevatorGoToPosition;
//import org.usfirst.frc.team340.robot.commands.manual.ManualClawClose;
//import org.usfirst.frc.team340.robot.commands.manual.ManualClawOpen;
//import org.usfirst.frc.team340.robot.commands.manual.ManualElevatorTiltForward;
import org.usfirst.frc3550.Julius2018.commands.pathing.Path;
import org.usfirst.frc3550.Julius2018.commands.pathing.Paths;
import org.usfirst.frc3550.Julius2018.commands.pathing.RunPath;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SingleCube extends CommandGroup {
	/**
     * We calculate robot speedFast using the method 
     * speed
     * 
     * @param  x double-valued  single argument
     * 
     * @return y double-valued result
     * if x < 0.1 return 0.7 
     * if x < 0.85 return 0.85
     * else return 0.3
     */
	
	private final Function<Double, Double> speedFast = x -> {
		if(x < 0.1) {
			return 0.7;
		} else if (x < 0.85) { //0.
			return 0.85;
		} else {
			return 0.3; //former value 0.3
		}
	};
	private final Function<Double, Double> speedSlow = x -> {
		if(x < 0.3) {
			return 0.45; // former value 0.3
		} else if (x < 0.75) {
			return 0.35;
		} else {
			return 0.40; //former value 0.25
		}
	};
	
    public SingleCube(Path travelPath, Path finishPath, int elevatePosition, double shootSpeed) {
    	//addSequential(new ManualClawClose(), 0.1);
    	//addSequential(new ManualElevatorTiltForward(), 0.5);
    	addSequential(new WaitCommand(0.08));
    	//addSequential(new ElevatorGoToBottom(), 1.5);
//    	addSequential(new WaitCommand(0.5));
    	///addParallel(new ElevatorGoToPosition(1300), 1);
        addSequential(new RunPath(travelPath, speedFast), 2); //old value = 9.5
    	///addSequential(new WaitCommand(0.15));
    	///addParallel(new ElevatorGoToPosition(elevatePosition));
        addSequential(new RunPath(finishPath, speedFast), 4);
    	///addSequential(new RunPath(finishPath, speedSlow),12);
    	//addSequential(new WaitCommand(0.08));
    	///addSequential(new ClawShootScore(shootSpeed), 1);
    	
    	//addSequential(new RunPath(Paths.straightLength(50), 0.5), 1); // old value -0.3
    	///addParallel(new ElevatorGoToBottom(), 2);
    	//addSequential(new RunPath(Paths.straightLength(10), -0.6), 2.0);
//    	addSequential(new RunPath(Paths.straightLength(18), -0.7), 2.5);
    }
}
