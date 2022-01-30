package com.example.catchemall.repository.results

sealed class LoadPokemonListError {
    object NoPokemonListFound : LoadPokemonListError()
    object NoInternet : LoadPokemonListError()
    object SlowInternet : LoadPokemonListError()
    object ServerError : LoadPokemonListError()
}
