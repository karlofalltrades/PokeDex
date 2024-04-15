package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class VersionGroupDetails {

   @SerializedName("level_learned_at")
   int levelLearnedAt;

   @SerializedName("move_learn_method")
   MoveLearnMethod moveLearnMethod;

   @SerializedName("version_group")
   VersionGroup versionGroup;


    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }
    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }
    
    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }
    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }
    
    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }
    public VersionGroup getVersionGroup() {
        return versionGroup;
    }
    
}