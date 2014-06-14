
package com.awesomescript;

import java.util.EnumSet;
import com.awesomescript.importer.ScriptBase;

public abstract class Script
    extends ScriptBase
{


    protected void resetmissionvariables() {
        throw new UnsupportedOperationException();
    }

    protected void setbool(String id, Script.Flagtoggle value) {
        throw new UnsupportedOperationException();
    }

    protected void adjustmissioncounter(String id, String value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void wait(float time) {
        throw new UnsupportedOperationException();
    }

    protected void selectpingwaypoint(Script.Ping ping) {
        throw new UnsupportedOperationException();
    }

    protected void pressstick(Script.Directions direction, float durationInSeconds) {
        throw new UnsupportedOperationException();
    }

    protected void removetarget() {
        throw new UnsupportedOperationException();
    }

    protected void enableupgrade(Script.Yesno condition, String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected void adjustcharactervalue(Script.CharactervaluesAdjustable property, float value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void adjustcounter(String id, String value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void selecttargetwaypoint() {
        throw new UnsupportedOperationException();
    }

    protected void randomizemissioncounter(String id, String low, String high) {
        throw new UnsupportedOperationException();
    }

    protected void emittargetinarea(EnumSet<Script.TargetReceiveGroups> receiveGroups, EnumSet<Script.Teams> teams, float xoffset, float yoffset, float width, float height) {
        throw new UnsupportedOperationException();
    }

    protected void selectdestwaypoint(String name, Script.Ownenemy team) {
        throw new UnsupportedOperationException();
    }

    protected void writetotextbox(String localizationid, float transparency, String texture, float duration) {
        throw new UnsupportedOperationException();
    }

    protected void aimstickattarget(float durationSeconds, Script.Yesno onlyAimWhenNeeded) {
        throw new UnsupportedOperationException();
    }

    protected void buyupgrade(String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected void missiongetscore(String clazz, Script.Teamswithnumbers team, Script.Scoretype type, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected void completemission(Script.MissionCompletionDelay delay) {
        throw new UnsupportedOperationException();
    }

    protected void log(String text, String counter, String bool) {
        throw new UnsupportedOperationException();
    }

    protected void playsound(String soundgroup) {
        throw new UnsupportedOperationException();
    }

    protected void emitmessageinarea(String id, EnumSet<Script.TargetReceiveGroups> receiveGroups, EnumSet<Script.Teamswithtarget> teams, float xoffset, float yoffset, float width, float height, Script.Yesno ignoreInvisibility, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected void pausegame(Script.Yesno endonbuttonpress, Script.Yesno endonanimationfinished, Script.Yesno endontimeelapsed, float endontimeelapsedtime, String animationname, Script.Yesno loopanimation, float animationxposition, float animationyposition, float animationsize, Script.Yesno animationnamebasedoninputhardware, Script.Yesno animationtextsbasedoninputhardware) {
        throw new UnsupportedOperationException();
    }

    protected void setmissionbool(String id, Script.Flagtoggle value) {
        throw new UnsupportedOperationException();
    }

    protected void selecttarget(EnumSet<Script.TargetGroups> groupsToSelect, EnumSet<Script.Teams> teams, String clazz, Script.Yesno removeIfNotFound, float xoffset, float yoffset, float width, float height, Script.Valuecompare2 compareMethod, float healthValue, Script.DistanceCheck distanceCheck, Script.Yesno checkLineOfSight, Script.Yesno ignoreInvisibility) {
        throw new UnsupportedOperationException();
    }

    protected void pressbutton(Script.Buttons button, float durationInSeconds) {
        throw new UnsupportedOperationException();
    }

    protected void receivetarget() {
        throw new UnsupportedOperationException();
    }

    protected void executebehaviourtree(String filename) {
        throw new UnsupportedOperationException();
    }

    protected void playanimation(String animationname, Script.AnimationLocation location, float xposition, float yposition, float scale, float depth, Script.Yesno mirrorx, Script.Teams team) {
        throw new UnsupportedOperationException();
    }

    protected boolean isinnamedarea(String areaName, Script.Ownenemy team, Script.Targetself who) {
        throw new UnsupportedOperationException();
    }

    protected boolean isbuttonpressed(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean ongoldcollected(Script.MissionTarget collector, Script.Teamswithnumbers team, String clazz, Script.GoldPickupType type, Script.Valuecompare compareMethod, String value, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedping(Script.Ping ping) {
        throw new UnsupportedOperationException();
    }

    protected boolean isfromteam(Script.Teamswithnumbers team, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedtarget(EnumSet<Script.TargetGroups> ifOfGroup) {
        throw new UnsupportedOperationException();
    }

    protected boolean getboolequals(String id, Script.Yesno value) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkgametime(float timeInSeconds, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkcharacterflag(Script.Characterflags property, Script.Yesno condition, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean comparemissionbools(String id1, String id2) {
        throw new UnsupportedOperationException();
    }

    protected boolean timer(Script.Timeunits timeunit, float time, Script.Yesno executeFirstTime) {
        throw new UnsupportedOperationException();
    }

    protected boolean ispickupatwaypoint(String name, Script.Ownenemy team) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkcounter(String id, String value, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean onkill(Script.MissionTarget killer, Script.Teamswithnumbers killerTeam, String killerClass, Script.MissionTarget victim, Script.Teamswithnumbers victimTeam, String victimClass, Script.Valuecompare compareMethod, String value, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected boolean comparebools(String id1, String id2) {
        throw new UnsupportedOperationException();
    }

    protected boolean isskillonbuttonavailable(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean onprestige() {
        throw new UnsupportedOperationException();
    }

    protected boolean getmissionboolequals(String id, Script.Yesno value) {
        throw new UnsupportedOperationException();
    }

    protected boolean isnextwaypointposition(Script.Offsetposition position) {
        throw new UnsupportedOperationException();
    }

    protected boolean ongamestarted() {
        throw new UnsupportedOperationException();
    }

    protected boolean random(String amount) {
        throw new UnsupportedOperationException();
    }

    protected boolean timepassed(Script.Timeunits timeunit, float time) {
        throw new UnsupportedOperationException();
    }

    protected boolean doesclassexist(EnumSet<Script.Teams> teams, String clazz) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkmissioncounter(String id, String value, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean isbuttonreleased(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean isoncreepturner(Script.Yesno condition, Script.Forwardbackward direction) {
        throw new UnsupportedOperationException();
    }

    protected boolean isonlinematch() {
        throw new UnsupportedOperationException();
    }

    protected boolean aregoldcoinsinarea(float compareValue, Script.Valuecompare compareMethod, float xoffset, float yoffset, float width, float height, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedmessage(String id) {
        throw new UnsupportedOperationException();
    }

    protected boolean directiontoenemybase(Script.Forwardbackward direction) {
        throw new UnsupportedOperationException();
    }

    protected boolean onwin(Script.Teamswithnumbers team) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkclass(Script.Targetself checkOn, String clazz) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkcharactervalue(Script.CharactervaluesCheckable property, float value, Script.Valuecompare compareMethod, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean isbuttondown(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean isinarea(Script.Yesno condition, EnumSet<Script.CollisonGroups> collisionGroups, Script.Yesno checkGreenObstaclesOnly, EnumSet<Script.Teams> teams, String areaname, float xoffset, float yoffset, float width, float height, Script.Yesno checkLineOfSight, Script.Yesno ignoreInvisibility) {
        throw new UnsupportedOperationException();
    }

    protected abstract void onTick();

    public enum AnimationLocation {

        HUD,
        WORLD,
        START_RELATIVE_TO_CHARACTER,
        FOLLOW_CHARACTER;

    }

    public enum Buttons {

        FACE_BOTTOM,
        FACE_RIGHT,
        FACE_LEFT,
        FACE_TOP,
        SHOULDER_LEFT,
        SHOULDER_RIGHT,
        TRIGGER_LEFT,
        TRIGGER_RIGHT,
        DPAD_LEFT,
        DPAD_RIGHT,
        DPAD_UP,
        DPAD_DOWN,
        BACK;

    }

    public enum Characterflags {

        IsSilenced,
        IsStunned,
        IsBlinded,
        IsSlowed,
        IsUnderAnyEffect,
        IsStealth;

    }

    public enum CharactervaluesAdjustable {

        Health,
        HealthPercentage,
        Gold,
        GoldWithoutXp;

    }

    public enum CharactervaluesCheckable {

        Health,
        HealthPercentage,
        Gold,
        AISkill,
        HealthMinusDot,
        HealthMinusDotPercentage;

    }

    public enum CollisonGroups {

        PLAYERS,
        CREEPS,
        NAMED_AREAS,
        INVINCIBLE_OBSTACLES,
        DESTROYABLE_OBSTACLES,
        PROJECTILES,
        SHOPS,
        JUMPPADS;

    }

    public enum Directions {

        UP,
        DOWN,
        LEFT,
        RIGHT,
        FORWARD,
        BACKWARD;

    }

    public enum DistanceCheck {

        NONE,
        CLOSEST,
        FURTHEST;

    }

    public enum Emitvalues {

        Health,
        Gold;

    }

    public enum Flagtoggle {

        No,
        Yes,
        Toggle;

    }

    public enum Forwardbackward {

        FORWARD,
        BACKWARD;

    }

    public enum Frontback {

        FRONT,
        BACK;

    }

    public enum GoldPickupType {

        ANY,
        PICKUP,
        AI,
        LATEBONUS,
        SHOP,
        DEATH;

    }

    public enum Leftright {

        LEFT,
        RIGHT;

    }

    public enum MissionCompletionDelay {

        INSTANT;

    }

    public enum MissionEvent {

        KILL;

    }

    public enum MissionTarget {

        SELF,
        HERO,
        CREEP,
        TURRET,
        BASE,
        WORM;

    }

    public enum Offsetposition {

        ABOVE,
        BACK,
        FRONT,
        BELOW,
        HORIZONTALEQUAL,
        VERTICALEQUAL;

    }

    public enum Ownenemy {

        OWN_TEAM,
        ENEMY_TEAM;

    }

    public enum Ping {

        ATTACK,
        DEFEND,
        HELP,
        TURRET_UNDER_ATTACK,
        TURRET_ALMOST_DESTROYED,
        BASE_UNDER_ATTACK,
        BASE_ALMOST_DESTROYED;

    }

    public enum Scoretype {

        KILLS,
        DEATHS,
        CREEPKILLS;

    }

    public @interface Sequence {


        boolean blocking();

    }

    public enum TargetGroups {

        PLAYERS,
        CREEPS,
        DESTROYABLE_OBSTACLES;

    }

    public enum TargetReceiveGroups {

        PLAYERS,
        CREEPS;

    }

    public enum Targetself {

        Self,
        Target;

    }

    public enum Targetvalues {

        NotImportant,
        LowestHealth,
        HighestHealth,
        LowestGold,
        HighestGold;

    }

    public enum Teams {

        OWN_TEAM,
        ENEMY_TEAM,
        NEUTRAL_TEAM;

    }

    public enum Teamswithnumbers {

        OWN_TEAM,
        ENEMY_TEAM,
        NEUTRAL_TEAM,
        ZERO_TEAM,
        ONE_TEAM;

    }

    public enum Teamswithtarget {

        OWN_TEAM,
        ENEMY_TEAM,
        NEUTRAL_TEAM,
        TARGET;

    }

    public enum Timeunits {

        Seconds,
        Minutes,
        Milliseconds,
        Hours;

    }

    public enum Valueadjust {

        Set,
        Add,
        Multiply,
        Divide;

    }

    public enum Valuecompare {

        Less,
        LessOrEqual,
        Equal,
        GreaterOrEqual,
        Greater;

    }

    public enum Valuecompare2 {

        Less,
        LessOrEqual,
        Equal,
        GreaterOrEqual,
        Greater,
        Lowest,
        Highest;

    }

    public enum Yesno {

        No,
        Yes;

    }

}
