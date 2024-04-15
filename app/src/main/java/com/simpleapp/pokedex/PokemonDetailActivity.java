package com.simpleapp.pokedex;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.simpleapp.pokedex.model.pokemon.Pokemon;
import com.simpleapp.pokedex.service.PokeApiService;
import com.simpleapp.pokedex.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonDetailActivity extends AppCompatActivity {

    private Pokemon pokemon;

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
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            Log.d("POKEMON DETAIL", name);
            Toast.makeText(getApplicationContext(), "NAME:" + name, Toast.LENGTH_LONG).show();
            loadPokemonDetails(name);
        } else {
            Toast.makeText(PokemonDetailActivity.this, "There was a problem showing the pokemon details!", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void loadPokemonDetails (String name){
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
                        Toast.makeText(PokemonDetailActivity.this, "Information received.", Toast.LENGTH_SHORT).show();
                        Log.d("POKEMON NAME", pokemon.getName());
                        Log.d("POKEMON ID", String.valueOf(pokemon.getId()));
                        Log.d("POKEMON IMAGE", pokemon.getSprites().getFrontDefault());
                    }
                } else {
                    Log.d("UNSUCCESSFUL:", "UNSUCCESSFUL RESPONSE");
                    Toast.makeText(PokemonDetailActivity.this, "There was a problem getting pokemon info, check your connection!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "There was a problem getting pokemon info, check your connection!", Toast.LENGTH_LONG).show();
                Log.d("FAILED:", "FAILED RESPONSE");
            }
        });
    }
}