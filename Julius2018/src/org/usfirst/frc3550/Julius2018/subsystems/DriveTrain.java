package org.usfirst.frc3550.Julius2018.subsystems;

import org.usfirst.frc3550.Julius2018.RobotMap;
import org.usfirst.frc3550.Julius2018.commands.ArcadeDrive;
//import com.kauailabs.navx.frc.AHRS;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	private final DifferentialDrive robotDrive41 = RobotMap.m_drive;
	private final Encoder LeftEncoder = RobotMap.m_leftEncoder;
	//private final Encoder RightEncoder = RobotMap.m_rightEncoder;
	private final DoubleSolenoid LeftMotorSolenoid = RobotMap.LeftMotorSolenoid;
	private final DoubleSolenoid mLeds       = RobotMap.mLeds;
	private AHRS ahrs;
	//private TrapezSpeedProfile trapez;

	public DriveTrain() {
		try {
			/* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
			/* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
			/* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
			ahrs = new AHRS(SPI.Port.kMXP); 
			//ahrs = new AHRS(SerialPort.Port.kUSB1); 
		} catch (RuntimeException ex ) {
			DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
		} 
		robotDrive41.setDeadband(0.02);
		LeftEncoder.setMaxPeriod(.1);
		LeftEncoder.setMinRate(0.1);
		LeftEncoder.setDistancePerPulse(0.0100); //0.0166 robot competition //robot de tests 0.0100
		LeftEncoder.setReverseDirection(false);
		LeftEncoder.setSamplesToAverage(7);

		//		RightEncoder.setMaxPeriod(.1);
		//		RightEncoder.setMinRate(0.1);
		//		RightEncoder.setDistancePerPulse(0.0166);// pi*6inches/(4.41*256) //robot tests 0.0100
		//		RightEncoder.setReverseDirection(true);
		//		RightEncoder.setSamplesToAverage(7);
		//
		//		addChild("Right Encoder", RightEncoder);
		addChild("Left Encoder", LeftEncoder);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new TankDriveWithJoystick());
		setDefaultCommand(new ArcadeDrive());
	}

	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis
	 *            Left sides value
	 * @param rightAxis
	 *            Right sides value
	 */
	public void tankDrive(double leftAxis, double rightAxis) {
		robotDrive41.tankDrive(leftAxis, rightAxis);
	}

	/**
	 * Arcade drive using individual joystick axes.
	 *
	 * @param leftAxis
	 *            Left sides value
	 * @param rightAxis
	 *            Right sides value
	 */
	public void arcadeDrive(Joystick stick) {
		robotDrive41.arcadeDrive(-stick.getY(), stick.getX());//(-)for the 2018 robot//
		//robotDrive41.arcadeDrive(stick.getY(), -stick.getX());//for the 2017 robot
	}
	public void arcadeDrive(double speed, double rotation) {
		robotDrive41.arcadeDrive(speed, rotation);
	}

	public void arcadeDrive(double speed, double rotation, boolean sensitivity) {
		robotDrive41.arcadeDrive(speed, rotation, sensitivity);
	}

	public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
		robotDrive41.curvatureDrive(xSpeed, zRotation, isQuickTurn);
	}

	/**
	 * Interface to Trapez.
	 */
	//	public void SetDistance(int distance, double vmax, double a) {
	//		trapez.SetDistance(distance, vmax, a);
	//	}
	//	
	//	public double DistanceMove() {
	//		double curSpeed = trapez.DistanceMove();
	//		robotDrive41.arcadeDrive(curSpeed, 0.0);
	//	}
	//	
	//	public boolean isDistanceDone() {
	//		return trapez.isDistanceDone();
	//	}

	/**
	 * Stop the drivetrain from moving.
	 */
	public void stop() {
		robotDrive41.tankDrive(0, 0);
	}

	public void reset() {
		LeftEncoder.reset();
		//RightEncoder.reset();
	}

	public Encoder getLeftEncoder() {
		return LeftEncoder;

	}

	public double getLeftDistance() {
		return LeftEncoder.getDistance();
	}

	//public double getRightDistance() {
	//	return RightEncoder.getDistance();
	//}

	public double getLeftRate() {
		return LeftEncoder.getDistance();
	}

	//public double getRightRate() {
	//return RightEncoder.getDistance();
	//}

	//public double getDistance() {
	//return (LeftEncoder.getDistance() + RightEncoder.getDistance()) / 2;
	//}

	public void speedUp() {
		LeftMotorSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void slowDown() {
		LeftMotorSolenoid.set(DoubleSolenoid.Value.kReverse);
	}

	public AHRS getAhrs()  {
		return ahrs;

	}

	public void disablerobotdrive41(){
		reset();
		getAhrs().reset();
		stop();
	}

	public void LedsOn() {
		mLeds.set(DoubleSolenoid.Value.kForward);
	}

	public void LedsOff() {
		mLeds.set(DoubleSolenoid.Value.kReverse);
	}
}



