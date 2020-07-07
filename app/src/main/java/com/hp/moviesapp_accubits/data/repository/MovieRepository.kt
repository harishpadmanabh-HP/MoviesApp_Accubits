package com.hp.moviesapp_accubits.data.repository

import androidx.lifecycle.MutableLiveData
import com.hp.moviesapp_accubits.data.db.AppDataBase
import com.hp.moviesapp_accubits.data.model.MoviesResponse
import com.hp.moviesapp_accubits.data.network.API_KEY
import com.hp.moviesapp_accubits.data.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MovieRepository {

    init {
        Timber.d("Repository init")
    }

    fun loadMovies(): MutableLiveData<MoviesResponse> {
        var moviesResponse =MutableLiveData<MoviesResponse>()
        ApiService().getMovies(API_KEY,"en-US").enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {

                Timber.e("API CALL FAILURE $t")
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {

                moviesResponse.postValue(response.body())
            }
        })

        return moviesResponse
    }

}