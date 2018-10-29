package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Conveyer extends Subsystem {
	public WPI_TalonSRX[] conveyerMotors = {
			new WPI_TalonSRX(RobotMap.conveyerMotor)
	};
	
	public Conveyer() {
		super("Conveyer");
		
		for(int i = 0; i < conveyerMotors.length; i++){
			conveyerMotors[i].configPeakOutputForward(1,0);
			conveyerMotors[i].enableVoltageCompensation(true);
			conveyerMotors[i].configVoltageCompSaturation(12, 0);
			conveyerMotors[i].setNeutralMode(NeutralMode.Coast);
		}
	}
	
	public void setDirectConveyerOutput(double output){
		conveyerMotors[0].set(ControlMode.PercentOutput, output);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

