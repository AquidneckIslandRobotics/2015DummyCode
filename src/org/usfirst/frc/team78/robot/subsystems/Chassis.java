package org.usfirst.frc.team78.robot.subsystems;

import org.usfirst.frc.team78.robot.Robot;
import org.usfirst.frc.team78.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	
	Victor leftFront = new Victor(0);
	Victor leftRear = new Victor(1);
	Victor rightFront = new Victor(2);
	Victor rightRear = new Victor(3);
	
	RobotDrive drive = new RobotDrive(leftFront,leftRear,rightFront,rightRear);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void driveWithJoysticks(){
    	double left = Robot.oi.driverStick.getY();
    	double right = Robot.oi.driverStick.getThrottle();
    	drive.tankDrive(left, right);
    }
    public void driveStraightWithJoystick(){
    	double power = Robot.oi.driverStick.getY();
    	drive.tankDrive(power, power);
    }
}

