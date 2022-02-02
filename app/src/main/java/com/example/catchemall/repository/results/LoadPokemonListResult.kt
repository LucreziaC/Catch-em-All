package com.example.catchemall.repository.results

import com.example.catchemall.repository.models.PokemonListDTO

sealed class LoadPokemonListResult {
    data class Success(val pokemonList: PokemonListDTO) : LoadPokemonListResult()
    data class Failure(val error: LoadPokemonListError) : LoadPokemonListResult()
}
