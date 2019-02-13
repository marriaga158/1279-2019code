/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoArms extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX cargoArmTalon = RobotMap.cargoArmTalon;
  DigitalInput hatchArmSwitchFront = new DigitalInput(RobotMap.CARGO_ARM_SWITCH_ID_FRONT); // PLACEHOLDER NUMBER
  DigitalInput hatchArmSwitchRear = new DigitalInput(RobotMap.CARGO_ARM_SWITCH_ID_REAR);
  Counter counterFront = new Counter(hatchArmSwitchFront);
  Counter counterRear = new Counter(hatchArmSwitchRear);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void initializeCounter(){
    counterFront.reset();
    counterRear.reset();
  }

  /*public boolean isSwitchSet(){
    return counter.get() > 0;
  } */

  public void raiseArms(){
    cargoArmTalon.set(ControlMode.PercentOutput, 0.8); // placeholder speed, gotta do some testing for it
  }

  public void lowerArms(){
    cargoArmTalon.set(ControlMode.PercentOutput, -0.8); // also a placeholder speed
  }

  public void stop(){
    cargoArmTalon.stopMotor();
    cargoArmTalon.setNeutralMode(NeutralMode.Brake);
  }

  public boolean getFront(){
    return counterFront.get() > 0;
  }

  public boolean getRear(){
    return counterRear.get() > 0;
  }

}
