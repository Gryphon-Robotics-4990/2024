package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class Auto21NBlueCommand extends SequentialCommandGroup{
    private final SwerveSubsystem m_drivebase;
    private final ArmSubsystem m_arm;
    private final ShooterSubsystem m_shooter;

    public Auto21NBlueCommand(SwerveSubsystem drivebase, ArmSubsystem arm, ShooterSubsystem shooter) {
        m_drivebase = drivebase;
        m_arm = arm;
        m_shooter = shooter;
        addCommands(new AutoSpeakerCommand(m_shooter, m_arm),
                    new WaitCommand(0),
                    m_drivebase.getAutonomousCommand("21NBlue")
        );
    }
}
