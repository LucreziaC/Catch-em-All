package com.example.catchemall.view.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catchemall.R
import com.example.catchemall.databinding.PokemonItemBinding
import com.example.catchemall.repository.models.PokemonItem


class PokemonListAdapter(
    private val context: Context,
    private val onClick: (PokemonItem) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {

    private var pokemonList: List<PokemonItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind( context, pokemonList[position], onClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAnnunciList(pokemonList: List<PokemonItem>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }
}

class MyViewHolder(private val binding: PokemonItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(
        context: Context,
        pokemon: PokemonItem,
        onClick: (PokemonItem) -> Unit,
    ) {

        Glide.with(context)
            .load(R.drawable.pokeball)
            .into(binding.pokemonImage)

        Glide.with(context)
            .load(R.drawable.ic_arrow)
            .into(binding.arrow)

        binding.pokemonName.text = pokemon.name
        binding.root.setOnClickListener {
            onClick(pokemon)
        }
    }
}