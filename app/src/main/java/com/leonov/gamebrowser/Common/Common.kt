package com.leonov.gamebrowser.Common

import com.leonov.gamebrowser.Interface.RetrofitServices
import com.leonov.gamebrowser.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://api.rawg.io/api/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}