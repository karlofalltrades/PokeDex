package com.simpleapp.pokedex.service;

import com.simpleapp.pokedex.model.PokemonResponse;
import com.simpleapp.pokedex.model.pokemon.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonList(@Query("offset") int offset,
                                         @Query("limit") int limit);

    @GET("pokemon/{name}")
    Call<Pokemon> getPokemonDetailByName(@Path("name") String name);
}

