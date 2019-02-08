package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class SubController {
    public static final int[] MAP = {1,     // extend ladder 
                                     2,     // retract ladder
                                     3,     // grab disc
                                     4,     // release disc
                                     5,     // reset claw
                                     8};    // deploy claw
    
    public Joystick joystick;

    public SubController(Joystick joystick) {
        this.joystick = joystick;
    }

    public boolean extendLadder() {
        return joystick.getRawButton(MAP[0]);
    }

    public boolean retractLadder() {
        return joystick.getRawButton(MAP[1]);
    }

    public boolean grabDisc() {
        return joystick.getRawButton(MAP[2]);
    }

    public boolean releaseDisc() {
        return joystick.getRawButton(MAP[3]);
    }

    public boolean resetClaw() {
        return joystick.getRawButton(MAP[4]);
    }

    public boolean deployClaw() {
        return joystick.getRawButton(MAP[5]);
    }

    public double getLateralMovement() {
         return joystick.getY();
        
    }
}