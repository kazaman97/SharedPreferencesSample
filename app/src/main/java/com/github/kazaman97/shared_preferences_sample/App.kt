package com.github.kazaman97.shared_preferences_sample

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferencesManager.createInstance(applicationContext)
    }
}
