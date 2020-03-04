/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import static frc.robot.Constants.*;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   */
  // private final PWMSparkMax sMax = new PWMSparkMax(ARM_SPARK_PWM_ID);
  private final CANSparkMax sparky = new CANSparkMax(1, MotorType.kBrushless);

  public void raise() {
    // sMax.set(-ARM_MAX_SPEED);
    sparky.set(-ARM_MAX_SPEED);
  }

  public void lower() {
    // sMax.set(ARM_MAX_SPEED);
    sparky.set(0.25 * ARM_MAX_SPEED);
  }

  public void stop() {
    // sMax.set(0);
    sparky.set(-0.05);
  }

  public void reset() {
    sparky.restoreFactoryDefaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
