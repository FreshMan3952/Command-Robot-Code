/*package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class MoveLadderToPos extends Command {
    public static final double TIMEOUT = 8.0;
    //TODO: edit
    public static final int[] POSITIONS = new int[] {200, 300, 400, 500, 600, 700};
    public static final double DELTA = 0.2;

    public double pos;
    public boolean dir;
    public int diff;

    public DigitalInput topLimit = RobotMap.ladderTopLimit;
    public DigitalInput bottomLimit = RobotMap.ladderBottomLimit;

    public MoveLadderToPos(int pos) {
        requires(Robot.ladder);
        setTimeout(TIMEOUT);
        setInterruptible(false);
        this.pos = POSITIONS[pos];
    }

    @Override
    protected void initialize() {
        dir = (pos - Robot.ladder.encoder.getDistance()) > 0;
    }

    @Override
    protected void execute() {
        if(dir) {
            Robot.ladder.extend();
        } else {
            Robot.ladder.retract();
        }
        dir = (pos - Robot.ladder.encoder.getDistance()) > 0;
    }

    @Override
    protected boolean isFinished() {
        if(topLimit.get() || bottomLimit.get()) {
            return true;
        }
        if(Math.abs(pos - Robot.ladder.encoder.getDistance()) < DELTA) {
            return true;
        }
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
*/