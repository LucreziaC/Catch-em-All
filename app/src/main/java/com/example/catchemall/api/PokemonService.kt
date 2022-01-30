package com.example.catchemall.api

import com.example.catchemall.models.PokemonListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET(APIUrls.POKEMON_LIST)
    suspend fun getPokemonList(@Query("limit") itemsNum:Int): PokemonListDTO

}
