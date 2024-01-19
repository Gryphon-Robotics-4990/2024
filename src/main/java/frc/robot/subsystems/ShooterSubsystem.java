import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.ControlType; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotionControl;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

//Note - 1 motor for receiving from the indexer, two motors for shooting the thing 

public class ShooterSubsystem extends SubsystemBase {
    private CANSparkMax shooter1, shooter2, shooter3;
    private CANSparkMaxPIDController m_pidController; 

    
    public ShooterSubsystem() {
        //Need constants for all of these 
        shooter1 = new CANSparkMax(Ports.CAN_SHOOTER_LEFT_SPARKMAX, MotorType.kBrushless);
        shooter2 = new CANSparkMax(Ports.CAN_SHOOTER_LEFT_SPARKMAX, MotorType.kBrushless);
        shooter3 = new CANSparkMax(Ports.CAN_SHOOTER_LEFT_SPARKMAX, MotorType.kBrushless);

        //Shooting neos 
        m_pidController1 = shooter1.getPIDController();
        m_encoder1 = shooter1.getEncoder();

        //Getting PID and encoder for the other neo 
        m_pidController3 = shooter3.getPIDController();
        m_encoder3 = shooter3.getEncoder();

        //Closed and Open Loop ramp rate setting 
        shooter1.setClosedLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);
        shooter2.setClosedLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);
        shooter3.setClosedLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);

        shooter1.setOpenLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);
        shooter2.setOpenLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);
        shooter3.setOpenLoopRampRate(MotionControl.CLOSED_LOOP_RAMP_RATE);

        configureMotors();
    }
    
    private void configureMotors() {
        shooter1.restoreFactoryDefaults; 
        shooter2.restoreFactoryDefaults; 
        shooter3.restoreFactoryDefaults; 
        //Note - shooter3 is the one that intakes from the indexer 

        m_pidController = shooter1.getPIDController();

        m_pidController.setP(MotionControl.Arm_PID.kP);
        m_pidController.setP(MotionControl.Arm_PID.kI);
        m_pidController.setP(MotionControl.Arm_PID.kD);

        shooter2.follow(shooter1, invert:true);

        //Fix - get stallLimits and freeLimits 
        shooter1.setSmartCurrentLimit(stallLimit: , freeLimit: );
        shooter2.setSmartCurrentLimit(stallLimit: , freeLimit: );
        shooter3.setSmartCurrentLimit(stallLimit: , freeLimit: );
    }
}