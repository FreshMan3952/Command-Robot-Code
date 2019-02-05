package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;

public class SubController {
   

    public Joystick joystick;

  
    final static int[] LUCAS_CONTROLLER = {1, 2, 3, 4, 5};

    int[] currentController;

    public SubController(Joystick joystick) {
        this.joystick = joystick;
        currentController = LUCAS_CONTROLLER;
        
    }

    public boolean extendLadder() {
        return joystick.getRawButton(currentController[0]);
    }

    public boolean retractLadder() {
        return joystick.getRawButton(currentController[1]);
    }

    public boolean grabDisc() {
        return joystick.getRawButton(currentController[2]);
    }

    public boolean releaseDisc() {
        return joystick.getRawButton(currentController[3]);
    }

    public boolean clawDeploy(){
        return joystick.getRawButton(currentController[4]);
    }
    
    public boolean goToLadder(int level)
    {
        return joystick.getRawButton(level);
    }

    
}