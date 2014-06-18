
package com.awesomescript;

import java.util.EnumSet;

public class Shaman
    extends Script
{


    public void onTick() {
        executeBehaviourTree("HeroCode");
        executeBehaviourTree("StatusEffects");
        if ((isUpgradeEnabled(Yesno.Yes, "ShamanSpiritDuration1")&&isUpgradeEnabled(Yesno.Yes, "ShamanSpiritOn"))&&checkCharacterFlag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
            enableUpgrade(Yesno.Yes, "ShamanNoCollisionOn");
        } else {
            enableUpgrade(Yesno.No, "ShamanNoCollisionOn");
        }
        if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepShamanWall", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)&&isUpgradeEnabled(Yesno.Yes, "ShamanWallBuff2")) {
            enableUpgrade(Yesno.Yes, "ShamanWallBuff2On");
            enableUpgrade(Yesno.Yes, "ShamanWallBuff1On");
        } else {
            if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.CREEPS), EnumSet.of(Teams.OWN_TEAM), "CreepShamanWall", CharactervaluesCheckable.Health, Valuecompare.GreaterOrEqual, 0.0D, "", 0.0D, 0.0D, 0.4D, 0.4D, Yesno.No)&&isUpgradeEnabled(Yesno.Yes, "ShamanWallBuff1")) {
                enableUpgrade(Yesno.Yes, "ShamanWallBuff1On");
            } else {
                enableUpgrade(Yesno.No, "ShamanWallBuff2On");
                enableUpgrade(Yesno.No, "ShamanWallBuff1On");
            }
        }
    }

}
