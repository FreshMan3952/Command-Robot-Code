package org.usfirst.frc.team3952.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.drive.*;

import org.usfirst.frc.team3952.robot.*;
import org.usfirst.frc.team3952.robot.commands.*;

public class DriveTrain extends Subsystem {
	public MecanumDrive drive = RobotMap.drive;
	public Encoder rearLeft = RobotMap.rearLeftEncoder;
	public Encoder rearRight = RobotMap.rearRightEncoder;
	public ADXRS450_Gyro gyro = RobotMap.gyro;

	public void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

	public void drive(double hor, double lat, double rot) {
		drive.driveCartesian(lat, hor, rot);
	}

	public void stop() {
		drive.driveCartesian(0,  0,  0);
	}
}

