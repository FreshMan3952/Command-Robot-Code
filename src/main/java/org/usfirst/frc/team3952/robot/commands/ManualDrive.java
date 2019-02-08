package org.usfirst.frc.team3952.robot.commands;

import org.usfirst.frc.team3952.robot.Robot;
import org.usfirst.frc.team3952.robot.RobotMap;

import edu.wpi.first.wpilibj.command.*;

public class ManualDrive extends Command { 
    public static final double DELTA = 2.5;
    
    public ManualDrive() {
        requires(Robot.drive);
        setInterruptible(true);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
    	double hor = Robot.mainController.getHorizontalMovement();
    	double lat = Robot.mainController.getLateralMovement();
        double rot = Robot.mainController.getRotation();
        Robot.drive.drive(hor, lat, rot);
        
        if(Robot.subController.resetClaw()) {
            RobotMap.servo.setAngle(0);
        } else if(Robot.subController.deployClaw() && Math.abs(RobotMap.servo.getAngle()) < DELTA) {
            Scheduler.getInstance().add(new DeployClaw());
        }
    }

    @Override
    protected boolean isFinished() {
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
