package com.example.catchemall.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.catchemall.R
import com.example.catchemall.databinding.FragmentHomeBinding
import com.example.catchemall.util.bindings.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.onStates


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    val viewModel : HomeDataFlow by viewModels()
    val binding : FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pokemonList.addItemDecoration(
            DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL))
        val pokemonListAdapter = PokemonListAdapter(requireContext()){ pokemon ->

        }

        binding.pokemonList.adapter = pokemonListAdapter
        // Observe incoming states
        onStates(viewModel) { state ->
            when (state) {
                // react on WeatherState update
                is PokemonListState.Content -> pokemonListAdapter.setAnnunciList(state.pokemonList)
            }
        }

    }

}
