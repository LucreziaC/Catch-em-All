package com.example.catchemall.models

import com.squareup.moshi.Json


data class Pokemon(
    val abilities: List<Ability>,
    @Json(name = "base_experience")
    val baseExperience: Int,
    val forms: List<Form>,
    @Json(name ="game_indices")
    val gameIndices: List<GameIndice>,
    val height: Int,
    @Json(name ="held_items")
    val heldItems: List<HeldItem>,
    val id: Int,
    @Json(name ="is_default")
    val isDefault: Boolean,
    @Json(name ="location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    @Json(name ="past_types")
    val pastTypes: List<PastType>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
) {
    data class Ability(
        val ability: Ability,
        @Json(name ="is_hidden")
        val isHidden: Boolean,
        val slot: Int
    ) {
        data class Ability(
            val name: String,
            val url: String
        )
    }

    data class Form(
        val name: String,
        val url: String
    )

    data class GameIndice(
        @Json(name ="game_index")
        val gameIndex: Int,
        val version: Version
    ) {
        data class Version(
            val name: String,
            val url: String
        )
    }

    data class HeldItem(
        val item: Item,
        @Json(name ="version_details")
        val versionDetails: List<VersionDetail>
    ) {
        data class Item(
            val name: String,
            val url: String
        )

        data class VersionDetail(
            val rarity: Int,
            val version: Version
        ) {
            data class Version(
                val name: String,
                val url: String
            )
        }
    }

    data class Move(
        val move: Move,
        @Json(name ="version_group_details")
        val versionGroupDetails: List<VersionGroupDetail>
    ) {
        data class Move(
            val name: String,
            val url: String
        )

        data class VersionGroupDetail(
            @Json(name ="level_learned_at")
            val levelLearnedAt: Int,
            @Json(name ="move_learn_method")
            val moveLearnMethod: MoveLearnMethod,
            @Json(name ="version_group")
            val versionGroup: VersionGroup
        ) {
            data class MoveLearnMethod(
                val name: String,
                val url: String
            )


            data class VersionGroup(
                val name: String,
                val url: String
            )
        }
    }

    data class PastType(
        val generation: Generation,
        val types: List<Type>
    ) {
        data class Generation(
            val name: String,
            val url: String
        )

        data class Type(
            val slot: Int,
            val type: Type
        ) {
            data class Type(
                val name: String,
                val url: String
            )
        }
    }

    data class Species(
        val name: String,
        val url: String
    )

    data class Sprites(
        @Json(name ="back_default")
        val backDefault: String,
        @Json(name ="back_female")
        val backFemale: Any,
        @Json(name ="back_shiny")
        val backShiny: String,
        @Json(name ="back_shiny_female")
        val backShinyFemale: Any,
        @Json(name ="front_default")
        val frontDefault: String,
        @Json(name ="front_female")
        val frontFemale: Any,
        @Json(name ="front_shiny")
        val frontShiny: String,
        @Json(name ="front_shiny_female")
        val frontShinyFemale: Any,
        val other: Other,
        val versions: Versions
    ) {
        data class Other(
            @Json(name ="dream_world")
            val dreamWorld: DreamWorld,
            val home: Home,
            @Json(name ="official-artwork")
            val officialArtwork: OfficialArtwork
        ) {
            data class DreamWorld(
                @Json(name ="front_default")
                val frontDefault: String,
                @Json(name ="front_female")
                val frontFemale: Any
            )

            data class Home(
                @Json(name ="front_default")
                val frontDefault: String,
                @Json(name ="front_female")
                val frontFemale: Any,
                @Json(name ="front_shiny")
                val frontShiny: String,
                @Json(name ="front_shiny_female")
                val frontShinyFemale: Any
            )

            data class OfficialArtwork(
                @Json(name ="front_default")
                val frontDefault: String
            )
        }

        data class Versions(
            @Json(name ="generation-i")
            val generationI: GenerationI,
            @Json(name ="generation-ii")
            val generationIi: GenerationIi,
            @Json(name ="generation-iii")
            val generationIii: GenerationIii,
            @Json(name ="generation-iv")
            val generationIv: GenerationIv,
            @Json(name ="generation-v")
            val generationV: GenerationV,
            @Json(name ="generation-vi")
            val generationVi: GenerationVi,
            @Json(name ="generation-vii")
            val generationVii: GenerationVii,
            @Json(name ="generation-viii")
            val generationViii: GenerationViii
        ) {
            data class GenerationI(
                @Json(name ="red-blue")
                val redBlue: RedBlue,
                val yellow: Yellow
            ) {
                data class RedBlue(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_gray")
                    val backGray: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_gray")
                    val frontGray: String
                )

                data class Yellow(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_gray")
                    val backGray: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_gray")
                    val frontGray: String
                )
            }

            data class GenerationIi(
                val crystal: Crystal,
                val gold: Gold,
                val silver: Silver
            ) {
                data class Crystal(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )

                data class Gold(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )

                data class Silver(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )
            }

            data class GenerationIii(
                val emerald: Emerald,
                @Json(name ="firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen,
                @Json(name ="ruby-sapphire")
                val rubySapphire: RubySapphire
            ) {
                data class Emerald(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )

                data class FireredLeafgreen(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )

                data class RubySapphire(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_shiny")
                    val frontShiny: String
                )
            }

            data class GenerationIv(
                @Json(name ="diamond-pearl")
                val diamondPearl: DiamondPearl,
                @Json(name ="heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver,
                val platinum: Platinum
            ) {
                data class DiamondPearl(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_female")
                    val backFemale: Any,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="back_shiny_female")
                    val backShinyFemale: Any,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class HeartgoldSoulsilver(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_female")
                    val backFemale: Any,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="back_shiny_female")
                    val backShinyFemale: Any,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class Platinum(
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_female")
                    val backFemale: Any,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="back_shiny_female")
                    val backShinyFemale: Any,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationV(
                @Json(name ="black-white")
                val blackWhite: BlackWhite
            ) {
                data class BlackWhite(
                    @Json(name ="animated")
                    val animated: Animated,
                    @Json(name ="back_default")
                    val backDefault: String,
                    @Json(name ="back_female")
                    val backFemale: Any,
                    @Json(name ="back_shiny")
                    val backShiny: String,
                    @Json(name ="back_shiny_female")
                    val backShinyFemale: Any,
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                ) {
                    data class Animated(
                        @Json(name ="back_default")
                        val backDefault: String,
                        @Json(name ="back_female")
                        val backFemale: Any,
                        @Json(name ="back_shiny")
                        val backShiny: String,
                        @Json(name ="back_shiny_female")
                        val backShinyFemale: Any,
                        @Json(name ="front_default")
                        val frontDefault: String,
                        @Json(name ="front_female")
                        val frontFemale: Any,
                        @Json(name ="front_shiny")
                        val frontShiny: String,
                        @Json(name ="front_shiny_female")
                        val frontShinyFemale: Any
                    )
                }
            }

            data class GenerationVi(
                @Json(name ="omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire,
                @Json(name ="x-y")
                val xY: XY
            ) {
                data class OmegarubyAlphasapphire(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )

                data class XY(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationVii(
                val icons: Icons,
                @Json(name ="ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon
            ) {
                data class Icons(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any
                )

                data class UltraSunUltraMoon(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any,
                    @Json(name ="front_shiny")
                    val frontShiny: String,
                    @Json(name ="front_shiny_female")
                    val frontShinyFemale: Any
                )
            }

            data class GenerationViii(
                val icons: Icons
            ) {
                data class Icons(
                    @Json(name ="front_default")
                    val frontDefault: String,
                    @Json(name ="front_female")
                    val frontFemale: Any
                )
            }
        }
    }

    data class Stat(
        @Json(name ="base_stat")
        val baseStat: Int,
        val effort: Int,
        val stat: Stat
    ) {
        data class Stat(
            val name: String,
            val url: String
        )
    }

    data class Type(
        val slot: Int,
        val type: Type
    ) {
        data class Type(
            val name: String,
            val url: String
        )
    }
}
