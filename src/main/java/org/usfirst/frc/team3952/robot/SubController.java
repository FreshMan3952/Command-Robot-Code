package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class SubController {
    //require update
    public static final int GRAB_DISC = 3;
    public static final int RELEASE_DISC = 4;
    public static final int DEPLOY_CLAW = 8;
    public static final int MOVE_LADDER_UP = 6;
    public static final int MOVE_LADDER_DOWN = 7;
    public static final int OVERRIDE = 19999;
    public static final double DELTA = 0.5;
    
    public Joystick joystick;

    public SubController(Joystick joystick) {
        this.joystick = joystick;
    }

    public boolean extendLadder() {
        return joystick.getY() >= DELTA;
    }

    public boolean retractLadder() {
        return joystick.getY() <= -DELTA;
    }

    public boolean grabDisc() {
        return joystick.getRawButtonPressed(GRAB_DISC);
    }

    public boolean releaseDisc() {
        return joystick.getRawButtonPressed(RELEASE_DISC);
    }

    public boolean deployClaw() {
        return joystick.getRawButton(DEPLOY_CLAW);
    }

    public boolean moveLadderUp() {
        return joystick.getRawButtonPressed(MOVE_LADDER_UP);
    }

    public boolean moveLadderDown() {
        return joystick.getRawButtonPressed(MOVE_LADDER_DOWN);
    }

    public boolean override() {
        return joystick.getRawButtonPressed(OVERRIDE);
    }
}