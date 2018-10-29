package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	public WPI_TalonSRX[] gearIntakeMotors = {
			new WPI_TalonSRX(RobotMap.gearIntakeMotor)
	};
	
	public GearIntake() {
		super("GearIntake");
		
		for(int i = 0; i < gearIntakeMotors.length; i++){
			gearIntakeMotors[i].configPeakOutputForward(1,0);
			gearIntakeMotors[i].enableVoltageCompensation(true);
			gearIntakeMotors[i].configVoltageCompSaturation(12, 0);
			gearIntakeMotors[i].setNeutralMode(NeutralMode.Coast);
		}
	}
	
	public void setDirectGearIntakeOutput(double output){
		gearIntakeMotors[0].set(ControlMode.PercentOutput, output);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

