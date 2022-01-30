package com.example.catchemall.repository.api

import com.example.catchemall.repository.results.LoadPokemonResult
import com.example.catchemall.repository.results.LoadPokemonListResult

interface PokemonAPIHelper {

    suspend fun loadPokemonList(): LoadPokemonListResult
    suspend fun loadPokemon(name: String): LoadPokemonResult

}
