// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autoDrive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class turnCounterClockwise extends CommandBase {
  private final DriveTrain m_driveTrain;
  private double degrees;
  
    /** Creates a new turnClockwise. */
  public turnCounterClockwise(DriveTrain driveTrain, double degrees) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = driveTrain;
    this.degrees = degrees;
    addRequirements(m_driveTrain);
  }

  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      m_driveTrain.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        m_driveTrain.tankDrive(-1 * degrees / 360, degrees / 360);

        if (m_driveTrain.getHeading() != -1 * 90) {
            System.out.print("you messed up");
        }
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
