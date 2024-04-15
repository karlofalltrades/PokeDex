package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Icons {

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_female")
   String frontFemale;


    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
    public String getFrontDefault() {
        return frontDefault;
    }
    
    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }
    public String getFrontFemale() {
        return frontFemale;
    }
    
}