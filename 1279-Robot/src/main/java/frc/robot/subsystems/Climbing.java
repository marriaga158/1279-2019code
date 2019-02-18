/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climbing extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX cargoArmTalon = new WPI_TalonSRX(RobotMap.CARGO_ARM_TALON);
  private WPI_TalonSRX cargoArmTalon2 = new WPI_TalonSRX(RobotMap.CARGO_ARM_TALON_2);
  private SpeedControllerGroup cargoArmGroup = new SpeedControllerGroup(cargoArmTalon, cargoArmTalon2);
  private double speed = 0.70; // FASTER TO CLIMB

  DigitalInput hatchArmSwitchFront = new DigitalInput(RobotMap.CARGO_ARM_SWITCH_ID_FRONT); // PLACEHOLDER NUMBER
  DigitalInput hatchArmSwitchRear = new DigitalInput(RobotMap.CARGO_ARM_SWITCH_ID_REAR);
  Counter counterFront = new Counter(hatchArmSwitchFront);
  Counter counterRear = new Counter(hatchArmSwitchRear);
  @Override

  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void initializeCounter()
  {
    counterFront.reset();
    counterRear.reset();
  }

  public void climb()
  {
    cargoArmGroup.set(speed * -1); // also a placeholder speed
  }

  public void stop()
  {
    cargoArmGroup.stopMotor();
    cargoArmTalon.setNeutralMode(NeutralMode.Brake);
    cargoArmTalon2.setNeutralMode(NeutralMode.Brake);
  }

  public boolean getFront()
  {
    return counterFront.get() > 0;
  }

  public boolean getRear()
  {
    return counterRear.get() > 0;
  }

}