package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class MoveLadderToNextPos extends Command {
    public static final double TIMEOUT = 8.0;
    //TODO: edit
    public static final double[] POSITIONS = new double[] {200, //panel #1
                                                           300, //ball #1
                                                           400, //panel #2
                                                           500, //ball #2
                                                           600, //panel #3
                                                           700  //ball #3
                                                          };
    public static final int DELTA = 15;

    public double pos;
    public boolean dir;
    public int diff;
    public boolean finished;

    public Encoder encoder = Robot.ladder.encoder;
    public DigitalInput topLimit = RobotMap.ladderTopLimit;
    public DigitalInput bottomLimit = RobotMap.ladderBottomLimit;

    public MoveLadderToNextPos(boolean dir) {
        requires(Robot.ladder);
        setTimeout(TIMEOUT);
        setInterruptible(false);
        this.dir = dir;
    }

    @Override
    protected void initialize() {
        if(Math.abs(encoder.getDistance() - pos) <= DELTA) {
            finished = true;
        }
    }

    @Override
    protected void execute() {
        if(dir) {
            Robot.ladder.extend();
        } else {
            Robot.ladder.retract();
        }
    }

    @Override
    protected boolean isFinished() {
        if(topLimit.get() || bottomLimit.get()) {
            return true;
        }
        return dir ? encoder.getDistance() >= pos : encoder.getDistance() <= pos;
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