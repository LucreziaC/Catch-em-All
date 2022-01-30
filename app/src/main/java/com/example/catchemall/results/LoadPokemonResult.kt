package com.example.catchemall.results

import com.example.catchemall.models.Pokemon

sealed class LoadPokemonResult {
    data class Success(val pokemon: Pokemon) : LoadPokemonResult()
    data class Failure(val error: LoadPokemonListError) : LoadPokemonResult()
}
