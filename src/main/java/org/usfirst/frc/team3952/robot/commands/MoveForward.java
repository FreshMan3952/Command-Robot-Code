package org.usfirst.frc.team3952.robot.commands;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;

public class MoveForward extends Command {
	public static final double DELTA = 0.01;
	public static final double SPEED = 0.3;
	public static final double CORRECTION = -0.015;
	
	public double initialDistance;
	public double distance;
	public boolean finished;

	public Encoder left = Robot.drive.rearLeft;
	public Encoder right = Robot.drive.rearRight;
	
	public MoveForward(double distance) {
		requires(Robot.drive);
		setInterruptible(false);
		this.distance = distance;
	}

	@Override
    protected void initialize() {
    	initialDistance = (left.getDistance() + right.getDistance()) / 2;
    }
    
	@Override
    protected void execute() {
    	double currentDistance = (left.getDistance() + right.getDistance()) / 2;
    	if(currentDistance >= initialDistance + distance - DELTA) {
    		Robot.drive.stop();
    		finished = true;
    	} else {
    		Robot.drive.drive(0, SPEED, CORRECTION);
		}		
    }
    
	@Override
    protected boolean isFinished() {
        return finished;
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
