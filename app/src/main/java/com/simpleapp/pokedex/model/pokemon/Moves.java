package com.simpleapp.pokedex.model.pokemon;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Moves {

   @SerializedName("move")
   Move move;

   @SerializedName("version_group_details")
   List<VersionGroupDetails> versionGroupDetails;


    public void setMove(Move move) {
        this.move = move;
    }
    public Move getMove() {
        return move;
    }
    
    public void setVersionGroupDetails(List<VersionGroupDetails> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }
    public List<VersionGroupDetails> getVersionGroupDetails() {
        return versionGroupDetails;
    }
    
}