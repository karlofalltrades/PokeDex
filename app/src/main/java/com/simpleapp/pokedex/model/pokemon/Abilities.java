package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Abilities {

   @SerializedName("ability")
   Ability ability;

   @SerializedName("is_hidden")
   boolean isHidden;

   @SerializedName("slot")
   int slot;


    public void setAbility(Ability ability) {
        this.ability = ability;
    }
    public Ability getAbility() {
        return ability;
    }
    
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
    public boolean getIsHidden() {
        return isHidden;
    }
    
    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getSlot() {
        return slot;
    }
    
}