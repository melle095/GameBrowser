package com.leonov.gamebrowser.Model

import com.google.gson.annotations.SerializedName

data class Requirements (
    @SerializedName("minimum") var min   : String?    = null,
    @SerializedName("recommended") var max : String? = null
)