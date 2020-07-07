package com.hp.moviesapp_accubits

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hp.moviesapp_accubits.data.model.MoviesResponse
import com.hp.moviesapp_accubits.data.repository.MovieRepository

class MainActivityViewModel : ViewModel(){


    val movieLiveData: LiveData<MoviesResponse>
            = MovieRepository().loadMovies()
    fun fetchMovieData()= movieLiveData

}