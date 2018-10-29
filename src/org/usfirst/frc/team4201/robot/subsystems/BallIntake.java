package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallIntake extends Subsystem {
	public WPI_TalonSRX[] ballIntakeMotors = {
			new WPI_TalonSRX(RobotMap.ballIntakeMotor)
	};
	
	public BallIntake() {
		super("BallIntake");
		
		for(int i = 0; i < ballIntakeMotors.length; i++){
			ballIntakeMotors[i].configPeakOutputForward(1,0);
			ballIntakeMotors[i].enableVoltageCompensation(true);
			ballIntakeMotors[i].configVoltageCompSaturation(12, 0);
			ballIntakeMotors[i].setNeutralMode(NeutralMode.Coast);
		}
	}
	
	public void setDirectBallIntakeOutput(double output){
		ballIntakeMotors[0].set(ControlMode.PercentOutput, output);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

