package com.ajdamiao.parkspot

import android.app.Application
import com.ajdamiao.dalabolt.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ParkSpotApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ParkSpotApp)
            modules(mainModule)
        }
    }
}