
package com.awesomescript;

import java.util.EnumSet;

public class Shaman
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if ((isupgradeenabled(Yesno.Yes, "ShamanSpiritDuration1")&&isupgradeenabled(Yesno.Yes, "ShamanSpiritOn"))&&checkcharacterflag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "ShamanNoCollisionOn");
        } else {
            enableupgrade(Yesno.No, "ShamanNoCollisionOn");
        }
        if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepShamanWall", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)&&isupgradeenabled(Yesno.Yes, "ShamanWallBuff2")) {
            enableupgrade(Yesno.Yes, "ShamanWallBuff2On");
            enableupgrade(Yesno.Yes, "ShamanWallBuff1On");
        } else {
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepShamanWall", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)&&isupgradeenabled(Yesno.Yes, "ShamanWallBuff1")) {
                enableupgrade(Yesno.Yes, "ShamanWallBuff1On");
            } else {
                enableupgrade(Yesno.No, "ShamanWallBuff2On");
                enableupgrade(Yesno.No, "ShamanWallBuff1On");
            }
        }
    }

}
