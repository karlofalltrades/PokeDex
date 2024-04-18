package com.simpleapp.pokedex.model.pokemon;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class HeldItems {

   @SerializedName("item")
   Item item;

   @SerializedName("version_details")
   List<VersionDetails> versionDetails;


    public void setItem(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }
    
    public void setVersionDetails(List<VersionDetails> versionDetails) {
        this.versionDetails = versionDetails;
    }
    public List<VersionDetails> getVersionDetails() {
        return versionDetails;
    }
    
}