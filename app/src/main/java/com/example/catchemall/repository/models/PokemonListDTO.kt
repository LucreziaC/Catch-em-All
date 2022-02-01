package com.example.catchemall.repository.models

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PokemonListDTO(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<PokemonItem>
)
@JsonClass(generateAdapter = true)
data class PokemonItem(
    val name: String,
    val url: String
)
