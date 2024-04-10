package com.simpleapp.pokedex.service;

import com.simpleapp.pokedex.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApiService {
    @GET("pokemon?offset=0&limit=100")
    Call<PokemonResponse> getPokemonList();
}

