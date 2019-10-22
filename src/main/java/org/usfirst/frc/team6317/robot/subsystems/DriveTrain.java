package org.usfirst.frc.team6317.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team6317.robot.*;
import org.usfirst.frc.team6317.robot.commands.DefaultCommand;

public class DriveTrain extends Subsystem {
	
	public void initDefaultCommand(){
		this.setDefaultCommand(new DefaultCommand());
	}
	
	public Encoder enc = new Encoder(2,1);
	
	public DriveTrain(){
		enc.setDistancePerPulse(1);
		LiveWindow.addActuator("DriveTrain", "Left 1", (Victor) RobotMap.leftDrive1);
		LiveWindow.addActuator("DriveTrain", "Left 2", (Victor) RobotMap.leftDrive2);
		LiveWindow.addActuator("DriveTrain", "Right 1", (Victor) RobotMap.rightDrive1);
		LiveWindow.addActuator("DriveTrain", "Right 2", (Victor) RobotMap.rightDrive2);
		LiveWindow.addSensor("DriveTrain", "LeftEncoder", enc);
	}
	
	
	public void stop(){	//makes the robot stop
		RobotMap.leftDrive1.set(0);
		RobotMap.leftDrive2.set(0);
		RobotMap.rightDrive1.set(0);
		RobotMap.rightDrive2.set(0);
	}
	
	public void backward(){ // makes the robot drive forward
		RobotMap.leftDrive1.set(-1);
		RobotMap.leftDrive2.set(-1);
		RobotMap.rightDrive1.set(1);
		RobotMap.rightDrive2.set(1);
	}
	
	public void forward(double speed){ //makes the robot drive backwards
		RobotMap.leftDrive1.set(speed);
		RobotMap.leftDrive2.set(speed);
		RobotMap.rightDrive1.set(-speed);
		RobotMap.rightDrive2.set(-speed);
	}
	
	public void left(){ //makes the left side drive forward
		RobotMap.leftDrive1.set(-1);
		RobotMap.leftDrive2.set(-1);
		RobotMap.rightDrive1.set(0);
		RobotMap.rightDrive2.set(0);
	}
	
	public void right(){ //makes the right side drive forward
		RobotMap.leftDrive1.set(0);
		RobotMap.leftDrive2.set(0);
		RobotMap.rightDrive1.set(-1);
		RobotMap.rightDrive2.set(-1);
	}
	
	public void clockwise(){ //makes the robot spin clockwise
		RobotMap.leftDrive1.set(1);
		RobotMap.leftDrive2.set(1);
		RobotMap.rightDrive1.set(1);
		RobotMap.rightDrive2.set(1);
	}
	
	public void counterClockwise(){ //makes the robot spin counter clockwise
		RobotMap.leftDrive1.set(-1);  
		RobotMap.leftDrive2.set(-1);
		RobotMap.rightDrive1.set(-1);
		RobotMap.rightDrive2.set(-1);
	}
}
