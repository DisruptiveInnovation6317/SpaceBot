package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {	
/*
 * This command is used for running the drive during auto
 * When programming auto you call this command and pass through a string and an integer
 * The string is based off of the function you want to run
 * The integer is the amount of time you want the function to run
 * The command is designed to run in sequence of multiple instances
 * At the end of the command the drive stops automatically
 * 
 * addSequential(new DriveCommand("for", 3)); //drives forward for 3 seconds
 * 
 * List of Strings to call
 * for = forward
 * back = backwards
 * clock = clockwise (spins on a point clockwise)
 * cc = counterclockwise (spins on a point counterclockwise)
 * left = left (kind of pivots towards the left)
 * right = right (kind of pivots towards the right)
 * stop = stop
 */
	public String drive;
	public double time;
	private long startTime;
	private double speed;
	
	public DriveCommand(String dr, double timeout, double speed) {
		this.requires(Robot.DriveTrain);
		drive = dr;
		time = timeout;
		this.speed = speed;
	}
	
	public DriveCommand(String dr, double timeout) {
		this(dr, timeout, 1);
	}
	
	@Override
	protected void initialize() {
		Robot.DriveTrain.stop();
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		if(drive == "for")
			Robot.DriveTrain.forward(speed);
		if(drive == "back")
			Robot.DriveTrain.backward();
		if(drive == "clock")
			Robot.DriveTrain.clockwise();
		if(drive == "cc")
			Robot.DriveTrain.counterClockwise();
		if(drive == "left")
			Robot.DriveTrain.left();
		if(drive == "right")
			Robot.DriveTrain.right();
		if(drive == "stop")
			Robot.DriveTrain.stop();
		
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) / 1000.0 >= time;
	}

	@Override
	protected void end() {
		Robot.DriveTrain.stop();
	}
}