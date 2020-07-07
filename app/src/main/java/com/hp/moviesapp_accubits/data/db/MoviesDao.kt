package com.hp.moviesapp_accubits.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hp.moviesapp_accubits.data.model.MoviesResponse
@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMovies(movies : List<Result>)


}