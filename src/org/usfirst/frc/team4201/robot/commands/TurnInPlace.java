package org.usfirst.frc.team4201.robot.commands;

import org.usfirst.frc.team4201.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnInPlace extends Command {
	
	double kP = 0.03;
	double degrees, initialAngle, targetAngle;
	
	
    public TurnInPlace(double degrees) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.degrees = degrees;
        setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = Robot.driveTrain.driveGyro.getAngle();
    	
    	targetAngle = initialAngle + degrees;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turnCorrection = (targetAngle - Robot.driveTrain.driveGyro.getAngle()) * kP;
    	
    	Robot.driveTrain.setDirectDriveOutput(turnCorrection, -turnCorrection);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(targetAngle - Robot.driveTrain.driveGyro.getAngle()) < 0.2 || isTimedOut();
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
