package com.hp.moviesapp_accubits

import android.app.Application
import androidx.databinding.library.BuildConfig
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
            Timber.plant(Timber.DebugTree())

    }
}