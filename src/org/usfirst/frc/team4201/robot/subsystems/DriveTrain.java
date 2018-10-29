package org.usfirst.frc.team4201.robot.subsystems;

import org.usfirst.frc.team4201.robot.RobotMap;
import org.usfirst.frc.team4201.robot.commands.TankDrive;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	
	public TalonSRX[] driveMotors = {
		new TalonSRX(RobotMap.driveTrainLeftFront),
		new TalonSRX(RobotMap.driveTrainLeftRear),
		new TalonSRX(RobotMap.driveTrainRightFront),
		new TalonSRX(RobotMap.driveTrainRightRear)
	};
	
	public ADXRS450_Gyro driveGyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	public DriveTrain() {
		super("DriveTrain");

		driveMotors[0].setInverted(false);
		driveMotors[1].setInverted(false);
		driveMotors[2].setInverted(true);
		driveMotors[3].setInverted(true);

		//set Motor Controller Control Mode
		driveMotors[1].set(ControlMode.Follower, RobotMap.driveTrainLeftFront);
		driveMotors[3].set(ControlMode.Follower, RobotMap.driveTrainRightFront);
		
        for(int i = 0; i < 4; i++){
        driveMotors[i].configPeakOutputForward(1, 0);
        driveMotors[i].configPeakOutputReverse(-1, 0);
        driveMotors[i].enableVoltageCompensation(true);
        driveMotors[i].configVoltageCompSaturation(12, 0);
        driveMotors[i].setNeutralMode(NeutralMode.Coast);
        }
	}
	
	public void setDirectDriveOutput(double leftOutput, double rightOutput) {
		driveMotors[0].set(ControlMode.PercentOutput, leftOutput);
		driveMotors[2].set(ControlMode.PercentOutput, rightOutput);
	}
	
	public void arcadeDrive(double leftYAxis, double rightXAxis) {
		double leftOutput = leftYAxis - rightXAxis;
		double rightOutput = leftYAxis + rightXAxis;
		
		driveMotors[0].set(ControlMode.PercentOutput, leftOutput);
		driveMotors[1].set(ControlMode.PercentOutput, rightOutput);
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDrive());
    }
}