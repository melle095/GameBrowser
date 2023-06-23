package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName


data class Filters (

  @SerializedName("years" ) var years : ArrayList<Years> = arrayListOf()

)