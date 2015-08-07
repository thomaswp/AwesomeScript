
package com.awesomescript;


public class BotSkill
    extends Script
{


    public void onTick() {
        if (once()) {
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
        }
    }

}
