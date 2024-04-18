package com.simpleapp.pokedex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.simpleapp.pokedex.model.pokemon.Abilities;
import com.simpleapp.pokedex.model.pokemon.Pokemon;
import com.simpleapp.pokedex.model.pokemon.Stats;
import com.simpleapp.pokedex.model.pokemon.Types;
import com.simpleapp.pokedex.service.PokeApiService;
import com.simpleapp.pokedex.utils.Constants;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonDetailActivity extends AppCompatActivity {

    private Pokemon pokemon;
    private ImageView pokemonImage;
    private TextView pokemonName, hpStat, attackStat, defenseStat, specialAttackStat, specialDefenseStat, speedStat;
    private ProgressBar hpBar, attackBar, defenseBar, specialDefenseBar, specialAttackBar, speedBar, loadingImageView;
    private ChipGroup typeChipGroup;
    private ChipGroup abilitesChipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pokemondetailview), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViewItems();
    }

    private void initViewItems() {
        pokemonImage = findViewById(R.id.imageView);
        pokemonName = findViewById(R.id.nameTextView);
        hpStat = findViewById(R.id.hpStatNumber);
        attackStat = findViewById(R.id.attackStatNumber);
        defenseStat = findViewById(R.id.defenseStatNumber);
        specialAttackStat = findViewById(R.id.specialAttackStatNumber);
        specialDefenseStat = findViewById(R.id.specialDefenseStatNumber);
        speedStat = findViewById(R.id.speedStatNumber);
        typeChipGroup = findViewById(R.id.typeChipGroup);
        abilitesChipGroup = findViewById(R.id.abilitiesChipGroup);
        hpBar  = findViewById(R.id.hpBar);
        attackBar  = findViewById(R.id.attackBar);
        defenseBar  = findViewById(R.id.defenseBar);
        specialAttackBar  = findViewById(R.id.specialAttackBar);
        specialDefenseBar  = findViewById(R.id.specialDefenseBar);
        speedBar  = findViewById(R.id.speedBar);
        loadingImageView = findViewById(R.id.loadingImageView);
        retrieveIntentData();
    }

    private void retrieveIntentData() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            Toast.makeText(getApplicationContext(), "NAME:" + name, Toast.LENGTH_LONG).show();
            loadPokemonDetails(name);
        } else {
            Toast.makeText(PokemonDetailActivity.this, "There was a problem showing the pokemon details!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void loadPokemonDetails (String name){

        Log.d("POKEMON NAME", name);
        if (pokemonImage.getVisibility() == View.VISIBLE) pokemonImage.setVisibility(View.GONE);
        loadingImageView.setVisibility(View.VISIBLE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApiService pokeApiService = retrofit.create(PokeApiService.class);
        Call<Pokemon> call = pokeApiService.getPokemonDetailByName(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()){
                    pokemon = response.body();
                    if (pokemon != null){
                        bindDataIntoViews(pokemon);

                        Toast.makeText(PokemonDetailActivity.this, "Information received.", Toast.LENGTH_SHORT).show();
                        Log.d("POKEMON NAME", pokemon.getName());
                        Log.d("POKEMON ID", String.valueOf(pokemon.getId()));
                        Log.d("POKEMON IMAGE", pokemon.getSprites().getFrontDefault());
                    } else {
                        Log.d("POKEMON DATA:", "POKEMON DATA IS NULL");
                        finish();
                        Toast.makeText(PokemonDetailActivity.this, "Unable to retrieve pokemon data at the moment, Try again later!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.d("UNSUCCESSFUL:", "UNSUCCESSFUL RESPONSE");
                    finish();
                    Toast.makeText(PokemonDetailActivity.this, "There was a problem getting pokemon info, check your connection!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(PokemonDetailActivity.this, "There was a problem getting pokemon info, check your connection!", Toast.LENGTH_LONG).show();
                Log.d("FAILED:", "FAILED RESPONSE");
                finish();
            }
        });
    }

    private void bindDataIntoViews(Pokemon pokemon) {
        Picasso.get().load(pokemon.getSprites().getFrontDefault()).into(pokemonImage, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
                pokemonImage.setVisibility(View.VISIBLE);
                if (loadingImageView.getVisibility() == View.VISIBLE) loadingImageView.setVisibility(View.GONE);
            }

            @Override
            public void onError(Exception e) {
                pokemonImage.setVisibility(View.GONE);
            }
        });

        String pokemonString = String.format("#%03d", pokemon.getId()) + " " + pokemon.getName().toUpperCase();
        pokemonName.setText(pokemonString);

        for (Stats stat : pokemon.getStats()){
            if (stat.getStat().getName().equalsIgnoreCase("hp")) {
                hpBar.setProgress(stat.getBaseStat(), true);
                hpStat.setText(String.valueOf(stat.getBaseStat()));
            } else if (stat.getStat().getName().equalsIgnoreCase("attack")) {
                attackBar.setProgress(stat.getBaseStat(), true);
                attackStat.setText(String.valueOf(stat.getBaseStat()));
            } else if (stat.getStat().getName().equalsIgnoreCase("defense")) {
                defenseBar.setProgress(stat.getBaseStat(), true);
                defenseStat.setText(String.valueOf(stat.getBaseStat()));
            } else if (stat.getStat().getName().equalsIgnoreCase("special-attack")) {
                specialAttackBar.setProgress(stat.getBaseStat(), true);
                specialAttackStat.setText(String.valueOf(stat.getBaseStat()));
            } else if (stat.getStat().getName().equalsIgnoreCase("special-defense")) {
                specialDefenseBar.setProgress(stat.getBaseStat(), true);
                specialDefenseStat.setText(String.valueOf(stat.getBaseStat()));
            } else if (stat.getStat().getName().equalsIgnoreCase("speed")) {
                speedBar.setProgress(stat.getBaseStat(), true);
                speedStat.setText(String.valueOf(stat.getBaseStat()));
            }
        }

        for (Types types: pokemon.getTypes()){
            Chip chip = new Chip(this);
            chip.setText(types.getType().getName());
            int colorId = getResources().getIdentifier(types.getType().getName().toLowerCase(), "color", getPackageName());
            chip.setChipBackgroundColorResource(colorId);
            typeChipGroup.addView(chip);
        }

        for (Abilities abilities: pokemon.getAbilities()){
            Chip chip = new Chip(this);
            chip.setText(abilities.getAbility().getName());
            abilitesChipGroup.addView(chip);
        }
    }
}