package com.simpleapp.pokedex.model.pokemon;

import com.google.gson.annotations.SerializedName;

   
public class Versions {

   @SerializedName("generation-i")
   GenerationI generationI;

   @SerializedName("generation-ii")
   GenerationII generationII;

   @SerializedName("generation-iii")
   GenerationIII generationIII;

   @SerializedName("generation-iv")
   GenerationIV generationIV;

   @SerializedName("generation-v")
   GenerationV generationV;

   @SerializedName("generation-vi")
   GenerationVI generationVI;

   @SerializedName("generation-vii")
   GenerationVII generationVII;

   @SerializedName("generation-viii")
   GenerationVIII generationVIII;


    public void setGenerationI(GenerationI generationI) {
        this.generationI = generationI;
    }
    public GenerationI getGenerationI() {
        return generationI;
    }

    public void setGenerationII(GenerationII generationII) {
        this.generationII = generationII;
    }
    public GenerationII getGenerationII() {
        return generationII;
    }

    public GenerationIII getGenerationIII() {
        return generationIII;
    }

    public void setGenerationIII(GenerationIII generationIII) {
        this.generationIII = generationIII;
    }

    public GenerationIV getGenerationIV() {
        return generationIV;
    }

    public void setGenerationIV(GenerationIV generationIV) {
        this.generationIV = generationIV;
    }

    public GenerationV getGenerationV() {
        return generationV;
    }

    public void setGenerationV(GenerationV generationV) {
        this.generationV = generationV;
    }

    public GenerationVI getGenerationVI() {
        return generationVI;
    }

    public void setGenerationVI(GenerationVI generationVI) {
        this.generationVI = generationVI;
    }

    public GenerationVII getGenerationVII() {
        return generationVII;
    }

    public void setGenerationVII(GenerationVII generationVII) {
        this.generationVII = generationVII;
    }

    public GenerationVIII getGenerationVIII() {
        return generationVIII;
    }

    public void setGenerationVIII(GenerationVIII generationVIII) {
        this.generationVIII = generationVIII;
    }
}