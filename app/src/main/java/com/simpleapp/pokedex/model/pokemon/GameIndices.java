package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GameIndices {

   @SerializedName("game_index")
   int gameIndex;

   @SerializedName("version")
   Version version;


    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }
    public int getGameIndex() {
        return gameIndex;
    }
    
    public void setVersion(Version version) {
        this.version = version;
    }
    public Version getVersion() {
        return version;
    }
    
}