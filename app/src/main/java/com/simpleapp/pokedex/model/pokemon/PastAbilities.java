package com.simpleapp.pokedex.model.pokemon;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class PastAbilities {

   @SerializedName("abilities")
   List<Abilities> abilities;

   @SerializedName("generation")
   Generation generation;


    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }
    public List<Abilities> getAbilities() {
        return abilities;
    }
    
    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
    public Generation getGeneration() {
        return generation;
    }
    
}