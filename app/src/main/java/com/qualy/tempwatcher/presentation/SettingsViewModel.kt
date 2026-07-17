package com.qualy.tempwatcher.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.qualy.tempwatcher.data.SettingsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = SettingsRepository(application)

    val ip = repository.ipFlow.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        "192.168.0.246"
    )
    val port =
        repository.portFlow.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "5208")

    fun updateIp(newIp: String) = viewModelScope.launch { repository.saveIp(newIp) }
    fun updatePort(newPort: String) = viewModelScope.launch { repository.savePort(newPort) }
}