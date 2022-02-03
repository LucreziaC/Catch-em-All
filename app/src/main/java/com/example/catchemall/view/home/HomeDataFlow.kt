package com.example.catchemall.view.home

import androidx.lifecycle.viewModelScope
import com.example.catchemall.repository.PokemonRepository
import com.example.catchemall.repository.models.PokemonItem
import com.example.catchemall.repository.results.LoadPokemonListError
import com.example.catchemall.repository.results.LoadPokemonListResult
import com.example.catchemall.view.detail.DetailFragmentItems
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeDataFlow @Inject constructor(private val repository: PokemonRepository) :
    AndroidDataFlow(defaultState = UIState.Empty) {


    private var itemNum = 15
    private var offset =0

    init {
        getPokemonList()
    }

    fun getPokemonList() = action {
        setState { PokemonListState.Loading }

        viewModelScope.launch {
            val result = repository.loadPokemonList(itemNum,offset)
            offset+=itemNum
            when (result) {
                is LoadPokemonListResult.Success -> {
                    setState(PokemonListState.Content(result.pokemonList.results))
                }
                is LoadPokemonListResult.Failure -> {
                    when (result.error) {
                        is LoadPokemonListError.SlowInternet -> setState(PokemonListState.Error("Slow Internet! Retry again later"))
                        is LoadPokemonListError.NoPokemonListFound -> setState(PokemonListState.Error("No Pokemon Found!"))
                        is LoadPokemonListError.ServerError -> setState(PokemonListState.Error("Server Error! Retry again later"))
                        is LoadPokemonListError.NoInternet -> setState(PokemonListState.Error("No internet! Retry again later"))
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