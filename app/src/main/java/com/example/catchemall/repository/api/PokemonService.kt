package com.example.catchemall.repository.api

import com.example.catchemall.repository.models.PokemonListDTO
import com.example.catchemall.repository.models.PokemonTest
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET(APIUrls.POKEMON_LIST)
    suspend fun loadPokemonList(@Query("limit") itemsNum:Int, @Query("offset") offset:Int ): PokemonListDTO

    @GET(APIUrls.SINGLE_POKEMON)
    suspend fun loadPokemon(@Path("name") name:String): PokemonTest

}
