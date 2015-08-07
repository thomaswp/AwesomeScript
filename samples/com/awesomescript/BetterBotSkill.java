
package com.awesomescript;

import java.util.EnumSet;

public class BetterBotSkill
    extends Script
{


    public void onTick() {
        adjustCounter("botSkill", "-1", Valueadjust.Set);
        if (checkCharacterValue(CharactervaluesCheckable.AISkill, -0.1D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Less, Targetself.Self)) {
            adjustCounter("botSkill", "0", Valueadjust.Set);
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.1D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Less, Targetself.Self)) {
                adjustCounter("botSkill", "1", Valueadjust.Set);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.3D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Less, Targetself.Self)) {
                    adjustCounter("botSkill", "2", Valueadjust.Set);
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.7D, Valuecompare.Less, Targetself.Self)) {
                        adjustCounter("botSkill", "3", Valueadjust.Set);
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.7D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 0.9D, Valuecompare.Less, Targetself.Self)) {
                            adjustCounter("botSkill", "4", Valueadjust.Set);
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.9D, Valuecompare.Greater, Targetself.Self)&&checkCharacterValue(CharactervaluesCheckable.AISkill, 1.1D, Valuecompare.Less, Targetself.Self)) {
                                adjustCounter("botSkill", "5", Valueadjust.Set);
                            }
                        }
                    }
                }
            }
        }
        // Blinded?
        if (checkCharacterFlag(Characterflags.IsBlinded, Yesno.Yes, Targetself.Self)) {
            // Lower skill
            if (checkCounter("botSkill", "2", Valuecompare.GreaterOrEqual)) {
                adjustCounter("botSkill", "-2", Valueadjust.Add);
            } else {
                adjustCounter("botSkill", "0", Valueadjust.Set);
            }
            if ((hasTarget(Yesno.Yes)&&isTargetInArea(Yesno.No, 0.0D, 0.0D, 0.6D, 0.6D, Yesno.No, Yesno.No))&&random("10")) {
                // Lose the target
                selectTarget(EnumSet.of(TargetGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", Yesno.No, Yesno.Yes, 0.0D, 0.0D, 0.6D, 0.6D, Valuecompare2 .GreaterOrEqual, 0.0D, DistanceCheck.CLOSEST, Yesno.No, Yesno.No);
            }
        }
    }

}
