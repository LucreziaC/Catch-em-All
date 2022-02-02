package com.example.catchemall.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.catchemall.R
import com.example.catchemall.databinding.FragmentHomeBinding
import com.example.catchemall.repository.models.PokemonItem
import com.example.catchemall.util.bindings.viewBinding
import com.example.catchemall.util.getCurrentPosition
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.onStates


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    val viewModel : HomeDataFlow by viewModels()
    val binding : FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

    var pokemonList: ArrayList<PokemonItem>? = ArrayList()

    companion object {
        var listPosition = 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pokemonList.addItemDecoration(
            DividerItemDecoration(requireContext(),
            DividerItemDecoration.VERTICAL))
        val pokemonListAdapter = PokemonListAdapter(requireContext()){ pokemon ->
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(pokemon.name))
        }

        pokemonListAdapter.setAnnunciList(pokemonList?: ArrayList())

        binding.pokemonList.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    listPosition = binding.pokemonList.getCurrentPosition()
                    //fine della lista da scrollare
                    viewModel.getPokemonList() //l'ultima posizione la prima volta è 15. Per prendere gli item successivi nella getPokemonList, itemNum deve essere >15
                }
            }
        })

        binding.pokemonList.adapter = pokemonListAdapter
        // Observe incoming states
        onStates(viewModel) { state ->
            when (state) {
                // react on WeatherState update
                is PokemonListState.Content -> {
                    state.pokemonList.map{ pokemon ->
                        pokemonList?.add(pokemon)
                    }
                    pokemonListAdapter.notifyItemInserted(listPosition+1)
                }
            }
        }

    }

}
