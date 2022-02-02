package com.example.catchemall.repository.api

import android.util.Log
import com.example.catchemall.repository.results.LoadPokemonError
import com.example.catchemall.repository.results.LoadPokemonListError.*
import com.example.catchemall.repository.results.LoadPokemonListResult
import com.example.catchemall.repository.results.LoadPokemonListResult.Failure
import com.example.catchemall.repository.results.LoadPokemonListResult.Success
import com.example.catchemall.repository.results.LoadPokemonResult
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class PokemonAPIHelperImpl @Inject constructor(private val service: PokemonService) : PokemonAPIHelper {

    override suspend fun loadPokemonList(itemNum: Int, offset: Int): LoadPokemonListResult {
        return try{
            val pokemonList = service.loadPokemonList(itemNum, offset)
            if(pokemonList.results.isEmpty()){
                Failure(NoPokemonListFound)
            }else
                Success(pokemonList)
        }catch (e: IOException) { // no internet
            Failure(NoInternet)
        } catch (e: SocketTimeoutException) {
            Failure(SlowInternet)
        } catch (e: Exception) {
            Log.e("ECCEZIONE: ",e.printStackTrace().toString() )
            e.printStackTrace()
            Failure(ServerError)
        }
    }

    override suspend fun loadPokemon( name: String): LoadPokemonResult {
       return try{
           val pokemon = service.loadPokemon(name)
           return LoadPokemonResult.Success(pokemon)
       }catch (e: IOException) { // no internet
           LoadPokemonResult.Failure(LoadPokemonError.NoInternet)
       } catch (e: SocketTimeoutException) {
           LoadPokemonResult.Failure(LoadPokemonError.SlowInternet)
       } catch (e: Exception) {
           e.printStackTrace()
           LoadPokemonResult.Failure(LoadPokemonError.ServerError)
       }
    }

}
