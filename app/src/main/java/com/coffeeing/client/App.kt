package com.coffeeing.client

import android.app.Application
import com.coffeeing.client.util.CoffeeingDebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(CoffeeingDebugTree())
    }
}