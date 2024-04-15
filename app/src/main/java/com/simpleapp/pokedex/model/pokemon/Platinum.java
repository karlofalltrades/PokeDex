package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Platinum {

   @SerializedName("back_default")
   String backDefault;

   @SerializedName("back_female")
   String backFemale;

   @SerializedName("back_shiny")
   String backShiny;

   @SerializedName("back_shiny_female")
   String backShinyFemale;

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_female")
   String frontFemale;

   @SerializedName("front_shiny")
   String frontShiny;

   @SerializedName("front_shiny_female")
   String frontShinyFemale;


    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }
    public String getBackDefault() {
        return backDefault;
    }
    
    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }
    public String getBackFemale() {
        return backFemale;
    }
    
    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }
    public String getBackShiny() {
        return backShiny;
    }
    
    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }
    public String getBackShinyFemale() {
        return backShinyFemale;
    }
    
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