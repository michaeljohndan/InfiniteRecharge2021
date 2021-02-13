// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autoDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class moveSomeDistance extends CommandBase {
  private DriveTrain m_driveTrain;
  private double distance;
 
  /** Creates a new moveSomeDistance. */
  public moveSomeDistance(DriveTrain driveTrain, double distance) {
    m_driveTrain = driveTrain;
    this.distance = distance;
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double input = this.distance / (6 * Math.PI);
    m_driveTrain.tankDrive(input, input);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
