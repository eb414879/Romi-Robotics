package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveDistance extends CommandBase {
    private double speed;
    private double distanceInch;
    private RomiDrivetrain driveTrain;

    public DriveDistance(double speed, double distanceInch, RomiDrivetrain driveTrain) {
        this.speed = speed;
        this.distanceInch = distanceInch;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        this.driveTrain.arcadeDrive(0, 0);
        this.driveTrain.resetEncoders();
    }

    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(this.speed, 0);
    }

    @Override
    public boolean isFinished() {
        return(this.driveTrain.getLeftDistanceInch() + 
            this.driveTrain.getRightDistanceInch())/2 >= this.distanceInch;
    }

    @Override
    public void end(boolean interrupted) {
        this.driveTrain.arcadeDrive(0, 0);
    }
}