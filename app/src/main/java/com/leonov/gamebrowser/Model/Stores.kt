package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class Stores (

  @SerializedName("id"    ) var id    : Int?   = null,
  @SerializedName("store" ) var store : Store? = Store()

)