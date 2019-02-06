package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;



public class DeployClaw extends Command {
    public boolean isFinished;
    

    public DeployClaw() {
        setInterruptible(false);
    }

    @Override
    protected void initialize() {
        isFinished = false;
    }

    @Override
    protected void execute() {
        RobotMap.clawDeploy.setAngle(90.0);
        if(RobotMap.clawDeploy.getAngle() == 90.0){
            isFinished = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return isFinished;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}