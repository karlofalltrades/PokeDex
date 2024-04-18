package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Item {

   @SerializedName("name")
   String name;

   @SerializedName("url")
   String url;


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
    
}