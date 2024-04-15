package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class UltraSunUltraMoon {

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_female")
   String frontFemale;

   @SerializedName("front_shiny")
   String frontShiny;

   @SerializedName("front_shiny_female")
   String frontShinyFemale;


    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
    public String getFrontDefault() {
        return frontDefault;
    }
    
    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }
    public String getFrontFemale() {
        return frontFemale;
    }
    
    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }
    public String getFrontShiny() {
        return frontShiny;
    }
    
    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }
    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }
    
}