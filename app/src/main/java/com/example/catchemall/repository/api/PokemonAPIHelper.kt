package com.example.catchemall.repository.api

import com.example.catchemall.repository.results.LoadPokemonListResult
import com.example.catchemall.repository.results.LoadPokemonResult

interface PokemonAPIHelper {

    suspend fun loadPokemonList(itemNum: Int, offset: Int): LoadPokemonListResult
    suspend fun loadPokemon(name: String): LoadPokemonResult

}
