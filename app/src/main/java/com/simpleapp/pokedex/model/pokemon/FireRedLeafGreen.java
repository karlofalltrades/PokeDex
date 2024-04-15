package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class FireRedLeafGreen {

   @SerializedName("back_default")
   String backDefault;

   @SerializedName("back_shiny")
   String backShiny;

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_shiny")
   String frontShiny;


    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }
    public String getBackDefault() {
        return backDefault;
    }
    
    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }
    public String getBackShiny() {
        return backShiny;
    }
    
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