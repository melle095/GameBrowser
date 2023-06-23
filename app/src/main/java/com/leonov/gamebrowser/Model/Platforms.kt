package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class Platforms (

  @SerializedName("platform"        ) var platform       : Platform? = Platform(),
  @SerializedName("released_at"     ) var releasedAt     : String?   = null,
  @SerializedName("requirements_en" ) var requirementsEn : Requirements? = Requirements(),
  @SerializedName("requirements_ru" ) var requirementsRu : Requirements? = Requirements()

)