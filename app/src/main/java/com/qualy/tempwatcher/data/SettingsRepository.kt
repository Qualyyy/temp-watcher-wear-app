package com.qualy.tempwatcher.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsRepository(context: Context) {

    private val appContext = context.applicationContext

    companion object {
        val IP_KEY = stringPreferencesKey("ip_address")
        val PORT_KEY = stringPreferencesKey("port")
    }

    val ipFlow: Flow<String> = appContext.dataStore.data.map { it[IP_KEY] ?: "192.168.0.1" }
    val portFlow: Flow<String> = appContext.dataStore.data.map { it[PORT_KEY] ?: "5208" }

    suspend fun saveIp(ip: String) {
        appContext.dataStore.edit { it[IP_KEY] = ip }
    }

    suspend fun savePort(port: String) {
        appContext.dataStore.edit { it[PORT_KEY] = port }
    }
}