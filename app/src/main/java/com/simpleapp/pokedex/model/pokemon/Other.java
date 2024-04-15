package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Other {

   @SerializedName("dream_world")
   DreamWorld dreamWorld;

   @SerializedName("home")
   Home home;

   @SerializedName("official-artwork")
   OfficialArtwork officialArtwork;

   @SerializedName("showdown")
   Showdown showdown;


    public void setDreamWorld(DreamWorld dreamWorld) {
        this.dreamWorld = dreamWorld;
    }
    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }
    
    public void setHome(Home home) {
        this.home = home;
    }
    public Home getHome() {
        return home;
    }
    
    public void setOfficialArtwork(OfficialArtwork officialArtwork) {
        this.officialArtwork = officialArtwork;
    }
    public OfficialArtwork getOfficialArtwork() {
        return officialArtwork;
    }
    
    public void setShowdown(Showdown showdown) {
        this.showdown = showdown;
    }
    public Showdown getShowdown() {
        return showdown;
    }
    
}