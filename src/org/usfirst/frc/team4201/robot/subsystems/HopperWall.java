package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HopperWall extends Subsystem {
	DoubleSolenoid hopperWall = new DoubleSolenoid(RobotMap.PCMOne, RobotMap.hopperWallForward, RobotMap.hopperWallReverse);
	
	public HopperWall() {
		super("HopperWall");
	}
	
	public void hopperExtend(){
		hopperWall.set(Value.kForward);
	}
	
	public void hopperRetract(){
		hopperWall.set(Value.kReverse);
	}
	
	public Value checkHopperWallStatus(){
		return hopperWall.get();
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

