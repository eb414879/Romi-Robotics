package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class ArcadeDrive extends CommandBase {
    private RomiDrivetrain driveTrain;
    private Supplier<Double> xaxisSpeed;
    private Supplier<Double> zaxisRotate;
    
    public ArcadeDrive(RomiDrivetrain driveTrain, Supplier<Double> xaxisSpeed, Supplier<Double> zaxisRotate) {
        this.driveTrain = driveTrain;
        this.xaxisSpeed = xaxisSpeed;
        this.zaxisRotate = zaxisRotate;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(this.xaxisSpeed.get(), this.zaxisRotate.get());
    }

}
