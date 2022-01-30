package com.example.catchemall.repository

import com.example.catchemall.api.PokemonAPIHelper
import com.example.catchemall.results.LoadPokemonListResult
import com.example.catchemall.results.LoadPokemonResult
import javax.inject.Inject

interface PokemonRepository {
    suspend fun loadPokemonList(): LoadPokemonListResult
    suspend fun loadPokemon(name:String): LoadPokemonResult

}


class PokemonRepositoryImpl @Inject constructor(private val pokemonAPIHelper: PokemonAPIHelper) :PokemonRepository{
    override suspend fun loadPokemonList() = pokemonAPIHelper.loadPokemonList()
    override suspend fun loadPokemon(name: String): LoadPokemonResult = pokemonAPIHelper.loadPokemon(name)
}
