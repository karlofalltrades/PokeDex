package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class OfficialArtwork {

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_shiny")
   String frontShiny;


    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
    public String getFrontDefault() {
        return frontDefault;
    }
    
    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }
    public String getFrontShiny() {
        return frontShiny;
    }
    
}