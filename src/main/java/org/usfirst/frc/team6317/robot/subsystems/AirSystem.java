package org.usfirst.frc.team6317.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AirSystem extends Subsystem{

	public AirSystem(){
		Compressor c = new Compressor(0);
		c.setClosedLoopControl(true);	
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
