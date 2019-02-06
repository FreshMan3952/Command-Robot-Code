package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class AutoAlign extends Command {
    public static final int MIN_DISTANCE_FROM_TARGET = 10;
    public static final int PERIOD = 30;
    public static final int STEP = 5;
    public static final double STEPPING_SPEED = 0.7;

    private int cnt = 0;

    public AutoAlign() {
        requires(Robot.drive);
        setInterruptible(true);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        if(cnt++ % PERIOD <= STEP) {
            if(Robot.distanceToCenter()[0] > 0) {
                Robot.drive.drive(STEPPING_SPEED, 0, 0);
            } else {
                Robot.drive.drive(-STEPPING_SPEED, 0, 0);
            }
        } else {
            Robot.drive.stop();
        }
    }

    @Override
    protected boolean isFinished() {
        if(Math.abs(Robot.distanceToCenter()[0]) < MIN_DISTANCE_FROM_TARGET) {
            Robot.drive.stop();
            return true;
        }
        return false;
    }

    @Override
    protected void end() {
    	Robot.drive.stop();
    }

    @Override
    protected void interrupted() {
    	Robot.drive.stop();
    }
}