package com.example.catchemall.results

sealed class LoadPokemonError {
    object NoPokemonFound : LoadPokemonError()
    object NoInternet : LoadPokemonError()
    object SlowInternet : LoadPokemonError()
    object ServerError : LoadPokemonError()
}
