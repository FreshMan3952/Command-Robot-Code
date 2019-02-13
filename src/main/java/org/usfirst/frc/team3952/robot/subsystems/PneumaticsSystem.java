package org.usfirst.frc.team3952.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import org.usfirst.frc.team3952.robot.*;
import org.usfirst.frc.team3952.robot.commands.*;

public class PneumaticsSystem extends Subsystem {
    public DoubleSolenoid piston = RobotMap.discSolenoid;

    public boolean extended;

    public void initDefaultCommand() {
        setDefaultCommand(new ManualDiscHolder());
    }

    public void shoot() {
        if(!extended) {
            //System.out.println("Its software's fault");
            piston.set(DoubleSolenoid.Value.kForward);
            extended = true;
        }
    }

    public void retract() {
        
        if(extended) {
          
            piston.set(DoubleSolenoid.Value.kReverse);
            extended = false;
        }
    }

    public void stop() {
        piston.set(DoubleSolenoid.Value.kOff);
    }
}