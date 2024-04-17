package com.simpleapp.pokedex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    private SwipeRefreshLayout swipeRefreshLayout;
    private PokemonListAdapter pokemonListAdapter;
    private List<PokemonListItems> pokemonListItemsList;
    private List<PokemonListItems> filteredList;
    private int offset = 0;
    private boolean isLoading = false;
    private ProgressBar progressBar;
    private EditText searchText;

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
        setupSearchField();
        setupSwipeToRefresh();

        ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "", "Gathering Pokemons...");
        loadData(offset, progressDialog);

        setupAdapterItemOnClickListener();
        setRecyclerViewOnScrollListener();
    }

    private void initViewItems() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_bar);
        searchText = findViewById(R.id.input_text);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        pokemonListItemsList = new ArrayList<>();
        pokemonListAdapter = new PokemonListAdapter(pokemonListItemsList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(pokemonListAdapter);
    }

    private void setupSearchField() {
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput = s.toString().toLowerCase().trim();
                searchPokemon(userInput);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void searchPokemon(String query) {
        filteredList = new ArrayList<>();
        for (PokemonListItems item : pokemonListItemsList) {
            if (item.getName().toLowerCase().contains(query)) {
                filteredList.add(item);
            }
        }
        pokemonListAdapter.filterList(filteredList);
    }

    private void setupSwipeToRefresh() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(true);
            offset = 0;
            pokemonListItemsList.clear();
            loadData(offset, null);
        });
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
                if (swipeRefreshLayout.isRefreshing()) swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    if (pokemonResponse != null && pokemonResponse.getResults() != null) {
                        for (PokemonData pokemonData : pokemonResponse.getResults()) {
                            String id = extractIdFromUrl(pokemonData.getUrl());
                            String name = pokemonData.getName().toUpperCase();
                            String imageUrlFromId = generateImageUrlFromId(id);
                            pokemonListItemsList.add(new PokemonListItems(Integer.parseInt(id), name, imageUrlFromId));
                        }
                        pokemonListAdapter.notifyDataSetChanged();
                    }
                } else {
                    if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "There was a problem gathering the pokemons, check your connection!", Toast.LENGTH_LONG).show();
                }
                isLoading = false;
                if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                if (swipeRefreshLayout.isRefreshing()) swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "There was a problem gathering the pokemons. Try checking your connection!", Toast.LENGTH_LONG).show();
                isLoading = false;
                if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
                if (progressBar.getVisibility() == View.VISIBLE) progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void setupAdapterItemOnClickListener() {
        pokemonListAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
            intent.putExtra("name", pokemonListItemsList.get(position).getName().toLowerCase());
            Toast.makeText(MainActivity.this, Constants.BASE_URL + "pokemon/" + pokemonListItemsList.get(position).getId() + "/", Toast.LENGTH_LONG).show();
            startActivity(intent);
        });
    }

    private void setRecyclerViewOnScrollListener() {
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

    private String extractIdFromUrl(String url) {
        url = url.replaceAll("/$", "");

        String[] parts = url.split("/");

        return parts[parts.length - 1];
    }

    private String generateImageUrlFromId(String id) {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png";
    }
}