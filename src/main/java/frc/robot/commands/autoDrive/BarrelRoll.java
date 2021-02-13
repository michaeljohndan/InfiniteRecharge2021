// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autoDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BarrelRoll extends SequentialCommandGroup {
    private final DriveTrain m_driveTrain;
    private Timer timer;
    
    /** Creates a new BarrelRoll. */
    public BarrelRoll(DriveTrain driveTrain) {
      m_driveTrain = driveTrain;
      timer = new Timer();

      addRequirements(m_driveTrain);
    }

      /**
     * Makes the robot travel a certain distance without calculation 
     * The length of the distance divided by the circumference of the wheel
     * gives the number of rotations needed to  
    */
    public void travelDistance(double distance) {
      double input = distance / Math.PI * 6;
      m_driveTrain.tankDrive(input, input);
    }

    

    /**
     * turns the robot in place counterclockwise (TEST)
     * @param degrees
     */
    public void turnCounterClockwise(double degrees) { 
      double angleBefore = m_driveTrain.getHeading();
      m_driveTrain.tankDrive(degrees / 360, -1 * degrees / 360);
      double angleAfter = m_driveTrain.getHeading();

      if (angleBefore - angleAfter != -90) {
          System.out.print("you messed up");
      }
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

}
