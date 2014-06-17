
package com.awesomescript;

import java.util.EnumSet;

public class Vampire
    extends Script
{


    public void onTick() {
        executebehaviourtree("HeroCode");
        executebehaviourtree("StatusEffects");
        if (isupgradeenabled(Yesno.Yes, "Cocoon")) {
            sequence0();
        }
        if (isupgradeenabled(Yesno.Yes, "StealthPowerup")) {
            sequence1();
        }
        if (isinnamedarea("NoFlyZone", Ownenemy.OWN_TEAM, Targetself.Self)) {
            sequence2();
        }
        if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstToggle")) {
            setbool("BloodThirstToggle", Flagtoggle.Toggle);
            if (isupgradeenabled(Yesno.No, "VampireBloodThirstON")) {
                setbool("SetCloudCooldown", Flagtoggle.Yes);
            }
            enableupgrade(Yesno.No, "VampireBloodThirstToggle");
        }
        if (getboolequals("SetCloudCooldown", Yesno.Yes)) {
            sequence3();
        }
        if (getboolequals("BloodThirstToggle", Yesno.No)) {
            enableupgrade(Yesno.No, "VampireBloodThirstON");
        } else {
            enableupgrade(Yesno.Yes, "VampireBloodThirstON");
        }
        // Bloodthirst healthdrain
        if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstON")) {
            if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstAttackspeed")) {
                if (timer(Timeunits.Seconds, 0.2D, Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, -2.0D, Valueadjust.Add);
                    if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage1")) {
                        adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                        if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage2")) {
                            adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage3")) {
                                adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            }
                        }
                    }
                }
            } else {
                if (timer(Timeunits.Seconds, 0.3D, Yesno.No)) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, -2.0D, Valueadjust.Add);
                    if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage1")) {
                        adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                        if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage2")) {
                            adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstDamage3")) {
                                adjustcharactervalue(CharactervaluesAdjustable.Health, -0.5D, Valueadjust.Add);
                            }
                        }
                    }
                }
            }
            if (checkcharacterflag(Characterflags.IsStealth, Yesno.Yes, Targetself.Self)) {
                enableupgrade(Yesno.Yes, "Breakstealth");
            }
            // Bloodthirst speed inc
            if (isupgradeenabled(Yesno.Yes, "VampireBloodThirstSpeed")) {
                enableupgrade(Yesno.Yes, "VampireBloodThirstSpeedON");
            }
        } else {
            enableupgrade(Yesno.No, "VampireBloodThirstSpeedON");
        }
        // Bolas increase dmg based on health
        if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.Less, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "VampireHealth3");
        } else {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 85.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp1")) {
                enableupgrade(Yesno.Yes, "VampireHealth3");
            } else {
                if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 95.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableupgrade(Yesno.Yes, "VampireHealth3");
                } else {
                    enableupgrade(Yesno.No, "VampireHealth3");
                }
            }
        }
        if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.Less, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "VampireHealth2");
        } else {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp1")) {
                enableupgrade(Yesno.Yes, "VampireHealth2");
            } else {
                if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableupgrade(Yesno.Yes, "VampireHealth2");
                } else {
                    enableupgrade(Yesno.No, "VampireHealth2");
                }
            }
        }
        if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 25.0D, Valuecompare.Less, Targetself.Self)) {
            enableupgrade(Yesno.Yes, "VampireHealth1");
        } else {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 35.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp1")) {
                enableupgrade(Yesno.Yes, "VampireHealth1");
            } else {
                if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 45.0D, Valuecompare.Less, Targetself.Self)&&isupgradeenabled(Yesno.Yes, "VampireBolasHp2")) {
                    enableupgrade(Yesno.Yes, "VampireHealth1");
                } else {
                    enableupgrade(Yesno.No, "VampireHealth1");
                }
            }
        }
        // Bite increase max hp
        if (isupgradeenabled(Yesno.Yes, "VampireBiteMaxhp1")) {
            if (getboolequals("VampireExtrahp1done", Yesno.No)) {
                if (onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                    enableupgrade(Yesno.Yes, "VampireExtrahp1");
                    setbool("VampireExtrahp1done", Flagtoggle.Yes);
                }
            }
            if (getboolequals("VampireExtrahp2done", Yesno.No)) {
                if (isupgradeenabled(Yesno.Yes, "VampireBiteMaxhp2")) {
                    if (onkill(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", MissionTarget.HERO, Teamswithnumbers.ENEMY_TEAM, "", Valuecompare.Greater, "0", "")) {
                        enableupgrade(Yesno.Yes, "VampireExtrahp2");
                        setbool("VampireExtrahp2done", Flagtoggle.Yes);
                    }
                }
            }
        }
        // Bite enemy low hp
        if (isupgradeenabled(Yesno.Yes, "VampireBiteNearbyhero1")) {
            if (ischaracterinarea(EnumSet.of(TargetReceiveGroups.PLAYERS), EnumSet.of(Teams.ENEMY_TEAM), "", CharactervaluesCheckable.HealthPercentage, Valuecompare.Less, 40.0D, "1", 0.0D, 0.0D, 1.1D, 1.1D, Yesno.No)) {
                enableupgrade(Yesno.Yes, "VampireEnemynear1");
                if (isupgradeenabled(Yesno.Yes, "VampireBiteNearbyhero2")) {
                    enableupgrade(Yesno.Yes, "VampireEnemynear2");
                }
            } else {
                enableupgrade(Yesno.No, "VampireEnemynear1");
                enableupgrade(Yesno.No, "VampireEnemynear2");
            }
        }
        if (isupgradeenabled(Yesno.Yes, "PassiveBirdCoinHeal")) {
            if (checkcharactervalue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.Less, Targetself.Self)) {
                if (ongoldcollected(MissionTarget.SELF, Teamswithnumbers.OWN_TEAM, "", GoldPickupType.PICKUP, Valuecompare.GreaterOrEqual, "1", "")) {
                    adjustcharactervalue(CharactervaluesAdjustable.Health, 5.0D, Valueadjust.Add);
                    playanimation("health", AnimationLocation.FOLLOW_CHARACTER, 0.0D, 0.0D, 1.0D, 0.0D, Yesno.No, Teams.OWN_TEAM);
                }
            }
        }
        if (checkcharacterflag(Characterflags.IsStealth, Yesno.No, Targetself.Self)) {
            if (isupgradeenabled(Yesno.Yes, "Breakstealth")) {
                enableupgrade(Yesno.No, "Breakstealth");
            }
        }
    }

    @Script.Sequence(blocking = false)
    void sequence0() {
        setbool("BloodThirstToggle", Flagtoggle.No);
        wait(2.2D);
    }

    @Script.Sequence(blocking = false)
    void sequence1() {
        setbool("BloodThirstToggle", Flagtoggle.No);
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence2() {
        setbool("BloodThirstToggle", Flagtoggle.No);
        wait(1.0D);
    }

    @Script.Sequence(blocking = false)
    void sequence3() {
        enableupgrade(Yesno.Yes, "VampireCloudCooldownON");
        wait(1.1D);
        enableupgrade(Yesno.No, "VampireCloudCooldownON");
        setbool("SetCloudCooldown", Flagtoggle.No);
    }

}
