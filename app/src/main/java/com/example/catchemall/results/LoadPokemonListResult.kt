package com.example.catchemall.results

import com.example.catchemall.models.PokemonListDTO

sealed class LoadPokemonListResult {
    data class Success(val pokemonList: PokemonListDTO) : LoadPokemonListResult()
    data class Failure(val error: LoadPokemonListError) : LoadPokemonListResult()
}
