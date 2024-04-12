package com.simpleapp.pokedex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleapp.pokedex.adapter.PokemonListAdapter;
import com.simpleapp.pokedex.model.PokemonData;
import com.simpleapp.pokedex.model.PokemonListItems;
import com.simpleapp.pokedex.model.PokemonResponse;
import com.simpleapp.pokedex.service.PokeApiService;
import com.simpleapp.pokedex.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PokemonListAdapter pokemonListAdapter;
    private List<PokemonListItems> pokemonListItemsList;
    private int offset = 0;
    private boolean isLoading = false;
    private ProgressBar progressBar;

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

        initViewItems();

        ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "", "Gathering Pokemons...");

        loadData(offset, progressDialog);
        pokemonListAdapter.setOnItemClickListener(new PokemonListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                intent.putExtra("url", Constants.BASE_URL + "pokemon/" + pokemonListItemsList.get(position).getId() + "/");
                startActivity(intent);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                    progressBar.setVisibility(View.VISIBLE);
                    offset += Constants.LIMIT;
                    loadData(offset, null);
                }
            }
        });
    }

    private void initViewItems() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);
        pokemonListItemsList = new ArrayList<>();
        pokemonListAdapter = new PokemonListAdapter(pokemonListItemsList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(pokemonListAdapter);
    }

    private void loadData(int offset, ProgressDialog progressDialog) {
        isLoading = true;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApiService pokeApiService = retrofit.create(PokeApiService.class);
        Call<PokemonResponse> call = pokeApiService.getPokemonList(offset, Constants.LIMIT);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (progressBar.getVisibility() == View.VISIBLE) progressBar.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
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
                    }
                } else {
                    if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "There was a problem gathering the pokemons, check your connection.", Toast.LENGTH_LONG).show();
                }
                isLoading = false;
                if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "There was a problem gathering the pokemons. Try checking your connection!", Toast.LENGTH_LONG).show();
                isLoading = false;
                if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
                if (progressBar.getVisibility() == View.VISIBLE) progressBar.setVisibility(View.GONE);
            }
        });
    }

    private String extractIdFromUrl(String url) {
        url = url.replaceAll("/$", "");

        String[] parts = url.split("/");

        return parts[parts.length - 1];
    }

    private String getImageUrlFromId(String id) {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png";
    }
}