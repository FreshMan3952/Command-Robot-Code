package org.usfirst.frc.team3952.robot.commands;

import org.usfirst.frc.team3952.robot.Robot;
import org.usfirst.frc.team3952.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

public class ManualDrive extends Command {    
    public ManualDrive() {
        requires(Robot.drive);
        setInterruptible(true);
    }

    protected void initialize() {}

    double rotateBy = 0;

    protected void execute() {
    	double hor = Robot.mainController.getHorizontalMovement();
    	double lat = Robot.mainController.getLateralMovement();
        double rot = Robot.mainController.getRotation();
        
        Robot.drive.drive(hor, lat, rot);
        System.out.println("hor: " + hor + "\r\nlat: " + lat + "\r\nrot: " + rot);
        System.out.println(RobotMap.frontLeftWheel.get());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.stop();
    }

    protected void interrupted() {
    	Robot.drive.stop();
    }
}
