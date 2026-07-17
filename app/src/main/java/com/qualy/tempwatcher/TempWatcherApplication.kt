package com.qualy.tempwatcher

import android.app.Application
import com.qualy.tempwatcher.data.SettingsRepository

class TempWatcherApplication : Application() {

    lateinit var settingsRepository: SettingsRepository
        private set

    override fun onCreate() {
        super.onCreate()
        settingsRepository = SettingsRepository(this)
    }
}