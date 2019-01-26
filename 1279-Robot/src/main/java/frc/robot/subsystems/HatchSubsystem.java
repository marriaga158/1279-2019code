/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchSubsystem extends Subsystem 
{
  
  int hatchTalonID = RobotMap.getHatchTalonID();
  WPI_TalonSRX hatchTalon = new WPI_TalonSRX(hatchTalonID);

  static final double waitTime = 0.8;
  Timer hatchTimer = new Timer();

  public HatchSubsystem(int talonIDForHatch, WPI_TalonSRX talonForHatch)
  {
    this.hatchTalonID = talonIDForHatch;
    this.hatchTalon = talonForHatch;
  }

  @Override
  public void initDefaultCommand()
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void spinToGetHatch()
  {
    hatchTalon.set(ControlMode.PercentOutput, 0.8);
    Timer.delay(waitTime); // seconds
  }

  public void spinToReleaseHatch()
  {
    hatchTalon.set(ControlMode.PercentOutput, -0.8);
    Timer.delay(waitTime);
  }

  public void stopSpin()
  {
    hatchTalon.set(ControlMode.PercentOutput, 0);
  }

}