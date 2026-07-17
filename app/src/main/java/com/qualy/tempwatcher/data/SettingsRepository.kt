package com.qualy.tempwatcher.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsRepository(private val context: Context) {

    companion object {
        val IP_KEY = stringPreferencesKey("ip_address")
        val PORT_KEY = stringPreferencesKey("port")
    }

    val ipFlow: Flow<String> = context.dataStore.data.map { it[IP_KEY] ?: "192.168.0.246" }
    val portFlow: Flow<String> = context.dataStore.data.map { it[PORT_KEY] ?: "5208" }

    suspend fun saveIp(ip: String) {
        context.dataStore.edit { it[IP_KEY] = ip }
    }

    suspend fun savePort(port: String) {
        context.dataStore.edit { it[PORT_KEY] = port }
    }
}