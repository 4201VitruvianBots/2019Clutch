package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	public WPI_TalonSRX[] shooterMotors = {
			new WPI_TalonSRX(RobotMap.flywheelMaster),
			new WPI_TalonSRX(RobotMap.flywheelSlave)
	}; 
	
	public Shooter() {
		super("Shooter");
		
		//shooterMotors[1].set(ControlMode.Follower, shooterMotors[0].getDeviceID());
		
		for(int i = 0; i < shooterMotors.length; i++){
			shooterMotors[i].configPeakOutputForward(1,0);
			shooterMotors[i].enableVoltageCompensation(true);
			shooterMotors[i].configVoltageCompSaturation(12, 0);
			shooterMotors[i].setNeutralMode(NeutralMode.Coast);
		}
	}
	
	public void setDirectShooterOutput(double output){
		shooterMotors[0].set(ControlMode.PercentOutput, output);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}