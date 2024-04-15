package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Types {

   @SerializedName("slot")
   int slot;

   @SerializedName("type")
   Type type;


    public void setSlot(int slot) {
        this.slot = slot;
    }
    public int getSlot() {
        return slot;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    public Type getType() {
        return type;
    }
    
}