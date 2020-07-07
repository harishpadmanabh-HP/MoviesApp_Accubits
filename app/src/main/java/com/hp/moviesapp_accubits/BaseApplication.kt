package com.hp.moviesapp_accubits

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.hp.moviesapp_accubits.data.db.AppDataBase
import com.hp.moviesapp_accubits.data.db.MoviesDao
import com.hp.moviesapp_accubits.data.network.ApiService
import com.hp.moviesapp_accubits.data.network.NetworkConnectionInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import timber.log.Timber

class BaseApplication : Application() , KodeinAware{

    override fun onCreate() {
        super.onCreate()
            Timber.plant(Timber.DebugTree())

    }
    override val kodein = Kodein.lazy {
        import(androidXModule(this@BaseApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { AppDataBase(instance()) }


    }
}