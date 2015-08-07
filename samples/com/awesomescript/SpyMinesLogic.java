
package com.awesomescript;

import java.util.EnumSet;

public class SpyMinesLogic
    extends Script
{


    public void onTick() {
        if (((checkClass(Targetself.Target, "Dasher")&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "DasherWhirlwindReflect"))&&hasUpgrade("Dasher", Teamswithnumbers.ENEMY_TEAM, "whirlPenalty"))&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
        } else {
            if (hasTarget(Yesno.Yes)) {
                if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 0.55D, 0.55D, Yesno.Yes, Yesno.Yes)) {
                    if (((checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "6", Valuecompare.Equal))||checkCounter("state", "10", Valuecompare.Equal))||checkCounter("state", "11", Valuecompare.Equal)) {
                    } else {
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                    }
                } else {
                    if (checkCounter("state", "1", Valuecompare.Equal)||checkCounter("state", "10", Valuecompare.Equal)) {
                        if (isTargetInArea(Yesno.Yes, 0.0D, 0.0D, 1.05D, 1.05D, Yesno.Yes, Yesno.Yes)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.Greater, Targetself.Self)) {
                            // Don't aim behind me while retreating
                            if (isTargetPosition(Yesno.Yes, Offsetposition.FRONT)) {
                                aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            }
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        }
                    } else {
                        if ((checkCounter("state", "11", Valuecompare.Equal)&&isTurretInArea(EnumSet.of(Teams.OWN_TEAM), Valuecompare.Greater, 0.0D, 0.0D, 0.0D, 0.2D, 0.2D, Yesno.No))&&directionToEnemyBase(Forwardbackward.FORWARD)) {
                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                            // attack
                            pressButton(Buttons.FACE_LEFT, 0.0D);
                        } else {
                            if (checkCounter("state", "2", Valuecompare.Equal)||checkCounter("state", "8", Valuecompare.Equal)) {
                                // attack
                                pressButton(Buttons.FACE_LEFT, 0.0D);
                                if (hasTarget(Yesno.Yes)) {
                                    aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                                }
                            }
                        }
                    }
                }
            } else {
                // Enemy in combat range -> shoot them
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS, CollisonGroups.CREEPS, CollisonGroups.DESTROYABLE_OBSTACLES), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.3D, 0.0D, 0.3D, 0.2D, Yesno.Yes, Yesno.No)) {
                    // attack
                    pressButton(Buttons.FACE_LEFT, 0.0D);
                }
            }
            if (((((((((isInNamedArea("HIDE_AREA_TOP", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("HIDE_AREA_TOP_BELOW", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_BOTTOM_ABOVE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_SIDE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("HIDE_AREA_CENTRE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("JUNGLE", Ownenemy.OWN_TEAM, Targetself.Self))||isInNamedArea("JUNGLE", Ownenemy.ENEMY_TEAM, Targetself.Self))||checkCounter("state", "2", Valuecompare.Equal))||checkCounter("state", "8", Valuecompare.Equal)) {
                // attack
                pressButton(Buttons.FACE_LEFT, 0.0D);
                if (hasTarget(Yesno.Yes)) {
                    aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                }
            } else {
                if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, 0.0D, 0.2D, 0.2D, Yesno.Yes, Yesno.Yes)||isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.JUMPPADS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM, Teams.NEUTRAL_TEAM), "", 0.0D, -0.3D, 0.2D, 0.5D, Yesno.Yes, Yesno.Yes)) {
                    if (isInNamedArea("AREAHOME", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    } else {
                        // attack
                        pressButton(Buttons.FACE_LEFT, 0.0D);
                        if (hasTarget(Yesno.Yes)) {
                            aimStickAtTarget(0.01D, Yesno.No, Yesno.No, 0.0D, 0.0D, 0.0D, 0.0D);
                        }
                    }
                }
            }
        }
    }

}
