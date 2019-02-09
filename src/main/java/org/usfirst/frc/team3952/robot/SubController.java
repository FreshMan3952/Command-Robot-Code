package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class SubController {
    public static final int GRAB_DISC = 0;
    public static final int RELEASE_DISC = 1;
    public static final int RESET_CLAW = 2;
    public static final int DEPLOY_CLAW = 3;
    public static final int MOVE_LADDER_UP = 4;
    public static final int MOVE_LADDER_DOWN = 5;
    public static final int[] MAP = {3,     //grab disc
                                     4,     //release disc
                                     5,     //reset claw
                                     8,     //deploy claw
                                     3,     //move ladder up
                                     2};    //move ladder down
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
        return joystick.getRawButtonPressed(MAP[GRAB_DISC]);
    }

    public boolean releaseDisc() {
        return joystick.getRawButtonPressed(MAP[RELEASE_DISC]);
    }

    public boolean resetClaw() {
        return joystick.getRawButtonPressed(MAP[RESET_CLAW]);
    }

    public boolean deployClaw() {
        return joystick.getRawButtonPressed(MAP[DEPLOY_CLAW]);
    }

    public boolean moveLadderUp() {
        return joystick.getRawButtonPressed(MAP[MOVE_LADDER_UP]);
    }

    public boolean moveLadderDown() {
        return joystick.getRawButtonPressed(MAP[MOVE_LADDER_DOWN]);
    }
}