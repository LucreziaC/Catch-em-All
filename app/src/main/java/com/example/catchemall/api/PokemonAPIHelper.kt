package com.example.catchemall.api

import com.example.catchemall.results.LoadPokemonResult

interface PokemonAPIHelper {

    suspend fun loadPokemonList(): LoadPokemonResult

}
