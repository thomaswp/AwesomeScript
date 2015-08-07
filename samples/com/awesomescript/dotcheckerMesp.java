
package com.awesomescript;


public class dotcheckerMesp
    extends Script
{


    public void onTick() {
        if (receivedMessage("Thisllneverhappen")) {
            // Dot Checker by Mesp
            log("IIIIIII Originally for Hurleybird", "I But you guys can use it too", "IIIIII Just give me credit");
        }
        if (once()) {
            // 0 = no dot 1 = dot
            adjustCounter("dot", "0", Valueadjust.Set);
        }
        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 100.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 100.0D, Valuecompare.Less, Targetself.Target)) {
            adjustCounter("dot", "1", Valueadjust.Set);
        } else {
            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 95.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 95.0D, Valuecompare.Less, Targetself.Target)) {
                adjustCounter("dot", "1", Valueadjust.Set);
            } else {
                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 90.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 90.0D, Valuecompare.Less, Targetself.Target)) {
                    adjustCounter("dot", "1", Valueadjust.Set);
                } else {
                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 85.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 85.0D, Valuecompare.Less, Targetself.Target)) {
                        adjustCounter("dot", "1", Valueadjust.Set);
                    } else {
                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 80.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 80.0D, Valuecompare.Less, Targetself.Target)) {
                            adjustCounter("dot", "1", Valueadjust.Set);
                        } else {
                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 75.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 75.0D, Valuecompare.Less, Targetself.Target)) {
                                adjustCounter("dot", "1", Valueadjust.Set);
                            } else {
                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 70.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 70.0D, Valuecompare.Less, Targetself.Target)) {
                                    adjustCounter("dot", "1", Valueadjust.Set);
                                } else {
                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 65.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 65.0D, Valuecompare.Less, Targetself.Target)) {
                                        adjustCounter("dot", "1", Valueadjust.Set);
                                    } else {
                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 60.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 60.0D, Valuecompare.Less, Targetself.Target)) {
                                            adjustCounter("dot", "1", Valueadjust.Set);
                                        } else {
                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 55.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 55.0D, Valuecompare.Less, Targetself.Target)) {
                                                adjustCounter("dot", "1", Valueadjust.Set);
                                            } else {
                                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 50.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 50.0D, Valuecompare.Less, Targetself.Target)) {
                                                    adjustCounter("dot", "1", Valueadjust.Set);
                                                } else {
                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 45.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 45.0D, Valuecompare.Less, Targetself.Target)) {
                                                        adjustCounter("dot", "1", Valueadjust.Set);
                                                    } else {
                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 40.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 40.0D, Valuecompare.Less, Targetself.Target)) {
                                                            adjustCounter("dot", "1", Valueadjust.Set);
                                                        } else {
                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 35.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 35.0D, Valuecompare.Less, Targetself.Target)) {
                                                                adjustCounter("dot", "1", Valueadjust.Set);
                                                            } else {
                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 30.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 30.0D, Valuecompare.Less, Targetself.Target)) {
                                                                    adjustCounter("dot", "1", Valueadjust.Set);
                                                                } else {
                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 25.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 25.0D, Valuecompare.Less, Targetself.Target)) {
                                                                        adjustCounter("dot", "1", Valueadjust.Set);
                                                                    } else {
                                                                        if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 20.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 20.0D, Valuecompare.Less, Targetself.Target)) {
                                                                            adjustCounter("dot", "1", Valueadjust.Set);
                                                                        } else {
                                                                            if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 15.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 15.0D, Valuecompare.Less, Targetself.Target)) {
                                                                                adjustCounter("dot", "1", Valueadjust.Set);
                                                                            } else {
                                                                                if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 10.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 10.0D, Valuecompare.Less, Targetself.Target)) {
                                                                                    adjustCounter("dot", "1", Valueadjust.Set);
                                                                                } else {
                                                                                    if (checkCharacterValue(CharactervaluesCheckable.HealthPercentage, 5.0D, Valuecompare.GreaterOrEqual, Targetself.Target)&&checkCharacterValue(CharactervaluesCheckable.HealthMinusDotPercentage, 5.0D, Valuecompare.Less, Targetself.Target)) {
                                                                                        adjustCounter("dot", "1", Valueadjust.Set);
                                                                                    } else {
                                                                                        adjustCounter("dot", "0", Valueadjust.Set);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
