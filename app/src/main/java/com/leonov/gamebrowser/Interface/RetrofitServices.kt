package com.leonov.gamebrowser.Interface

import com.leonov.gamebrowser.Model.ExampleJson2KtKotlin
import com.leonov.gamebrowser.Model.Results
import retrofit2.Call
import retrofit2.http.*


interface RetrofitServices {
    @GET("games?page_size=20") //page=1&page_size=10
    fun getMovieList(@Query("page") page:Int): Call<ExampleJson2KtKotlin>
}