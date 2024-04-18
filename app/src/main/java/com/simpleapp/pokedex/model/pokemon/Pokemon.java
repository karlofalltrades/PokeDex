package com.simpleapp.pokedex.model.pokemon;
import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

   
public class Pokemon {

   @SerializedName("abilities")
   List<Abilities> abilities;

   @SerializedName("base_experience")
   int baseExperience;

   @SerializedName("cries")
   Cries cries;

   @SerializedName("forms")
   List<Forms> forms;

   @SerializedName("game_indices")
   List<GameIndices> gameIndices;

   @SerializedName("height")
   int height;

   @SerializedName("held_items")
   List<HeldItems> heldItems;

   @SerializedName("id")
   int id;

   @SerializedName("is_default")
   boolean isDefault;

   @SerializedName("location_area_encounters")
   String locationAreaEncounters;

   @SerializedName("moves")
   List<Moves> moves;

   @SerializedName("name")
   String name;

   @SerializedName("order")
   int order;

   @SerializedName("past_abilities")
   List<String> pastAbilities;

   @SerializedName("past_types")
   List<PastTypes> pastTypes;

   @SerializedName("species")
   Species species;

   @SerializedName("sprites")
   Sprites sprites;

   @SerializedName("stats")
   List<Stats> stats;

   @SerializedName("types")
   List<Types> types;

   @SerializedName("weight")
   int weight;


    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }
    public List<Abilities> getAbilities() {
        return abilities;
    }
    
    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }
    public int getBaseExperience() {
        return baseExperience;
    }
    
    public void setCries(Cries cries) {
        this.cries = cries;
    }
    public Cries getCries() {
        return cries;
    }
    
    public void setForms(List<Forms> forms) {
        this.forms = forms;
    }
    public List<Forms> getForms() {
        return forms;
    }
    
    public void setGameIndices(List<GameIndices> gameIndices) {
        this.gameIndices = gameIndices;
    }
    public List<GameIndices> getGameIndices() {
        return gameIndices;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public void setHeldItems(List<HeldItems> heldItems) {
        this.heldItems = heldItems;
    }
    public List<HeldItems> getHeldItems() {
        return heldItems;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
    public boolean getIsDefault() {
        return isDefault;
    }
    
    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }
    
    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }
    public List<Moves> getMoves() {
        return moves;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void setOrder(int order) {
        this.order = order;
    }
    public int getOrder() {
        return order;
    }
    
    public void setPastAbilities(List<String> pastAbilities) {
        this.pastAbilities = pastAbilities;
    }
    public List<String> getPastAbilities() {
        return pastAbilities;
    }

    public void setPastTypes(List<PastTypes> pastTypes) {
        this.pastTypes = pastTypes;
    }
    public List<PastTypes> getPastTypes() {
        return pastTypes;
    }
    
    public void setSpecies(Species species) {
        this.species = species;
    }
    public Species getSpecies() {
        return species;
    }
    
    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
    public Sprites getSprites() {
        return sprites;
    }
    
    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
    public List<Stats> getStats() {
        return stats;
    }
    
    public void setTypes(List<Types> types) {
        this.types = types;
    }
    public List<Types> getTypes() {
        return types;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    
}