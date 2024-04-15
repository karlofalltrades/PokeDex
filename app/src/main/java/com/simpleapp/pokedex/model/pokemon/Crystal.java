package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Crystal {

   @SerializedName("back_default")
   String backDefault;

   @SerializedName("back_shiny")
   String backShiny;

   @SerializedName("back_shiny_transparent")
   String backShinyTransparent;

   @SerializedName("back_transparent")
   String backTransparent;

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_shiny")
   String frontShiny;

   @SerializedName("front_shiny_transparent")
   String frontShinyTransparent;

   @SerializedName("front_transparent")
   String frontTransparent;


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
    
    public void setBackShinyTransparent(String backShinyTransparent) {
        this.backShinyTransparent = backShinyTransparent;
    }
    public String getBackShinyTransparent() {
        return backShinyTransparent;
    }
    
    public void setBackTransparent(String backTransparent) {
        this.backTransparent = backTransparent;
    }
    public String getBackTransparent() {
        return backTransparent;
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
    
    public void setFrontShinyTransparent(String frontShinyTransparent) {
        this.frontShinyTransparent = frontShinyTransparent;
    }
    public String getFrontShinyTransparent() {
        return frontShinyTransparent;
    }
    
    public void setFrontTransparent(String frontTransparent) {
        this.frontTransparent = frontTransparent;
    }
    public String getFrontTransparent() {
        return frontTransparent;
    }
    
}