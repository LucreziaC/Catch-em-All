package com.example.catchemall.results

sealed class LoadPokemonError {
    object NoInternet : LoadPokemonError()
    object SlowInternet : LoadPokemonError()
    object ServerError : LoadPokemonError()
}
