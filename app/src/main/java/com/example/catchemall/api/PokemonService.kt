package com.example.catchemall.api

import com.example.catchemall.models.Pokemon
import com.example.catchemall.models.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET(APIUrls.POKEMON_LIST)
    suspend fun loadPokemonList(@Query("limit") itemsNum:Int): PokemonListDTO

    @GET(APIUrls.SINGLE_POKEMON)
    suspend fun loadPokemon(@Path("name") name:String): Pokemon

}
