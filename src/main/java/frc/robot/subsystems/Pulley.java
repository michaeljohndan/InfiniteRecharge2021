// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Pulley extends SubsystemBase {
  private final Solenoid solenoid;
  private boolean isIn;  
 
  /** Creates a new Pulley. */
  public Pulley() {
      solenoid = new Solenoid(Constants.PULLEY_SOLENOID);
      isIn = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void push() {
    if (!isIn) {
      solenoid.toggle();
      isIn = !isIn;
    } else {
      solenoid.toggle();
      isIn = !isIn;
    }
  }
}
