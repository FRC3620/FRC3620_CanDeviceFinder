/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlFrame;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.SparkMax;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * Add your docs here.
 */
public class ReferencesToHardwareLibraries {
    SparkMax sparkMax;
    TalonFX talonFX;
    TalonSRX talonSRX;
    VictorSPX victorSPX;
    PowerDistributionPanel powerDistributionPanel;

    void neverCallMe() {
        talonFX.setControlFramePeriod(ControlFrame.Control_3_General, 1);
        int a = edu.wpi.first.hal.FRCNetComm.tResourceType.kResourceType_CANTalonSRX; // 52 or 0x34
    }
}
