package com.example.catchemall.view.home

import androidx.lifecycle.viewModelScope
import com.example.catchemall.repository.PokemonRepository
import com.example.catchemall.repository.models.PokemonItem
import com.example.catchemall.repository.results.LoadPokemonListError
import com.example.catchemall.repository.results.LoadPokemonListResult
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeDataFlow @Inject constructor(private val repository: PokemonRepository) :
    AndroidDataFlow(defaultState = UIState.Empty) {


    public val test = 1

    init {
        getPokemonList()
    }

    fun getPokemonList() = action {
        setState { PokemonListState.Loading }
        viewModelScope.launch {
            val result = repository.loadPokemonList()
            when (result) {
                is LoadPokemonListResult.Success -> {
                    setState(PokemonListState.Content(result.pokemonList.results))
                }
                is LoadPokemonListResult.Failure -> {
                    when (result.error) {
                        is LoadPokemonListError.SlowInternet -> {
                            setState(PokemonListState.Error("Slow Internet"))
                        }
                        is LoadPokemonListError.NoPokemonListFound -> {
                            setState(PokemonListState.Error("No Pokemon Found"))
                        }
                        is LoadPokemonListError.ServerError -> {
                            setState(PokemonListState.Error("Server Error"))
                        }
                        is LoadPokemonListError.NoInternet -> {
                            setState(PokemonListState.Error("No internet"))
                        }
                    }
                }
            }
        }


    }
}

sealed class PokemonListState : UIState() {
    data class Content(val pokemonList: List<PokemonItem>) : PokemonListState()
    object Loading : PokemonListState()
    data class Error(val errorMessage: String) : PokemonListState()
}