package frc.robot.commands;

import frc.robot.Constants.*;
import frc.robot.subsystems.SwerveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

public class DriveSimulationCommand extends Command{
    private final SwerveSubsystem m_drivebase;
    private DoubleSupplier m_translationX, m_translationY, m_rotation;

    public DriveSimulationCommand(SwerveSubsystem drivebase) {
        m_drivebase = drivebase;
        addRequirements(drivebase);
    }

    public void setSuppliers(DoubleSupplier translationX, DoubleSupplier translationY, DoubleSupplier rotation) {
        m_translationX = translationX;
        m_translationY = translationY;
        m_rotation = rotation;
    }

    @Override
    public void execute() {
        // Make the robot move
        m_drivebase.driveFieldOriented(m_drivebase.getSwerveController().getTargetSpeeds(m_translationX.getAsDouble() * DriveSettings.ARCADE_SPEED_X_MULTIPLIER,
                                                                                         m_translationY.getAsDouble() * DriveSettings.ARCADE_SPEED_Y_MULTIPLIER,
                                                                                         m_rotation.getAsDouble() * Math.PI * DriveSettings.ARCADE_ROTATION_MULTIPLIER,
                                                                                         m_drivebase.getSwerveDrive().getOdometryHeading().getRadians(),
                                                                                         m_drivebase.getSwerveDrive().getMaximumVelocity()));
    }
}
