package com.qualy.tempwatcher.presentation.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.qualy.tempwatcher.TempWatcherApplication
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val settingsRepository = (application as TempWatcherApplication).settingsRepository

    val ip = settingsRepository.ipFlow.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), "192.168.0.246"
    )
    val port = settingsRepository.portFlow.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), "5208"
    )

    fun updateIp(newIp: String) = viewModelScope.launch { settingsRepository.saveIp(newIp) }
    fun updatePort(newPort: String) = viewModelScope.launch { settingsRepository.savePort(newPort) }
}