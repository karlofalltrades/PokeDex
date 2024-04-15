package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationV {

   @SerializedName("black-white")
   BlackWhite blackWhite;


    public void setBlackWhite(BlackWhite blackWhite) {
        this.blackWhite = blackWhite;
    }
    public BlackWhite getBlackWhite() {
        return blackWhite;
    }
    
}