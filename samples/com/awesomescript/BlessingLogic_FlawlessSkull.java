
package com.awesomescript;

import java.util.EnumSet;

public class BlessingLogic_FlawlessSkull
    extends Script
{


    public void onTick() {
        // Is Monarch Ready?
        if (isSkillOnButtonAvailable(Buttons.FACE_TOP)) {
            // Enemies In Area?
            if (isInArea(Yesno.Yes, EnumSet.of(CollisonGroups.PLAYERS), Yesno.No, Yesno.Yes, EnumSet.of(Teams.ENEMY_TEAM), "", 0.0D, 0.0D, 1.0D, 1.0D, Yesno.Yes, Yesno.No)) {
                setBool("UseBlessing", Flagtoggle.Yes);
            }
            if (hasTarget(Yesno.Yes)) {
                if (checkClass(Targetself.Target, "CreepMawTurret")) {
                    setBool("UseBlessing", Flagtoggle.Yes);
                }
            }
            if ((isUpgradeEnabled(Yesno.Yes, "ButterflyBuffHeal1")||isUpgradeEnabled(Yesno.Yes, "ButterflyBuffHeal2"))||isUpgradeEnabled(Yesno.Yes, "ButterflyBuffHeal3")) {
                if (checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.LessOrEqual, Targetself.Self)) {
                    setBool("UseBlessing", Flagtoggle.Yes);
                } else {
                    // Friends with low health?
                    if (isCharacterInArea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.OWN_TEAM), "", Yesno.No, Yesno.No, Yesno.Yes, CharactervaluesCheckable.HealthMinusDotPercentage, Valuecompare.LessOrEqual, 50.0D, "", 0.0D, 0.0D, 0.65D, 0.65D, Yesno.No)) {
                        setBool("UseBlessing", Flagtoggle.Yes);
                    }
                }
            }
        } else {
            // Cooldown = No Monarch
            setBool("UseBlessing", Flagtoggle.No);
        }
    }

}
