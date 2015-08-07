
package com.awesomescript;


public class VeankoInitialization_HB
    extends Script
{


    public void onTick() {
        if (getBoolEquals("VeankoInit", Yesno.Yes)) {
            if (isInNamedArea("StartArea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                if (getBoolEquals("StartHealthSet", Yesno.No)) {
                    adjustCharacterValue(CharactervaluesAdjustable.HealthPercentage, 100.0D, Valueadjust.Set);
                    setBool("StartHealthSet", Flagtoggle.Yes);
                }
            }
        }
        if (getBoolEquals("VeankoInit", Yesno.No)) {
            if (directionToEnemyBase(Forwardbackward.FORWARD)) {
                adjustCounter("TeamNo", "0", Valueadjust.Set);
            } else {
                adjustCounter("TeamNo", "1", Valueadjust.Set);
            }
            // bot cheats
            if (checkCharacterValue(CharactervaluesCheckable.AISkill, 0.5D, Valuecompare.Greater, Targetself.Self)) {
                enableUpgrade(Yesno.Yes, "Coinregen1");
            }
            setBool("VeankoInit", Flagtoggle.Yes);
            adjustCounter("EnemiesChecked", "0", Valueadjust.Set);
            adjustCounter("KnownEnemies", "0", Valueadjust.Set);
            enableUpgrade(Yesno.Yes, "Bot");
            if (checkCharacterValue(CharactervaluesCheckable.Gold, 0.0D, Valuecompare.Equal, Targetself.Self)) {
                adjustCharacterValue(CharactervaluesAdjustable.Health, 100.0D, Valueadjust.Set);
            }
            if (isInNamedArea("Startarea", Ownenemy.OWN_TEAM, Targetself.Self)) {
                // returnToUpgrade (10)
                adjustCounter("setState", "10", Valueadjust.Set);
            } else {
                // advanceToFrontline(3)
                adjustCounter("setState", "3", Valueadjust.Set);
            }
            // set towers alive
            if (getBoolEquals("false", Yesno.No)) {
                if (isInNamedArea("DEURBLAUW3", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("DEURROOD3", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("enemyTower1Lane1", Flagtoggle.No);
                } else {
                    setBool("enemyTower1Lane1", Flagtoggle.Yes);
                }
                if (isInNamedArea("DEURBLAUW2", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("DEURROOD2", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("enemyTower2Lane1", Flagtoggle.No);
                } else {
                    setBool("enemyTower2Lane1", Flagtoggle.Yes);
                }
                if (isInNamedArea("DEURBLAUW1", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("DEURROOD1", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("enemyTower2Lane2", Flagtoggle.No);
                } else {
                    setBool("enemyTower2Lane2", Flagtoggle.Yes);
                }
                if (isInNamedArea("DEURBLAUW4", Ownenemy.OWN_TEAM, Targetself.Self)||isInNamedArea("DEURROOD4", Ownenemy.OWN_TEAM, Targetself.Self)) {
                    setBool("enemyTower1Lane2", Flagtoggle.No);
                } else {
                    setBool("enemyTower1Lane2", Flagtoggle.Yes);
                }
                setBool("enemyTower3", Flagtoggle.Yes);
            }
            setBool("SupportMode", Flagtoggle.No);
            if ((getBoolEquals("Jetter", Yesno.Yes)||getBoolEquals("Summoner", Yesno.Yes))||random("2")) {
                setBool("SupportMode", Flagtoggle.Yes);
                adjustCounter("SupportBuild", "4", Valueadjust.Set);
            } else {
                adjustCounter("SupportBuild", "0", Valueadjust.Set);
            }
            if (getBoolEquals("SupportMode", Yesno.No)) {
                if (random("1")) {
                    setBool("PushMode", Flagtoggle.Yes);
                }
            }
        }
    }

}
