package com.example.catchemall.api

import com.example.catchemall.results.LoadPokemonListError.*
import com.example.catchemall.results.LoadPokemonListResult
import com.example.catchemall.results.LoadPokemonListResult.*
import com.example.catchemall.results.LoadPokemonResult
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class PokemonAPIHelperImpl @Inject constructor(private var service: PokemonService) : PokemonAPIHelper{

    override suspend fun loadPokemonList(): LoadPokemonListResult {
        return try{
            val pokemonList = service.loadPokemonList(15)
            if(pokemonList.results.isEmpty()){
                Failure(NoPokemonListFound)
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

    override suspend fun loadPokemon( name: String): LoadPokemonResult {
       return try{
           val pokemon = service.loadPokemon(name)
           return LoadPokemonResult.Success(pokemon)
       }catch (e: IOException) { // no internet
           LoadPokemonResult.Failure(NoInternet)
       } catch (e: SocketTimeoutException) {
           LoadPokemonResult.Failure(SlowInternet)
       } catch (e: Exception) {
           LoadPokemonResult.Failure(ServerError)
       }
    }

}
