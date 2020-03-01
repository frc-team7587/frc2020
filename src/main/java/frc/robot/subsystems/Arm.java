/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   */
  private final PWMSparkMax sMax = new PWMSparkMax(ARM_SPARK_PWM_ID);

  public void raise() {
    sMax.set(ARM_MAX_SPEED);
  }

  public void lower() {
    sMax.set(-ARM_MAX_SPEED);
  }

  public void stop() {
    sMax.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
