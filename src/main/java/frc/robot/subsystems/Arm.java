/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.SparkMax;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   */
  // private final TalonSRX talon = new TalonSRX(1);
  private final PWMSparkMax sparky = new PWMSparkMax(4);

  public Arm() {
  }

  public void raise() {
    sparky.set(0.25);
  }

  public void lower() {
    sparky.set(-0.25);
  }

  public void stop() {
    sparky.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
