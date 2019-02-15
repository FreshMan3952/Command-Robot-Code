package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.networktables.*;

import org.usfirst.frc.team3952.robot.subsystems.*;


public class Robot extends TimedRobot {
	public static Controller mainController;
	public static SubController subController;
	public static DriveTrain drive;
	public static Ladder ladder;
	public static PneumaticsSystem discHolder;

	public static NetworkTableInstance ntInst;
	public static NetworkTable nTable;
	public static NetworkTableEntry autoAlignX;
	public static NetworkTableEntry autoAlignY;

	@Override
	public void robotInit() {
		RobotMap.init();
		mainController = new Controller(new Joystick(0));
		subController = new SubController(new Joystick(1));
		drive = new DriveTrain();
		ladder = new Ladder();
		discHolder = new PneumaticsSystem();

		ntInst = NetworkTableInstance.getDefault();
		nTable = ntInst.getTable("datatable");
		autoAlignX = nTable.getEntry("movex");
		autoAlignY = nTable.getEntry("movey");
	}

	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}

	public static int[] distanceToCenter() {
		return new int[] {autoAlignX.getNumber(0).intValue(), autoAlignY.getNumber(0).intValue()};
	}
}
