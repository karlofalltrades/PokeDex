package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationVI {

   @SerializedName("omegaruby-alphasapphire")
   OmegaRubyAlphaSapphire omegaRubyAlphaSapphire;

   @SerializedName("x-y")
   XY xy;


    public void setOmegaRubyAlphaSapphire(OmegaRubyAlphaSapphire omegaRubyAlphaSapphire) {
        this.omegaRubyAlphaSapphire = omegaRubyAlphaSapphire;
    }
    public OmegaRubyAlphaSapphire getOmegaRubyAlphaSapphire() {
        return omegaRubyAlphaSapphire;
    }
    
    public void setXY(XY xy) {
        this.xy = xy;
    }
    public XY getXY() {
        return xy;
    }
    
}