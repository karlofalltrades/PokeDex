package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Stats {

   @SerializedName("base_stat")
   int baseStat;

   @SerializedName("effort")
   int effort;

   @SerializedName("stat")
   Stat stat;


    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }
    public int getBaseStat() {
        return baseStat;
    }
    
    public void setEffort(int effort) {
        this.effort = effort;
    }
    public int getEffort() {
        return effort;
    }
    
    public void setStat(Stat stat) {
        this.stat = stat;
    }
    public Stat getStat() {
        return stat;
    }
    
}