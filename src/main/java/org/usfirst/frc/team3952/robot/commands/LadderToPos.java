package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import org.usfirst.frc.team3952.robot.RobotMap;
import org.usfirst.frc.team3952.robot.*;

public class LadderToPos extends Command {
  
    public boolean stickPressed;
    public int level;
    public Encoder encoder = Robot.ladder.encoder;

    //TODO: edit
    public static final int[] POSITIONS = new int[] {200 //hatch #1
                                                   , 300 //hatch #2
                                                   , 400 //hatch #3
                                                   , 500 //ball #1
                                                   , 600 //ball #2
                                                   , 700 //ball #3
                                                };
    public static final double DELTA = 0.2;

   

    public DigitalInput topLimit = RobotMap.ladderTopLimit;
    public DigitalInput bottomLimit = RobotMap.ladderBottomLimit;

    public LadderToPos() {
        requires(Robot.ladder);
        setInterruptible(false);
    }

    @Override
    protected void initialize() {
        stickPressed = false;
        level = 1;
    }

    @Override
    protected void execute() {
        if ( Robot.subController.getLateralMovement() > 0.5 && stickPressed == false && level < 6 ){
            level ++;
            stickPressed = true;
        }else if ( Robot.subController.getLateralMovement() < -0.5 && stickPressed == false && level > 1 ){
            level --;
            stickPressed = true;
        }else if( 0 - Math.abs(Robot.subController.getLateralMovement() ) < 0.15) {
            stickPressed = false;
        }

        if ( POSITIONS[level - 1] > 10 - Math.abs(0 - encoder.getDistance()) && !topLimit.get()){
            Robot.ladder.extend();
        } else if (POSITIONS[level - 1] < 10 - Math.abs(0-encoder.getDistance()) && !bottomLimit.get() ){
            Robot.ladder.retract();
        }else Robot.ladder.stop();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
      
    }

    @Override
    protected void interrupted() {
        Robot.ladder.stop();
    }
}
