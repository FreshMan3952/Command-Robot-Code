package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class DeployClaw extends Command {
    public DeployClaw() {
        setInterruptible(false);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        RobotMap.clawDeploy.setAngle(90);
    }

    @Override
    protected boolean isFinished() {
        // ?
        return true;
    }

    @Override
    protected void end() {}

    @Override
    protected void interrupted() {}
}