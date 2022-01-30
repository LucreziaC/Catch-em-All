package com.example.catchemall.api

import com.example.catchemall.results.LoadPokemonResult
import com.example.catchemall.results.LoadPokemonListResult

interface PokemonAPIHelper {

    suspend fun loadPokemonList(): LoadPokemonListResult
    suspend fun loadPokemon(name: String): LoadPokemonResult

}
