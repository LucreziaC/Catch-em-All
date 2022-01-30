package com.example.catchemall.repository

import com.example.catchemall.api.PokemonAPIHelper
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonAPIHelper: PokemonAPIHelper) {

    suspend fun loadPokemonList() = pokemonAPIHelper.loadPokemonList()

}
