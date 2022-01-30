package com.example.catchemall.results

import com.example.catchemall.models.PokemonListDTO

sealed class LoadPokemonResult {
    data class Success(val cocktails: PokemonListDTO) : LoadPokemonResult()
    data class Failure(val error: LoadPokemonError) : LoadPokemonResult()
}
