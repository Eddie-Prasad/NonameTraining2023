// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawPneumaticSubsystem;

public class ClawPneumaticsCommand extends CommandBase {
  /** Creates a new ClawPneumaticsCommand. */
  ClawPneumaticSubsystem clawPneuamticSubsystem;
  Boolean initialClawValue;
  public ClawPneumaticsCommand(ClawPneumaticSubsystem clawPneumaticSubsystem) {
    this.clawPneuamticSubsystem = clawPneumaticSubsystem;
    addRequirements(this.clawPneuamticSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialClawValue = clawPneuamticSubsystem.getClawPosition();
    if (clawPneuamticSubsystem.getClawPosition()){
      clawPneuamticSubsystem.closeClaw();
      System.out.println("closeClaw");
    } else {
      clawPneuamticSubsystem.openClaw();
      System.out.println("openClaw");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Command ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(initialClawValue != clawPneuamticSubsystem.getClawPosition()){
      return true;
    }
    return false;
  }
}
