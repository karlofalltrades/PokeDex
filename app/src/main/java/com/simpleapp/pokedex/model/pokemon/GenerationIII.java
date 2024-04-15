package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationIII {

   @SerializedName("emerald")
   Emerald emerald;

   @SerializedName("firered-leafgreen")
   FireRedLeafGreen fireRedLeafGreen;

   @SerializedName("ruby-sapphire")
   RubySapphire rubySapphire;


    public void setEmerald(Emerald emerald) {
        this.emerald = emerald;
    }
    public Emerald getEmerald() {
        return emerald;
    }
    
    public void setFireRedLeafGreen(FireRedLeafGreen fireRedLeafGreen) {
        this.fireRedLeafGreen = fireRedLeafGreen;
    }
    public FireRedLeafGreen getfireRedLeafGreen() {
        return fireRedLeafGreen;
    }
    
    public void setRubySapphire(RubySapphire rubySapphire) {
        this.rubySapphire = rubySapphire;
    }
    public RubySapphire getRubySapphire() {
        return rubySapphire;
    }
    
}