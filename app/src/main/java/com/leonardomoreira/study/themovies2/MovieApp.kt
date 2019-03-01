package com.leonardomoreira.study.themovies2

import android.app.Application
import com.facebook.stetho.Stetho
import com.leonardomoreira.study.themovies2.di.appModule
import com.verizonconnect.fsdapp.BuildConfig
import org.koin.android.ext.android.startKoin

class MovieApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}