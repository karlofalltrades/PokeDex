package com.simpleapp.pokedex.model.pokemon;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class PastTypes {

   @SerializedName("generation")
   Generation generation;

   @SerializedName("types")
   List<Types> types;


    public void setGeneration(Generation generation) {
        this.generation = generation;
    }
    public Generation getGeneration() {
        return generation;
    }
    
    public void setTypes(List<Types> types) {
        this.types = types;
    }
    public List<Types> getTypes() {
        return types;
    }
    
}