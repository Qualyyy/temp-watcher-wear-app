package com.qualy.tempwatcher.data

import android.content.Context

object SettingsRepositoryProvider {
    private var instance: SettingsRepository? = null

    fun init(context: Context) {
        if (instance == null) {
            instance = SettingsRepository(context)
        }
    }

    fun get(): SettingsRepository {
        return instance ?: throw IllegalStateException("SettingsRepositoryProvider not initialized")
    }
}