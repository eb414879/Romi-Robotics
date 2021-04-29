package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

//TurnTime will turn robot for a desired rotational speed and time

public class TurnTime extends CommandBase {
        private double speed;
        private double time;
        private RomiDrivetrain driveTrain;
        private long startTime;   


    public TurnTime(double speed, double time, RomiDrivetrain driveTrain) {
        this.speed = speed;
        this.time = time;
        this.driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        this.startTime = System.currentTimeMillis();
        this.driveTrain.arcadeDrive(0,0);
    }

    @Override
    public void execute() {
        this.driveTrain.arcadeDrive(0, this.speed);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - this.startTime) >= this.time;
    }

    @Override
    public void end(boolean interrupted) {
        this.driveTrain.arcadeDrive(0,0);
    }

}