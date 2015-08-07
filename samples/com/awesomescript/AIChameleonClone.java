
package com.awesomescript;

import java.util.EnumSet;

public class AIChameleonClone
    extends Script
{


    public void onTick() {
        executeBehaviourTree("StatusEffects");
        if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthDuration")) {
            if (timePassed(Timeunits.Seconds, 26.0D)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
            }
        } else {
            if (timePassed(Timeunits.Seconds, 18.0D)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 0.0D, Valueadjust.Set);
            }
        }
        if (getBoolEquals("Init", Yesno.No)) {
            setBool("Init", Flagtoggle.Yes);
            if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneHealth")) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 800.0D, Valueadjust.Set);
            } else {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 400.0D, Valueadjust.Set);
            }
        }
        // Checken om aan te vallen
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.06D, 0.0D, 0.12D, 0.2D, Yesno.No, Yesno.No)) {
            pressButton(Buttons.FACE_LEFT, 0.0D);
        }
        // Checken om om te draaien
        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.06D, 0.0D, 0.12D, 0.2D, Yesno.No, Yesno.No)) {
            setBool("turn", Flagtoggle.Yes);
        }
        if (isUpgradeEnabled(Yesno.Yes, "ChameleonStealthCloneAttack")) {
            // Checken voor targets
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.03D, 0.8D, 0.2D, Yesno.No, Yesno.No)) {
                if (getBoolEquals("wait", Yesno.No)) {
                    // Checken voor enemies achter
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", -0.2D, -0.03D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                        setBool("turn", Flagtoggle.Yes);
                    }
                    // Checken voor enemies voor
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.2D, -0.03D, 0.4D, 0.2D, Yesno.No, Yesno.No)) {
                        pressStick(Directions.FORWARD, 0.1D);
                    }
                }
            } else {
                if (directionToEnemyBase(Forwardbackward.BACKWARD)) {
                    setBool("turn", Flagtoggle.Yes);
                } else {
                    pressStick(Directions.FORWARD, 0.1D);
                    // jump sometimes
                    if (timer(Timeunits.Seconds, 2.0D, Yesno.No)) {
                        if (random("3")) {
                            pressButton(Buttons.FACE_BOTTOM, 0.1D);
                        }
                    }
                }
            }
        }
        // Kijk om te springen
        if (isOnGround(Yesno.Yes, Targetself.Self)) {
            // Eigen torens
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM), "", 0.04D, 0.0D, 0.07D, 0.02D, Yesno.No, Yesno.No)) {
                pressButton(Buttons.FACE_BOTTOM, 0.2D);
            }
            // Muren
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.07D, 0.02D, Yesno.No, Yesno.No)) {
                if (((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.06D, 0.07D, 0.02D, Yesno.No, Yesno.No)&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.16D, 0.07D, 0.02D, Yesno.No, Yesno.No))&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.26D, 0.07D, 0.02D, Yesno.No, Yesno.No))&&isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.31D, 0.07D, 0.02D, Yesno.No, Yesno.No)) {
                } else {
                    pressButton(Buttons.FACE_BOTTOM, 0.2D);
                }
            }
        }
        if (getBoolEquals("turn", Yesno.Yes)) {
            wait(0.2D);
            pressStick(Directions.BACKWARD, 0.0D);
            setBool("turn", Flagtoggle.No);
        }
    }

}
