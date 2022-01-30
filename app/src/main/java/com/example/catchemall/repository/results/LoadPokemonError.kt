package com.example.catchemall.repository.results

sealed class LoadPokemonError {
    object NoInternet : LoadPokemonError()
    object SlowInternet : LoadPokemonError()
    object ServerError : LoadPokemonError()
}
