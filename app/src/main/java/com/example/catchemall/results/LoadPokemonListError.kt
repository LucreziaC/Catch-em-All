package com.example.catchemall.results

sealed class LoadPokemonListError {
    object NoPokemonListFound : LoadPokemonListError()
    object NoInternet : LoadPokemonListError()
    object SlowInternet : LoadPokemonListError()
    object ServerError : LoadPokemonListError()
}
