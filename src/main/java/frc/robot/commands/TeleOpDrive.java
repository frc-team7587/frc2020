/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class TeleOpDrive extends CommandBase {
  /**
   * Creates a new TeleOpDrive.
   */

  private DriveTrain m_drive;
  private final DoubleSupplier m_y, m_twist;

  public TeleOpDrive(DoubleSupplier y, DoubleSupplier twist, DriveTrain subsystem) {
    addRequirements(subsystem);
    m_drive = subsystem;
    m_y = y;
    m_twist = twist;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.drive(m_y.getAsDouble(), m_twist.getAsDouble());
    // m_drive.drive(-stick.getY() * stick.getThrottle(), 0.75 * stick.getTwist() * Math.abs(stick.getThrottle()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
