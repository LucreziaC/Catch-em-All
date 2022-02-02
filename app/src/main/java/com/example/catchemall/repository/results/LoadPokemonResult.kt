package com.example.catchemall.repository.results

import com.example.catchemall.repository.models.Pokemon

sealed class LoadPokemonResult {
    data class Success(val pokemon: Pokemon) : LoadPokemonResult()
    data class Failure(val error: LoadPokemonListError) : LoadPokemonResult()
}
