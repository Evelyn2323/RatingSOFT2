package com.example.ratingsoft.Conexion


import com.example.ratingsoft.ApiServices.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ApiConexion {

    val baseUrl = "http://192.168.80.23:8000"

    private fun getRetrofit(): Retrofit {

        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient().newBuilder()
            .addInterceptor(logger)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(baseUrl)
            .build()
    }
    fun getApiService(): ApiServices {
        return getRetrofit().create(ApiServices::class.java)
    }

}