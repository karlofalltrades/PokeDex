package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class VersionDetails {

   @SerializedName("rarity")
   int rarity;

   @SerializedName("version")
   Version version;


    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    public int getRarity() {
        return rarity;
    }
    
    public void setVersion(Version version) {
        this.version = version;
    }
    public Version getVersion() {
        return version;
    }
    
}