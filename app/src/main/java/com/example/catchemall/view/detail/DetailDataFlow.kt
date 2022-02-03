package com.example.catchemall.view.detail

import com.example.catchemall.repository.PokemonRepository
import com.example.catchemall.repository.results.LoadPokemonError
import com.example.catchemall.repository.results.LoadPokemonListError
import com.example.catchemall.repository.results.LoadPokemonResult
import com.example.catchemall.view.home.PokemonListState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import javax.inject.Inject

@HiltViewModel
class DetailDataFlow @Inject constructor(private val repository: PokemonRepository) :
    AndroidDataFlow(defaultState = UIState.Empty) {

    fun sendName(pokemonName: String) {
        getPokemonDetail(pokemonName)
    }

    private fun getPokemonDetail(pokemonName: String) = action {
        setState { PokemonListState.Loading }
        val result = repository.loadPokemon(pokemonName)
        when (result) {
            is LoadPokemonResult.Success -> {
                val pokemon = result.pokemon
                val stats = pokemon.stats.map { stat ->
                    StatUI(stat.baseStat ?: -1, stat.stat.name ?: "")
                }
                val abilities = pokemon.abilities?.map{ability->
                        AbilityUI(ability.ability.name ?: "")

                }
                var typeString: String = ""
                val typeList= pokemon.types.map { type ->
                    typeString+="${type.type.name}, "
                }

                val image = pokemon.sprites?.other?.officialArtwork?.frontDefault ?: ""
                val content: List<DetailFragmentItems> = listOf(
                    DetailFragmentItems.Image(image),
                    DetailFragmentItems.Characteristic(typeString, pokemon.height.toString(), pokemon.weight.toString()),
                    DetailFragmentItems.AbilitiesList(abilities as List<AbilityUI>),
                    DetailFragmentItems.StatsList(stats),
                )
                setState(PokemonDetailState.Content(content, image))
            }
            is LoadPokemonResult.Failure -> {
                when (result.error) {
                    is LoadPokemonError.SlowInternet -> {
                        setState(PokemonDetailState.Error("Slow Internet! Retry again later"))
                    }
                    is LoadPokemonError.ServerError -> {
                        setState(PokemonDetailState.Error("Server Error! Retry again later"))
                    }
                    is LoadPokemonError.NoInternet -> {
                        setState(PokemonDetailState.Error("No internet! Retry again later"))
                    }
                }
            }
        }
    }


}

sealed class PokemonDetailState : UIState() {
    data class Content(val details: List<DetailFragmentItems>, val image:String) : PokemonDetailState()
    object Loading : PokemonDetailState()
    data class Error(val errorMessage: String) : PokemonDetailState()
}
