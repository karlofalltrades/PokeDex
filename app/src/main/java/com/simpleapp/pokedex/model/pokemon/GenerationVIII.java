package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationVIII {

   @SerializedName("icons")
   Icons icons;


    public void setIcons(Icons icons) {
        this.icons = icons;
    }
    public Icons getIcons() {
        return icons;
    }
    
}