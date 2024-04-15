package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationI {

   @SerializedName("red-blue")
   RedBlue redblue;

   @SerializedName("yellow")
   Yellow yellow;


    public void setRedBlue(RedBlue redblue) {
        this.redblue = redblue;
    }
    public RedBlue getRedBlue() {
        return redblue;
    }
    
    public void setYellow(Yellow yellow) {
        this.yellow = yellow;
    }
    public Yellow getYellow() {
        return yellow;
    }
    
}