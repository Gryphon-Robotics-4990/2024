/* 

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeExtendCommand extends Command{
    private final IntakeSubsystem m_intakeSubsystem;

    public IntakeExtendCommand(IntakeSubsystem intakeSubsystem){
        m_intakeSubsystem = intakeSubsystem;
    }

    @Override
    public void initialize(){
        m_intakeSubsystem.intakePercentOutput(1);
    }

    @Override
    public void end(boolean interrupted){
        m_intakeSubsystem.intakePercentOutput(0);
        m_intakeSubsystem.retractIntake();
    }
}
*/