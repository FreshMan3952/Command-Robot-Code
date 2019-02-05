package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
    public double c = 0.1;
    public double deadzone = 0.2;
    public double max = 0.8;
    public double k = (max - c) / Math.log(2 - deadzone);

    public double cT = 0.08;
    public double deadzoneT = 0.08;
    public double maxT = 0.4;
    public double kT = (maxT - cT) / Math.log(2 - deadzoneT);

    public Joystick joystick;

    // MAP(manualExtendLadder, manualRetractLadder, ball drop, ball retract, grab, release)
    final static int[] SIDEWINDER_MAP = {3, 4, 1, 2, 7, 6, 8};

   

    int[] currentController;

    public Controller(Joystick joystick) {
        this.joystick = joystick;
        currentController = SIDEWINDER_MAP;
        
    }

    public double getHorizontalMovement() {
        double x = joystick.getX();
        return Math.abs(x) >= deadzone ? k * Math.signum(x) * (Math.log(Math.abs(x) + 1 - deadzone) + c) : 0;
    }

    public double getLateralMovement() {
        double y = -joystick.getY();
        return Math.abs(y) >= deadzone ? k * Math.signum(y) * (Math.log(Math.abs(y) + 1 - deadzone) + c) : 0;
    }

    public double getRotation() {
        double t = joystick.getZ();
        return Math.abs(t) >= deadzoneT ? kT * Math.signum(t) * (Math.log(Math.abs(t) + 1 - deadzoneT) + cT) : 0;
    }


    
}