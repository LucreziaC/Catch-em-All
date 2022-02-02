package com.example.catchemall.view.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.catchemall.R
import com.example.catchemall.databinding.FragmentDetailBinding
import com.example.catchemall.util.bindings.viewBinding
import com.example.catchemall.util.exhaustive
import com.github.florent37.glidepalette.GlidePalette
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.livedata.onStates

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    val binding : FragmentDetailBinding by viewBinding(FragmentDetailBinding::bind)
    private val args: DetailFragmentArgs by navArgs()
    val viewModel : DetailDataFlow by viewModels()

    lateinit var pokemonName :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonName= args.pokemonName
        viewModel.sendName(pokemonName)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DetailFragmentAdapter(requireContext())
        binding.detailList.adapter = adapter

        onStates(viewModel) { state ->
            when (state) {
                is PokemonDetailState.Content -> {
                    adapter.items = state.details
                }
                else -> {}
            }.exhaustive
        }
    }

}


