package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Cries {

   @SerializedName("latest")
   String latest;

   @SerializedName("legacy")
   String legacy;


    public void setLatest(String latest) {
        this.latest = latest;
    }
    public String getLatest() {
        return latest;
    }
    
    public void setLegacy(String legacy) {
        this.legacy = legacy;
    }
    public String getLegacy() {
        return legacy;
    }
    
}