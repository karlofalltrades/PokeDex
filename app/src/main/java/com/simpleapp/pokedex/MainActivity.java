package com.simpleapp.pokedex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.simpleapp.pokedex.adapter.PokemonListAdapter;
import com.simpleapp.pokedex.model.PokemonData;
import com.simpleapp.pokedex.model.PokemonListItems;
import com.simpleapp.pokedex.model.PokemonResponse;
import com.simpleapp.pokedex.service.PokeApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;
    private List<PokemonListItems> pokemonListItemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerview);
        pokemonListItemsList = new ArrayList<>();
        pokemonListAdapter = new PokemonListAdapter(pokemonListItemsList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(pokemonListAdapter);

        ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "", "Gathering Pokemons...");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApiService pokeApiService = retrofit.create(PokeApiService.class);

        Call<PokemonResponse> call = pokeApiService.getPokemonList();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    if (pokemonResponse != null && pokemonResponse.getResults() != null) {
                        for (PokemonData pokemonData : pokemonResponse.getResults()) {
                            String id = extractIdFromUrl(pokemonData.getUrl());
                            String name = pokemonData.getName().toUpperCase();
                            String imageUrlFromId = getImageUrlFromId(id);
                            pokemonListItemsList.add(new PokemonListItems(Integer.parseInt(id), name, imageUrlFromId));
                        }
                        pokemonListAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {

            }
        });
        pokemonListAdapter.setOnItemClickListener(new PokemonListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                intent.putExtra("url", "https://pokeapi.co/api/v2/pokemon/"+ pokemonListItemsList.get(position).getId() +"/");
                startActivity(intent);
//                Toast.makeText(MainActivity.this, "Clicked: " + pokemonListItemsList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String extractIdFromUrl(String url) {
        url = url.replaceAll("/$", "");

        String[] parts = url.split("/");

        String lastPart = parts[parts.length - 1];
        return lastPart;
    }

    private String getImageUrlFromId(String id) {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/"+ id +".png";
    }
}