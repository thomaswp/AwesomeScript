
package com.awesomescript;

import java.util.EnumSet;

public class AIBotCommando
    extends Script
{


    public void onTick() {
        if (getBoolEquals("init", Yesno.No)) {
            setBool("Commando", Flagtoggle.Yes);
        }
        executeBehaviourTree("Commando");
        executeBehaviourTree("VeankoAI_Ted");
        if (getBoolEquals("nopushfix", Yesno.No)) {
            setBool("nopushfix", Flagtoggle.Yes);
        }
        // am i running away from towers?
        if (checkCounter("state", "6", Valuecompare.Equal)) {
            // well then dont run at them
            removeTarget();
        }
        // am i going to die?
        if (checkCounter("state", "1", Valuecompare.Equal)) {
            // well then dont go kill people
            removeTarget();
        }
        if (once()) {
            sequence0();
        }
        // Stimpack
        if (isUpgradeEnabled(Yesno.Yes, "CommandoStimpack")) {
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.5D, 0.25D, Yesno.No, Yesno.No)) {
                if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                    pressButton(Buttons.FACE_RIGHT, 0.1D);
                }
            }
        }
        // Airstrike
        if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrike")) {
            if (getBoolEquals("CanUseSkills", Yesno.Yes)) {
                // low skill = worse aim
                if (isUpgradeEnabled(Yesno.Yes, "CommandoAirstrikePenetrate1")) {
                    // low skill = less prediction
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.2D, 0.3D, Yesno.No, Yesno.No)) {
                            sequence1();
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.15D, 0.8D, Yesno.No, Yesno.No)) {
                                sequence2();
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.15D, 1.0D, Yesno.No, Yesno.No)) {
                                    sequence3();
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.1D, 2.5D, Yesno.No, Yesno.No)) {
                                        sequence4();
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                        if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.2D, 0.3D, Yesno.No, Yesno.No)) {
                            sequence5();
                        }
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.15D, 0.3D, Yesno.No, Yesno.No)) {
                                sequence6();
                            }
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.23D, 0.0D, 0.15D, 0.3D, Yesno.No, Yesno.No)) {
                                    sequence7();
                                }
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.25D, 0.0D, 0.1D, 0.3D, Yesno.No, Yesno.No)) {
                                        sequence8();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (hasTarget(Yesno.Yes)) {
            // not retreating from towers
            if (checkCounter("state", "6", Valuecompare.Equal)) {
            } else {
                if (isFromTeam(Teamswithnumbers.OWN_TEAM, Targetself.Target)) {
                } else {
                    if (getBoolEquals("noammo", Yesno.No)) {
                        if (isUpgradeEnabled(Yesno.No, "CommandoSwitchStance")) {
                        } else {
                            pressButton(Buttons.FACE_TOP, 0.1D);
                        }
                    } else {
                        if (isUpgradeEnabled(Yesno.No, "CommandoSwitchStance")) {
                            pressButton(Buttons.FACE_TOP, 0.1D);
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.Yes, Yesno.No)) {
                    } else {
                        if (isUpgradeEnabled(Yesno.Yes, "CommandoShotRange1")) {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.96D, 0.96D, Yesno.No, Yesno.No)) {
                                if (isUpgradeEnabled(Yesno.Yes, "CommandoSwitchStance")) {
                                } else {
                                    pressButton(Buttons.FACE_TOP, 0.1D);
                                }
                            }
                        } else {
                            if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.72D, 0.72D, Yesno.No, Yesno.No)) {
                                if (isUpgradeEnabled(Yesno.Yes, "CommandoSwitchStance")) {
                                } else {
                                    pressButton(Buttons.FACE_TOP, 0.1D);
                                }
                            }
                        }
                    }
                    if (isUpgradeEnabled(Yesno.Yes, "CommandoShotRange1")) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.96D, 0.96D, Yesno.Yes, Yesno.No)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    } else {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.72D, 0.72D, Yesno.Yes, Yesno.No)) {
                            if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                            }
                        }
                    }
                    if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                        if (isSkillOnButtonAvailable(Buttons.FACE_LEFT)) {
                            aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    }
                }
            }
        }
        if (isUpgradeEnabled(Yesno.Yes, "CommandoShotgun0")) {
            sequence9();
        }
        if (checkCounter("state", "3", Valuecompare.Equal)) {
            if (isUpgradeEnabled(Yesno.Yes, "CommandoSwitchStance")) {
            } else {
                pressButton(Buttons.FACE_TOP, 0.1D);
            }
        }
        if (checkCounter("state", "10", Valuecompare.Equal)) {
            if (isUpgradeEnabled(Yesno.Yes, "CommandoSwitchStance")) {
            } else {
                pressButton(Buttons.FACE_TOP, 0.1D);
            }
        }
        if (checkCounter("state", "1", Valuecompare.Equal)) {
            if (isUpgradeEnabled(Yesno.Yes, "CommandoSwitchStance")) {
            } else {
                pressButton(Buttons.FACE_TOP, 0.1D);
            }
        }
        // STATES
        if (getBoolEquals("false", Yesno.No)) {
            // returnToUpgrade (10)
            if (checkCounter("state", "10", Valuecompare.Equal)) {
                setBool("ForceWaypointMovement", Flagtoggle.Yes);
                // Allowed to Upgrade?
                if (getBoolEquals("CanBuyItems", Yesno.Yes)) {
                    // at shop
                    if (isInNamedArea("HEALAREA", Ownenemy.OWN_TEAM, Targetself.Self)) {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "PiggyBank")) {
                                if (canPayUpgrade("PiggyBank")) {
                                    buyUpgrade("PiggyBank");
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrike")) {
                            if (canPayUpgrade("CommandoAirstrike")) {
                                buyUpgrade("CommandoAirstrike");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotDamage1")) {
                            if (canPayUpgrade("CommandoShotDamage1")) {
                                buyUpgrade("CommandoShotDamage1");
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotRange1")) {
                            if (canPayUpgrade("CommandoShotRange1")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    buyUpgrade("CommandoShotRange1");
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotDamage2")) {
                            if (canPayUpgrade("CommandoShotDamage2")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    buyUpgrade("CommandoShotDamage2");
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "addHealth1")) {
                                if (canPayUpgrade("addHealth1")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        buyUpgrade("addHealth1");
                                    }
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "addHealth2")) {
                                if (canPayUpgrade("addHealth2")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        buyUpgrade("addHealth2");
                                    }
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "CommandoSPEED")) {
                                if (canPayUpgrade("CommandoSPEED")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        buyUpgrade("CommandoSPEED");
                                    }
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            // Counter Ayla with Knockback
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Vampire")) {
                                if (isUpgradeEnabled(Yesno.No, "CommandoShotKnockback1")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        if (canPayUpgrade("CommandoShotKnockback1")) {
                                            buyUpgrade("CommandoShotKnockback1");
                                        }
                                    }
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Dasher")||doesClassExist(EnumSet.of(Teams.ENEMY_TEAM), "Hunter")) {
                                if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeStun1")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        if (canPayUpgrade("CommandoAirstrikeStun1")) {
                                            buyUpgrade("CommandoAirstrikeStun1");
                                        }
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpack")) {
                            if (canPayUpgrade("CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    buyUpgrade("CommandoStimpack");
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikePenetrate1")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoAirstrikePenetrate1")) {
                                        buyUpgrade("CommandoAirstrikePenetrate1");
                                    }
                                }
                            }
                        }
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                            if (isUpgradeEnabled(Yesno.No, "addHealth3")) {
                                if (canPayUpgrade("addHealth3")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        buyUpgrade("addHealth3");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotDamage3")) {
                            if (canPayUpgrade("CommandoShotDamage3")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage2")) {
                                    buyUpgrade("CommandoShotDamage3");
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpackAttackspeed1")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoStimpackAttackspeed1")) {
                                        buyUpgrade("CommandoStimpackAttackspeed1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotKnockback1")) {
                            if (isUpgradeEnabled(Yesno.No, "CommandoShotBullet1")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoShotBullet1")) {
                                        buyUpgrade("CommandoShotBullet1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpackAttackspeed2")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoStimpackAttackspeed2")) {
                                        buyUpgrade("CommandoStimpackAttackspeed2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoShotBullet2")) {
                            if (canPayUpgrade("CommandoShotBullet2")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotBullet1")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        buyUpgrade("CommandoShotBullet2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpackMovement1")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoStimpackMovement1")) {
                                        buyUpgrade("CommandoStimpackMovement1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeStun1")) {
                            if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeHealthpack1")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                        if (canPayUpgrade("CommandoAirstrikeHealthpack1")) {
                                            buyUpgrade("CommandoAirstrikeHealthpack1");
                                        }
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeHealthpack2")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandAirstrikeHealthpack1")) {
                                        if (canPayUpgrade("CommandoAirstrikeHealthpack2")) {
                                            buyUpgrade("CommandoAirstrikeHealthpack2");
                                        }
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeDamage1")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoAirstrikeDamage1")) {
                                        buyUpgrade("CommandoAirstrikeDamage1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpackDuration1")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoStimpackDuration1")) {
                                        buyUpgrade("CommandoStimpackDuration1");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoStimpackDuration2")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoStimpack")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoStimpackDuration2")) {
                                        buyUpgrade("CommandoStimpackDuration2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeDamage2")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoAirstrikeDamage2")) {
                                        buyUpgrade("CommandoAirstrikeDamage2");
                                    }
                                }
                            }
                        }
                        if (isUpgradeEnabled(Yesno.No, "CommandoAirstrikeDamage3")) {
                            if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoAirstrike")) {
                                if (hasUpgrade("Commando", Teamswithnumbers.OWN_TEAM, "CommandoShotDamage1")) {
                                    if (canPayUpgrade("CommandoAirstrikeDamage3")) {
                                        buyUpgrade("CommandoAirstrikeDamage3");
                                    }
                                }
                            }
                        }
                        // all better now
                        if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Equal, Targetself.Self)) {
                            if (timer(Timeunits.Seconds, 1.0D, Yesno.No)) {
                                if (random("2")) {
                                    adjustCounter("lane", "1", Valueadjust.Set);
                                } else {
                                    adjustCounter("lane", "2", Valueadjust.Set);
                                }
                            }
                            sequence10();
                        }
                    }
                }
            }
        }
        // Got Shotgun?
        if (isUpgradeEnabled(Yesno.No, "CommandoSwitchStance")) {
            // Shoot in this range
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.1D, 0.0D, 0.23D, 0.16D, Yesno.No, Yesno.No)) {
                // Dumber = Slower
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                    sequence11();
                } else {
                    // Dumber = Slower
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                        sequence12();
                    } else {
                        // Dumber = Slower
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                            sequence13();
                        } else {
                            // Dumber = Slower
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_LEFT, 0.1D);
                            }
                        }
                    }
                }
            }
        } else {
            // Range on Machinegun?
            if (isUpgradeEnabled(Yesno.No, "CommandoShotRange1")) {
                // Shoot in this range
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.12D, 0.0D, 0.34D, 0.23D, Yesno.No, Yesno.No)) {
                    // Dumber = Slower
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                        aimStickAtTarget(0.34D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        pressButton(Buttons.FACE_LEFT, 0.34D);
                    } else {
                        // Dumber = Slower
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                            aimStickAtTarget(0.26D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            pressButton(Buttons.FACE_LEFT, 0.26D);
                        } else {
                            // Dumber = Slower
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                aimStickAtTarget(0.18D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_LEFT, 0.18D);
                            } else {
                                // Dumber = Slower
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    pressButton(Buttons.FACE_LEFT, 0.1D);
                                }
                            }
                        }
                    }
                }
            } else {
                // Shoot in this range
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.15D, 0.0D, 0.45D, 0.25D, Yesno.No, Yesno.No)) {
                    // Dumber = Slower
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
                        aimStickAtTarget(0.34D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        pressButton(Buttons.FACE_LEFT, 0.34D);
                    } else {
                        // Dumber = Slower
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                            aimStickAtTarget(0.26D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            pressButton(Buttons.FACE_LEFT, 0.26D);
                        } else {
                            // Dumber = Slower
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                                aimStickAtTarget(0.18D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                pressButton(Buttons.FACE_LEFT, 0.18D);
                            } else {
                                // Dumber = Slower
                                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.GreaterOrEqual, Targetself.Self)) {
                                    aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                    pressButton(Buttons.FACE_LEFT, 0.1D);
                                }
                            }
                        }
                    }
                }
            }
        }
        // Move Away From Target
        if (getBoolEquals("MoveAwayFromTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (directionToEnemyBase(Forwardbackward.BACKWARD)||isInNamedArea("AREANEUTRALS", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)||timer(Timeunits.Seconds, 3.0D, Yesno.No)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                }
                setBool("GoForward", Flagtoggle.Yes);
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.Yes)||isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    setBool("jump", Flagtoggle.Yes);
                }
            } else {
                setBool("GoBack", Flagtoggle.Yes);
            }
            setBool("MoveAwayFromTarget", Flagtoggle.No);
        }
        // Move Towards Target
        if (getBoolEquals("MoveTowardsTarget", Yesno.Yes)) {
            setBool("ForceWaypointMovement", Flagtoggle.No);
            if (isTargetPosition(Yesno.Yes, Offsetposition.BACK)) {
                setBool("GoBack", Flagtoggle.Yes);
            } else {
                if (isTargetPosition(Yesno.Yes, Offsetposition.BELOW)) {
                    // greens
                    if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES), Yesno.Yes, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.07D, 0.01D, 0.06D, Yesno.Yes, Yesno.No)) {
                        setBool("DownJump", Flagtoggle.Yes);
                    }
                }
                if (isTargetPosition(Yesno.Yes, Offsetposition.VERTICALEQUAL)) {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.ABOVE)) {
                        setBool("jump", Flagtoggle.Yes);
                    }
                } else {
                    if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                        setBool("GoForward", Flagtoggle.Yes);
                        if ((isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.04D, 0.0D, 0.08D, 0.05D, Yesno.No, Yesno.No)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.16D, 0.02D, Yesno.No, Yesno.No))||isNextWaypointPosition(Offsetposition.ABOVE)) {
                            setBool("jump", Flagtoggle.Yes);
                        }
                    }
                }
            }
            setBool("MoveTowardsTarget", Flagtoggle.No);
        }
        // Handle Movement
        if (getBoolEquals("CantMove", Yesno.No)) {
            setBool("HasMoved", Flagtoggle.No);
            if (getBoolEquals("GoBack", Yesno.Yes)) {
                setBool("GoBack", Flagtoggle.No);
                if ((getBoolEquals("WaypointMovement", Yesno.No)||isOnGround(Yesno.Yes, Targetself.Self))||timer(Timeunits.Seconds, 0.5D, Yesno.No)) {
                    pressStick(Directions.BACKWARD, 0.1D);
                    setBool("HasMoved", Flagtoggle.Yes);
                }
            } else {
                if (getBoolEquals("GoForward", Yesno.Yes)) {
                    pressStick(Directions.FORWARD, 0.1D);
                    setBool("HasMoved", Flagtoggle.Yes);
                    setBool("GoForward", Flagtoggle.No);
                } else {
                    // at regen area
                    if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        if (checkCounter("state", "0.3", Valuecompare.LessOrEqual)||checkCounter("state", "10", Valuecompare.Equal)) {
                            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                                pressStick(Directions.BACKWARD, 0.1D);
                            } else {
                                // check enemies
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.3D, 0.16D, 0.02D, Yesno.No, Yesno.No)) {
                                    if (random("3")) {
                                        setBool("DownJump", Flagtoggle.Yes);
                                    } else {
                                        setBool("jump", Flagtoggle.Yes);
                                    }
                                }
                                // check walls
                                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.INVINCIBLE_OBSTACLES, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.OWN_TEAM, Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.5D, 0.5D, 0.5D, 0.5D, Yesno.No, Yesno.No)) {
                                    setBool("jump", Flagtoggle.Yes);
                                }
                            }
                        }
                    }
                }
            }
            if (getBoolEquals("GoDown", Yesno.Yes)) {
                pressStick(Directions.DOWN, 0.1D);
                setBool("GoDown", Flagtoggle.No);
            } else {
                if (getBoolEquals("GoUp", Yesno.Yes)) {
                    pressStick(Directions.UP, 0.1D);
                    setBool("GoUp", Flagtoggle.No);
                }
            }
        }
        // JUMPIN
        if (getBoolEquals("DownJump", Yesno.No)) {
            if (isInNamedArea("NODOWNJUMP", Ownenemy.OWN_TEAM, Targetself.Self)) {
            } else {
                if (getBoolEquals("jump", Yesno.Yes)) {
                    setBool("jump", Flagtoggle.No);
                    if (timer(Timeunits.Seconds, 0.4D, Yesno.No)) {
                    } else {
                        pressButton(Buttons.FACE_BOTTOM, 0.1D);
                    }
                }
            }
        } else {
            setBool("DownJump", Flagtoggle.No);
            // downjump
            pressButton(Buttons.SHOULDER_LEFT, 0.1D);
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        wait(1.0D);
        pressButton(Buttons.FACE_TOP, 0.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        aimStickAtTarget(0.34D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.34D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        aimStickAtTarget(0.26D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.26D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        aimStickAtTarget(0.18D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.18D);
    }

    @Script.Sequence(blocking = false)
    void sequence4() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence5() {
        aimStickAtTarget(0.34D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.34D);
    }

    @Script.Sequence(blocking = false)
    void sequence6() {
        aimStickAtTarget(0.26D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.26D);
    }

    @Script.Sequence(blocking = false)
    void sequence7() {
        aimStickAtTarget(0.18D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.18D);
    }

    @Script.Sequence(blocking = false)
    void sequence8() {
        aimStickAtTarget(0.1D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_RIGHT, 0.1D);
    }

    @Script.Sequence(blocking = false)
    void sequence9() {
        setBool("noammo", Flagtoggle.Yes);
        pressButton(Buttons.FACE_TOP, 0.1D);
        wait(4.5D);
        setBool("noammo", Flagtoggle.No);
    }

    @Script.Sequence(blocking = false)
    void sequence10() {
        wait(1.0D);
        // advanceToFrontline (3)
        adjustCounter("setState", "3", Valueadjust.Set);
    }

    @Script.Sequence(blocking = false)
    void sequence11() {
        aimStickAtTarget(0.34D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_LEFT, 0.34D);
    }

    @Script.Sequence(blocking = false)
    void sequence12() {
        aimStickAtTarget(0.26D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_LEFT, 0.26D);
    }

    @Script.Sequence(blocking = false)
    void sequence13() {
        aimStickAtTarget(0.18D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
        pressButton(Buttons.FACE_LEFT, 0.18D);
    }

}
