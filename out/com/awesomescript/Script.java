
package com.awesomescript;

import java.util.EnumSet;
import com.awesomescript.importer.ScriptBase;

public abstract class Script
    extends ScriptBase
{


    protected void wait(double time) {
        throw new UnsupportedOperationException();
    }

    protected void log(String text, String counter, String bool) {
        throw new UnsupportedOperationException();
    }

    protected void resetMissionVariables() {
        throw new UnsupportedOperationException();
    }

    protected void pressButton(Script.Buttons button, double durationInSeconds) {
        throw new UnsupportedOperationException();
    }

    protected void adjustMissionCounter(String id, String value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void selectDestWaypoint(String name, Script.Ownenemy team) {
        throw new UnsupportedOperationException();
    }

    protected void adjustCounter(String id, String value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void emitTargetInArea(EnumSet<Script.TargetReceiveGroups> receiveGroups, EnumSet<Script.Teams> teams, double xOffset, double yOffset, double width, double height) {
        throw new UnsupportedOperationException();
    }

    protected void adjustCharacterValue(Script.CharactervaluesAdjustable property, double value, Script.Valueadjust adjustMethod) {
        throw new UnsupportedOperationException();
    }

    protected void aimStickAtTarget(double durationSeconds, Script.Yesno onlyAimWhenNeeded) {
        throw new UnsupportedOperationException();
    }

    protected void writeToTextbox(String localizationID, double transparency, String texture, double duration) {
        throw new UnsupportedOperationException();
    }

    protected void emitMessageInArea(String id, EnumSet<Script.TargetReceiveGroups> receiveGroups, EnumSet<Script.Teamswithtarget> teams, double xOffset, double yOffset, double width, double height, Script.Yesno ignoreInvisibility, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected void playSound(String soundGroup) {
        throw new UnsupportedOperationException();
    }

    protected void completeMission(Script.MissionCompletionDelay delay) {
        throw new UnsupportedOperationException();
    }

    protected void missionGetScore(String clazz, Script.Teamswithnumbers team, Script.Scoretype type, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected void selectTarget(EnumSet<Script.TargetGroups> groupsToSelect, EnumSet<Script.Teams> teams, String clazz, Script.Yesno removeIfNotFound, double xOffset, double yOffset, double width, double height, Script.Valuecompare2 compareMethod, double healthValue, Script.DistanceCheck distanceCheck, Script.Yesno checkLineOfSight, Script.Yesno ignoreInvisibility) {
        throw new UnsupportedOperationException();
    }

    protected void selectPingWaypoint(Script.Ping ping) {
        throw new UnsupportedOperationException();
    }

    protected void pauseGame(Script.Yesno endOnButtonPress, Script.Yesno endOnAnimationFinished, Script.Yesno endOnTimeElapsed, double endOnTimeElapsedTime, String animationName, Script.Yesno loopAnimation, double animationXPosition, double animationYPosition, double animationSize, Script.Yesno animationNameBasedOnInputHardware, Script.Yesno animationTextsBasedOnInputHardware) {
        throw new UnsupportedOperationException();
    }

    protected void setBool(String id, Script.Flagtoggle value) {
        throw new UnsupportedOperationException();
    }

    protected void randomizeMissionCounter(String id, String low, String high) {
        throw new UnsupportedOperationException();
    }

    protected void enableUpgrade(Script.Yesno condition, String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected void pressStick(Script.Directions direction, double durationInSeconds) {
        throw new UnsupportedOperationException();
    }

    protected void playAnimation(String animationName, Script.AnimationLocation location, double xPosition, double yPosition, double scale, double depth, Script.Yesno mirrorX, Script.Teams team) {
        throw new UnsupportedOperationException();
    }

    protected void executeBehaviourTree(String fileName) {
        throw new UnsupportedOperationException();
    }

    protected void setMissionBool(String id, Script.Flagtoggle value) {
        throw new UnsupportedOperationException();
    }

    protected void buyUpgrade(String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected void receiveTarget() {
        throw new UnsupportedOperationException();
    }

    protected void selectTargetWaypoint() {
        throw new UnsupportedOperationException();
    }

    protected void removeTarget() {
        throw new UnsupportedOperationException();
    }

    protected boolean timePassed(Script.Timeunits timeunit, double time) {
        throw new UnsupportedOperationException();
    }

    protected boolean onGoldCollected(Script.MissionTarget collector, Script.Teamswithnumbers team, String clazz, Script.GoldPickupType type, Script.Valuecompare compareMethod, String value, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected boolean directionToEnemyBase(Script.Forwardbackward direction) {
        throw new UnsupportedOperationException();
    }

    protected boolean isSkillOnButtonAvailable(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean isNextWaypointPosition(Script.Offsetposition position) {
        throw new UnsupportedOperationException();
    }

    protected boolean isButtonReleased(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean isUpgradeEnabled(Script.Yesno condition, String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected boolean isTurretInArea(EnumSet<Script.Teams> teams, Script.Valuecompare healthComparison, double health, double xOffset, double yOffset, double width, double height, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected boolean isInArea(Script.Yesno condition, EnumSet<Script.CollisonGroups> collisionGroups, Script.Yesno checkGreenObstaclesOnly, EnumSet<Script.Teams> teams, String areaName, double xOffset, double yOffset, double width, double height, Script.Yesno checkLineOfSight, Script.Yesno ignoreInvisibility) {
        throw new UnsupportedOperationException();
    }

    protected boolean getMissionBoolEquals(String id, Script.Yesno value) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkCharacterValue(Script.CharactervaluesCheckable property, double value, Script.Valuecompare compareMethod, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean hasTarget(Script.Yesno condition) {
        throw new UnsupportedOperationException();
    }

    protected boolean isNextWaypointInArea(double xOffset, double yOffset, double width, double height) {
        throw new UnsupportedOperationException();
    }

    protected boolean isButtonPressed(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkCounter(String id, String value, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean isOnlineMatch() {
        throw new UnsupportedOperationException();
    }

    protected boolean onWin(Script.Teamswithnumbers team) {
        throw new UnsupportedOperationException();
    }

    protected boolean once() {
        throw new UnsupportedOperationException();
    }

    protected boolean compareMissionBools(String id1, String id2) {
        throw new UnsupportedOperationException();
    }

    protected boolean getBoolEquals(String id, Script.Yesno value) {
        throw new UnsupportedOperationException();
    }

    protected boolean canPayUpgrade(String upgradeName) {
        throw new UnsupportedOperationException();
    }

    protected boolean onKill(Script.MissionTarget killer, Script.Teamswithnumbers killerTeam, String killerClass, Script.MissionTarget victim, Script.Teamswithnumbers victimTeam, String victimClass, Script.Valuecompare compareMethod, String value, String storeIn) {
        throw new UnsupportedOperationException();
    }

    protected boolean isInNamedArea(String areaName, Script.Ownenemy team, Script.Targetself who) {
        throw new UnsupportedOperationException();
    }

    protected boolean onPrestige() {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedPing(Script.Ping ping) {
        throw new UnsupportedOperationException();
    }

    protected boolean random(String amount) {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedMessage(String id) {
        throw new UnsupportedOperationException();
    }

    protected boolean timer(Script.Timeunits timeunit, double time, Script.Yesno executeFirstTime) {
        throw new UnsupportedOperationException();
    }

    protected boolean onGameStarted() {
        throw new UnsupportedOperationException();
    }

    protected boolean areGoldCoinsInArea(double compareValue, Script.Valuecompare compareMethod, double xOffset, double yOffset, double width, double height, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected boolean isTargetType(Script.Yesno condition, EnumSet<Script.TargetGroups> targetGroups) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkClass(Script.Targetself checkOn, String clazz) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkMissionCounter(String id, String value, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkCharacterFlag(Script.Characterflags property, Script.Yesno condition, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean isOnCreepTurner(Script.Yesno condition, Script.Forwardbackward direction) {
        throw new UnsupportedOperationException();
    }

    protected boolean doesClassExist(EnumSet<Script.Teams> teams, String clazz) {
        throw new UnsupportedOperationException();
    }

    protected boolean receivedTarget(EnumSet<Script.TargetGroups> ifOfGroup) {
        throw new UnsupportedOperationException();
    }

    protected boolean isTargetInArea(Script.Yesno condition, double xOffset, double yOffset, double width, double height, Script.Yesno checkLineOfSight, Script.Yesno ignoreInvisibility) {
        throw new UnsupportedOperationException();
    }

    protected boolean hasDestWaypoint() {
        throw new UnsupportedOperationException();
    }

    protected boolean isFromTeam(Script.Teamswithnumbers team, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean isCharacterInArea(EnumSet<Script.TargetReceiveGroups> groups, EnumSet<Script.Teams> teams, String clazz, Script.CharactervaluesCheckable condition, Script.Valuecompare comparison, double value, String characterMinimum, double xOffset, double yOffset, double width, double height, Script.Yesno checkLineOfSight) {
        throw new UnsupportedOperationException();
    }

    protected boolean isPickupAtWaypoint(String name, Script.Ownenemy team) {
        throw new UnsupportedOperationException();
    }

    protected boolean isAtDestWaypoint() {
        throw new UnsupportedOperationException();
    }

    protected boolean isOnGround(Script.Yesno condition, Script.Targetself checkOn) {
        throw new UnsupportedOperationException();
    }

    protected boolean isButtonDown(Script.Buttons button) {
        throw new UnsupportedOperationException();
    }

    protected boolean isTargetPosition(Script.Yesno condition, Script.Offsetposition targetPosition) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkGameTime(double timeInSeconds, Script.Valuecompare compareMethod) {
        throw new UnsupportedOperationException();
    }

    protected boolean compareBools(String id1, String id2) {
        throw new UnsupportedOperationException();
    }

    protected boolean hasUpgrade(String clazz, Script.Teamswithnumbers team, String upgradeName) {
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
