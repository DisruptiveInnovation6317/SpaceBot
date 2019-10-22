package org.usfirst.frc.team6317.robot.commands;

import org.usfirst.frc.team6317.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class KickCommand extends Command {

	public KickCommand(){
		this.requires(Robot.Kicker);
	}
	
	protected void initialize(){
		
	}
	protected void execute(){
		Robot.Kicker.runkick();
	}

	@Override
	protected void end() {
		Robot.Kicker.stopkick();
	}

	@Override
	protected boolean isFinished() {
		return false; //will be cancelled when user pressed button again
	}
}
