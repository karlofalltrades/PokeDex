package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class GenerationIV {

   @SerializedName("diamondPearl")
   DiamondPearl diamondPearl;

   @SerializedName("heartGoldSoulSilver")
   HeartGoldSoulSilver heartGoldSoulSilver;

   @SerializedName("platinum")
   Platinum platinum;


    public void setDiamondPearl(DiamondPearl diamondPearl) {
        this.diamondPearl = diamondPearl;
    }
    public DiamondPearl getDiamondPearl() {
        return diamondPearl;
    }
    
    public void setHeartGoldSoulSilver(HeartGoldSoulSilver heartGoldSoulSilver) {
        this.heartGoldSoulSilver = heartGoldSoulSilver;
    }
    public HeartGoldSoulSilver getHeartGoldSoulSilver() {
        return heartGoldSoulSilver;
    }
    
    public void setPlatinum(Platinum platinum) {
        this.platinum = platinum;
    }
    public Platinum getPlatinum() {
        return platinum;
    }
    
}