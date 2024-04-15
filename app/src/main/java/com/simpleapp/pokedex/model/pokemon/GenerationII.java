package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationII {

   @SerializedName("crystal")
   Crystal crystal;

   @SerializedName("gold")
   Gold gold;

   @SerializedName("silver")
   Silver silver;


    public void setCrystal(Crystal crystal) {
        this.crystal = crystal;
    }
    public Crystal getCrystal() {
        return crystal;
    }
    
    public void setGold(Gold gold) {
        this.gold = gold;
    }
    public Gold getGold() {
        return gold;
    }
    
    public void setSilver(Silver silver) {
        this.silver = silver;
    }
    public Silver getSilver() {
        return silver;
    }
    
}