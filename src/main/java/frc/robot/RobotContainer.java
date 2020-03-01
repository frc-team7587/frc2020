package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;

public class RobotContainer {

    // Subsystems
    private final DriveTrain m_drive = new DriveTrain();
    private final Intake m_intake = new Intake();
    private final Hanger m_hanger = new Hanger();
    private final Spinner m_spinner = new Spinner();
    private final Arm m_arm = new Arm();

    // Controllers
    final Joystick logi = new Joystick(0);
    final Joystick gamePad = new Joystick(1);

    private final Command m_autoCommand = new AutoPortDeploy(m_drive, m_intake);

    public RobotContainer() {

        m_drive.setDefaultCommand(
            new RunCommand(() -> m_drive.drive(-logi.getY() * logi.getThrottle(),
                0.75 * logi.getTwist() * Math.abs(logi.getThrottle())), m_drive)
            );

        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        // Gamepad Buttons to ID

        // Buttons
        final Button btnOut = new JoystickButton(gamePad, BUMP_RIGHT); // Right bumper
        final Button btnIn = new JoystickButton(gamePad, BUMP_LEFT); // Left bumper
        final Button btnHangEx = new JoystickButton(gamePad, BTN_Y); // Y
        final Button btnHangRet = new JoystickButton(gamePad, BTN_B); // B
        final Button btnArmDown = new JoystickButton(gamePad, BTN_A); // A
        final Button btnArmUp = new JoystickButton(gamePad, BTN_X); // X

        // Joystick + Gamepad
        btnOut.whenPressed(new GoOut(m_intake, () -> (!btnOut.get())));
        btnIn.whenPressed(new TakeIn(m_intake, () -> (!btnIn.get())));
        btnHangEx.whenPressed(new HangEx(m_hanger, () -> (!btnHangEx.get())));
        btnHangRet.whenPressed(new HangRet(m_hanger, () -> (!btnHangRet.get())));
        btnArmDown.whenPressed(new ArmDown(m_arm, () -> (!btnArmDown.get())));
        btnArmUp.whenPressed(new ArmUp(m_arm, () -> (!btnArmUp.get())));

        // Joystick Solo Control
        // final Button btnOut = new JoystickButton(logi, 1);
        // final Button btnIn = new JoystickButton(logi, 2);

        // final Button btnHangEx = new JoystickButton(logi, 3);
        // final Button btnHangRet = new JoystickButton(logi, 5);

        // final Button btnArmDown = new JoystickButton(logi, 4);
        // final Button btnArmUp = new JoystickButton(logi, 6);

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return m_autoCommand;
    }
}
