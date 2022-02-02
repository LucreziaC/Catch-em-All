package com.example.catchemall.view.detail

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catchemall.R
import com.example.catchemall.databinding.*
import com.example.catchemall.view.detail.DetailFragmentItems.*
import com.example.catchemall.view.detail.DetailFragmentViewHolder.*
import com.example.catchemall.util.exhaustive


sealed class DetailFragmentItems {
    data class Image(val image: String) : DetailFragmentItems()
    data class Characteristic(val type: String, val height: String, val weight: String) : DetailFragmentItems()
    data class AbilitiesList(val abilities: List<AbilityUI>) : DetailFragmentItems()
    data class StatsList(val stats: List<StatUI>) : DetailFragmentItems()

}



private const val IMAGE_VIEWTYPE = 1
private const val CARACHTERISTIC_VIEWTYPE = 6
private const val ABILITIES_LIST_VIEWTYPE = 3
private const val STATES_LIST_VIEWTYPE = 4

class DetailFragmentAdapter(private val context: Context) : RecyclerView.Adapter<DetailFragmentViewHolder>() {
    var items: List<DetailFragmentItems> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item) {
            is Image -> IMAGE_VIEWTYPE
            is Characteristic -> CARACHTERISTIC_VIEWTYPE
            is AbilitiesList -> ABILITIES_LIST_VIEWTYPE
            is StatsList -> STATES_LIST_VIEWTYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailFragmentViewHolder {
        return when (viewType) {
            CARACHTERISTIC_VIEWTYPE -> {
                val binding = FragmentDetailCharacteristicsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CharacteristicViewHolder(binding)
            }
            IMAGE_VIEWTYPE -> {
                val binding = FragmentDetailImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ImageViewHolder(binding)
            }
            ABILITIES_LIST_VIEWTYPE -> {
                val binding = FragmentDetailAbilitiesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                AbilitiesViewHolder(binding)
            }
            STATES_LIST_VIEWTYPE -> {
                val binding = FragmentDetailStatsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                StatsViewHolder(binding)
            }
            else -> error("ViewType not valid")
        }
    }

    override fun onBindViewHolder(holder: DetailFragmentViewHolder, position: Int) {
        when (holder) {
            is CharacteristicViewHolder -> holder.bind(items[position] as Characteristic)
            is ImageViewHolder -> holder.bind(items[position] as Image,context)
            is DetailFragmentViewHolder.AbilitiesViewHolder -> holder.bind(items[position] as AbilitiesList, context)
            is DetailFragmentViewHolder.StatsViewHolder -> holder.bind(items[position] as StatsList)
        }.exhaustive
    }

    override fun getItemCount(): Int = items.size
}

sealed class DetailFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class ImageViewHolder(private val binding: FragmentDetailImageBinding) :
        DetailFragmentViewHolder(binding.root) {
        fun bind(item: Image,context:Context) {
            Glide.with(context).load(item.image).into(binding.pokemonDetailImage)
        }
    }

    class CharacteristicViewHolder(private val binding: FragmentDetailCharacteristicsBinding) :
        DetailFragmentViewHolder(binding.root) {
        fun bind(characteristic: Characteristic) {
            binding.pokemonType.text = "Type: ${characteristic.type}"
            binding.pokemonHeight.text = "Height: ${characteristic.height}"
            binding.pokemonWeight.text = "Weight: ${characteristic.weight}"
        }
    }

    class AbilitiesViewHolder(private val binding: FragmentDetailAbilitiesBinding) :
        DetailFragmentViewHolder(binding.root) {
        fun bind(abilitiesList: AbilitiesList, context: Context) {
            val adapter = AbilitiesListAdapter(context)
            binding.abilitiesList.adapter = adapter
            adapter.setAbilitiesList(abilitiesList.abilities)
        }
    }

    class StatsViewHolder(private val binding: FragmentDetailStatsBinding) :
        DetailFragmentViewHolder(binding.root) {
        fun bind(statsList: StatsList) {
            val adapter = StatsListAdapter()
            binding.statsList.adapter = adapter
            adapter.setStatsList(statsList.stats)
        }
    }

}

class AbilitiesListAdapter(private val context: Context) :
    RecyclerView.Adapter<AbilitiesViewHolder>() {
    private var abilitiesList: List<AbilityUI> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val binding = AbilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.bind(abilitiesList[position],context)
    }

    override fun getItemCount(): Int {
        return abilitiesList.size
    }

    fun setAbilitiesList(items: List<AbilityUI>) {
        abilitiesList = items
        notifyDataSetChanged()
    }
}

class AbilitiesViewHolder(val binding: AbilityItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AbilityUI, context:Context) {
        Glide.with(context).load(R.drawable.pokeball_icon).into(binding.image)
        binding.description.text = item.ability
    }
}
class StatsListAdapter :
    RecyclerView.Adapter<StatsViewHolder>() {
    private var statsList: List<StatUI> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val binding = StatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(statsList[position])
    }

    override fun getItemCount(): Int {
        return statsList.size
    }

    fun setStatsList(items: List<StatUI>) {
        statsList = items
        notifyDataSetChanged()
    }
}

class StatsViewHolder(val binding: StatItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: StatUI) {
        binding.statName.text = item.name
        binding.statValue.text = item.value.toString()
    }
}

data class AbilityUI(val ability:String)
data class StatUI(val value: Int, val name: String)