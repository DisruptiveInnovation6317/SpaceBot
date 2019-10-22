package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.OI;
import org.usfirst.frc.team6317.robot.Robot;

import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class ShooterCommand extends Command {
	private boolean useThrottle;

	public ShooterCommand(boolean useThrottle){
		this.requires(Robot.Shooter);
		this.useThrottle = useThrottle;
	}
	
	public ShooterCommand() {
		this(true);
	}
	
	protected void initialize(){
	}
	
	protected void execute(){
		Robot.Shooter.runShooter(useThrottle ? OI.controlStick.getAxis(AxisType.kThrottle) : -1);
	}

	@Override
	protected void end() {
		Robot.Shooter.stopShooter();
	}

	@Override
	protected boolean isFinished() {
		return false; //will be cancelled when user pressed button again
	}
}
