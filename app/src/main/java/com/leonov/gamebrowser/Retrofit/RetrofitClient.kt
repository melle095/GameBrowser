package com.leonov.gamebrowser.Retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    val httpClient = OkHttpClient.Builder()
        .addInterceptor {chain -> return@addInterceptor addApiKeyToRequest(chain)}
        .build()
    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    private fun addApiKeyToRequest(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val newUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("key", "572cf03460334d68b4a0c14cc5e66109")
            .build()
        request.url(newUrl)
        return chain.proceed(request.build())
    }
}