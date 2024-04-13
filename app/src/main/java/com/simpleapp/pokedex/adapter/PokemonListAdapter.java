package com.simpleapp.pokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simpleapp.pokedex.R;
import com.simpleapp.pokedex.model.PokemonListItems;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> {

    private List<PokemonListItems> pokemonList;

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PokemonListAdapter(List<PokemonListItems> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void filterList(List<PokemonListItems> filteredList) {
        pokemonList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent, false);
        return new PokemonViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonListItems pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private ProgressBar progressBar;
        private TextView idTextView;
        private TextView nameTextView;

        public PokemonViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            progressBar = itemView.findViewById(R.id.homeprogress);
            idTextView = itemView.findViewById(R.id.idTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            itemView.setOnClickListener(v -> {
                if (onItemClickListener != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        onItemClickListener.onItemClick(pos);
                    }
                }
            });
        }

        public void bind(PokemonListItems pokemon) {
            imageView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Picasso.get().load(pokemon.getImageUrl()).into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    imageView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError(Exception e) {
                    imageView.setVisibility(View.GONE);
                }
            });
            idTextView.setText(String.format("#%03d", pokemon.getId()));
            nameTextView.setText(pokemon.getName());
        }
    }
}

