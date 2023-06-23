package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class ShortScreenshots (

  @SerializedName("id"    ) var id    : Int?    = null,
  @SerializedName("image" ) var image : String? = null

)