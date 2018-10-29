package org.usfirst.frc.team4201.robot.commands;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	
	double kP = 0.03;
	double initialAngle;
	
	
    public DriveStraight(double timeout) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = Robot.driveTrain.driveGyro.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turnCorrection = (initialAngle - Robot.driveTrain.driveGyro.getAngle()) * kP;
    	
    	Robot.driveTrain.setDirectDriveOutput(0.5 + turnCorrection, 0.5 - turnCorrection);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setDirectDriveOutput(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
