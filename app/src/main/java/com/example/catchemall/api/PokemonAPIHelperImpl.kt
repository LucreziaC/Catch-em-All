package com.example.catchemall.api

import com.example.catchemall.results.LoadPokemonError
import com.example.catchemall.results.LoadPokemonError.*
import com.example.catchemall.results.LoadPokemonResult
import com.example.catchemall.results.LoadPokemonResult.*
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class PokemonAPIHelperImpl @Inject constructor(private var service: PokemonService) : PokemonAPIHelper{

    override suspend fun loadPokemonList(): LoadPokemonResult {
        return try{
            val pokemonList = service.getPokemonList(15)
            if(pokemonList.results.isEmpty()){
                Failure(NoPokemonFound)
            }else
                Success(pokemonList)
        }catch (e: IOException) { // no internet
            Failure(NoInternet)
        } catch (e: SocketTimeoutException) {
            Failure(SlowInternet)
        } catch (e: Exception) {
            Failure(ServerError)
        }
    }

}
