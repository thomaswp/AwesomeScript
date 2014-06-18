
package com.awesomescript;


public class FN_CreepLevelling
    extends Script
{


    public void onTick() {
        if (once()) {
            if (checkGameTime(360.0D, Valuecompare.Greater)) {
                enableUpgrade(Yesno.Yes, "CreepLevel1");
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
            if (checkGameTime(720.0D, Valuecompare.Greater)) {
                enableUpgrade(Yesno.Yes, "CreepLevel2");
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
            if (checkGameTime(1080.0D, Valuecompare.Greater)) {
                enableUpgrade(Yesno.Yes, "CreepLevel3");
                adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
            }
        }
    }

}
