package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class Genres (

  @SerializedName("id"               ) var id              : Int?    = null,
  @SerializedName("name"             ) var name            : String? = null,
  @SerializedName("slug"             ) var slug            : String? = null,
  @SerializedName("games_count"      ) var gamesCount      : Int?    = null,
  @SerializedName("image_background" ) var imageBackground : String? = null

)