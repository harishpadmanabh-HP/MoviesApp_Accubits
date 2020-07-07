package com.hp.moviesapp_accubits

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hp.moviesapp_accubits.ui.adapter.NewMoviesAdapter
import com.hp.moviesapp_accubits.ui.adapter.NewVideosAdapter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context=this.applicationContext
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.movieLiveData.observe(this, Observer {
            new_release_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
            new_release_list.adapter = NewMoviesAdapter(context,it)

            new_videos_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
            new_videos_list.adapter = NewVideosAdapter(it)



            for(movie in it.results)
            {
                Timber.e("MOVIE NAME : ${movie.title}")
            }
        })
    }
}