package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class ManualLadder extends Command {
    public ManualLadder() {
        requires(Robot.ladder);
        setInterruptible(true);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
    	if(Robot.subController.extendLadder()) {
            Robot.ladder.extend();
            //testing for value
            System.out.println(RobotMap.ladderEncoder.get());
        } else if(Robot.subController.retractLadder()) {
            Robot.ladder.retract();
            //test for value
            System.out.println(RobotMap.ladderEncoder.get());
		} 
			Robot.ladder.stop();
    }
    

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.ladder.stop();
    }
    
    @Override
    protected void interrupted() {
    	Robot.ladder.stop();
    }
}
