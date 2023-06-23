package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class Platform (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("slug" ) var slug : String? = null

)