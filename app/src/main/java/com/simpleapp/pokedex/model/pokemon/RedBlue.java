package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class RedBlue {

   @SerializedName("back_default")
   String backDefault;

   @SerializedName("back_gray")
   String backGray;

   @SerializedName("back_transparent")
   String backTransparent;

   @SerializedName("front_default")
   String frontDefault;

   @SerializedName("front_gray")
   String frontGray;

   @SerializedName("front_transparent")
   String frontTransparent;


    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }
    public String getBackDefault() {
        return backDefault;
    }
    
    public void setBackGray(String backGray) {
        this.backGray = backGray;
    }
    public String getBackGray() {
        return backGray;
    }
    
    public void setBackTransparent(String backTransparent) {
        this.backTransparent = backTransparent;
    }
    public String getBackTransparent() {
        return backTransparent;
    }
    
    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
    public String getFrontDefault() {
        return frontDefault;
    }
    
    public void setFrontGray(String frontGray) {
        this.frontGray = frontGray;
    }
    public String getFrontGray() {
        return frontGray;
    }
    
    public void setFrontTransparent(String frontTransparent) {
        this.frontTransparent = frontTransparent;
    }
    public String getFrontTransparent() {
        return frontTransparent;
    }
    
}