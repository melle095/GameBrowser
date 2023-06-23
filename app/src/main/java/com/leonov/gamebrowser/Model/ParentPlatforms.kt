package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class ParentPlatforms (

  @SerializedName("platform" ) var platform : Platform? = Platform()

)