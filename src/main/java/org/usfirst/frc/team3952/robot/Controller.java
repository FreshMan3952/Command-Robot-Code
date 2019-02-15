package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {

    public static final double deadzone = 0.1;
    public Joystick joystick;

    public Controller(Joystick joystick) {
        this.joystick = joystick;
    }

    public double getHorizontalMovement() {
        double x = joystick.getX();
        return Math.abs(x) >= deadzone ? Math.pow(x,3) : 0;
    }

    public double getLateralMovement() {
        double y = -joystick.getY();
        return Math.abs(y) >= deadzone ? Math.pow(y,3) : 0;
    }

    public double getRotation() {
        double t = joystick.getZ();
        return Math.abs(t) >= deadzone ? Math.pow(t, 3) : 0;
    }
}