package com.example.catchemall.repository.results

import com.example.catchemall.repository.models.PokemonTest

sealed class LoadPokemonResult {
    data class Success(val pokemon: PokemonTest) : LoadPokemonResult()
    data class Failure(val error: LoadPokemonError) : LoadPokemonResult()
}
