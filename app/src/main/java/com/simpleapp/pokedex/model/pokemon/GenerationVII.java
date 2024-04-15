package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationVII {

   @SerializedName("icons")
   Icons icons;

   @SerializedName("ultra-sun-ultra-moon")
   UltraSunUltraMoon ultraSunUltraMoon;


    public void setIcons(Icons icons) {
        this.icons = icons;
    }
    public Icons getIcons() {
        return icons;
    }
    
    public void setUltraSunUltraMoon(UltraSunUltraMoon ultraSunUltraMoon) {
        this.ultraSunUltraMoon = ultraSunUltraMoon;
    }
    public UltraSunUltraMoon getUltraSunUltraMoon() {
        return ultraSunUltraMoon;
    }
    
}