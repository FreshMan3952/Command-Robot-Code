package org.usfirst.frc.team3952.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;
import org.usfirst.frc.team3952.robot.commands.*;
public class Ladder extends Subsystem {
	public static final double LADDER_EXTENDING_SPEED = 0.65;
	public static final double LADDER_RETRACTING_SPEED = 0.4;

	public PWMVictorSPX ladder = RobotMap.ladder;
	public Encoder encoder = RobotMap.ladderEncoder;
	public DigitalInput topLimit = RobotMap.ladderTopLimit;
	public DigitalInput bottomLimit = RobotMap.ladderBottomLimit;

	public void initDefaultCommand() {
		setDefaultCommand(new ManualLadder());
	}

	public void extend() {
		if(!topLimit.get()) {
			ladder.set(LADDER_EXTENDING_SPEED);
		} else {
			stop();
		}
	}

	public void retract() {
		if(!bottomLimit.get()) {
			ladder.set(-LADDER_RETRACTING_SPEED);   
		} else {
			stop();
			encoder.reset();
		}
	}

	public void stop() {
		ladder.set(0);
	}
}