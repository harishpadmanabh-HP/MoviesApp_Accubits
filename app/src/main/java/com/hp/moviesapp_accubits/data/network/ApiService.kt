package com.hp.moviesapp_accubits.data.network

import com.hp.moviesapp_accubits.data.model.MoviesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "9c0523bff54071c4fb4b716a950231b9"


interface ApiService {

    @GET("upcoming?&page=1&region=IN|US&with_release_type=2|3")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String
    ): Call<MoviesResponse>

    companion object {
        operator fun invoke(): ApiService {
        var logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        val client: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(logger).build()

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .build()

                .create(ApiService::class.java)
        }
    }
}