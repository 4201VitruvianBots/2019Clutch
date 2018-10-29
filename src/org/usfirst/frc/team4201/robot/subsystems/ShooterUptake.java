package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterUptake extends Subsystem {
	public WPI_TalonSRX[] shooterUptakeMotors = {
	    new WPI_TalonSRX(RobotMap.shooterUptake)
	};
	
	public ShooterUptake() {
		super("ShooterUptake");
		
		for(int i = 0; i < shooterUptakeMotors.length; i++){
			shooterUptakeMotors[i].configPeakOutputForward(1, 0);
			shooterUptakeMotors[i].enableVoltageCompensation(true);
			shooterUptakeMotors[i].configVoltageCompSaturation(12, 0);
			shooterUptakeMotors[i].setNeutralMode(NeutralMode.Coast);
		}
	}	
	
	public void setDirectShooterUptakeOutput(double output){
		shooterUptakeMotors[0].set(ControlMode.PercentOutput, output);	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

