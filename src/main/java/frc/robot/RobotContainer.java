package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;
import edu.wpi.first.wpilibj2.command.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {

    // Subsystems
    private final DriveTrain m_drive = new DriveTrain();
    private final Intake m_intake = new Intake();
    private final Hanger m_hanger = new Hanger();
    private final Spinner m_spinner = new Spinner();
    private final Arm m_arm = new Arm();

    // Commands
    private final ArmDown m_armDown = new ArmDown(m_arm);
    private final ArmUp m_armUp = new ArmUp(m_arm);
    private final AutoCommand m_autoCommand = new AutoCommand(m_drive, m_arm, m_intake);
    private final GoOut m_goOut = new GoOut(m_intake);
    private final HangEx m_hangEx = new HangEx(m_hanger);
    private final HangRet m_hangRet = new HangRet(m_hanger);
    private final SpinAround m_spinAround = new SpinAround(m_spinner);
    private final SpinColor m_spinColor = new SpinColor(m_spinner);
    private final TakeIn m_takeIn = new TakeIn(m_intake);
    private final TeleOpDrive defaultCom = new TeleOpDrive(m_drive);
    private final AutoForward m_autoFor = new AutoForward(m_drive);
    private final AutoOutput m_autoOut = new AutoOutput(m_intake);
    private final AutoSpin m_autoSpin = new AutoSpin(m_drive);

    // Controllers
    private final Joystick logi = new Joystick(0);
    private final Joystick gamePad = new Joystick(1);

    // Buttons
    private final Button btnOut = new JoystickButton(gamePad, 6);
    private final Button btnIn = new JoystickButton(gamePad, 5);

    private final Button btnHangEx = new JoystickButton(gamePad, 4);
    private final Button btnHangRet = new JoystickButton(gamePad, 2);
    private final Button btnArmDown = new JoystickButton(gamePad, 1);
    private final Button btnArmUp = new JoystickButton(gamePad, 3);

    public RobotContainer() {
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

        // joystick solo control
        // private final Button btnOut = new JoystickButton(logi, 1);
        // private final Button btnIn = new JoystickButton(logi, 2);

        // private final Button btnHangEx = new JoystickButton(logi, 3);
        // private final Button btnHangRet = new JoystickButton(logi, 5);

        // private final Button btnArmDown = new JoystickButton(logi, 4);
        // private final Button btnArmUp = new JoystickButton(logi, 6);

        // gamepad two player control

        // swapping between two buttons and triggers

        // triggercontrol with gamepad
        // if (gamePad.getRawAxis(3) == 1) {
        // new GoOut();
        // }
        // if (gamePad.getRawAxis(2) == 1) {
        // new TakeIn();
        // }

        // button control with joystick
        btnIn.whileHeld(m_takeIn);
        btnOut.whileHeld(m_goOut);

        // hopefully constant buttons so no worries
        btnHangEx.whileHeld(m_hangEx);
        btnHangRet.whileHeld(m_hangRet);

        btnArmUp.whileHeld(m_armUp);
        btnArmDown.whileHeld(m_armDown);

    }

    public boolean getInBut() {
        return btnIn.get();
    }

    public boolean getOutBut() {
        return btnOut.get();
    }

    public boolean getHangExBut() {
        return btnHangEx.get();
    }

    public boolean getHangRetBut() {
        return btnHangRet.get();
    }

    public boolean getArmUpBut() {
        return btnArmUp.get();
    }

    public boolean getArmDownBut() {
        return btnArmDown.get();
    }

    public boolean getRTrig() {
        return gamePad.getRawAxis(3) == 1;
    }

    public boolean getLTrig() {
        return gamePad.getRawAxis(2) == 1;
    }

    public Joystick getLogi() {
        return logi;
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

    public Command getDefaultCommand() {
        return defaultCom;
    }

    public DriveTrain getDriveTrain() {
        return m_drive;
    }

    public Arm getArm() {
        return m_arm;
    }

    public Intake getIntake() {
        return m_intake;
    }

    public AutoForward getAutoFor() {
        return m_autoFor;
    }

    public AutoSpin getAutoSpin() {
        return m_autoSpin;
    }

    public AutoOutput getAutoOut() {
        return m_autoOut;
    }
}
