package com.qualy.tempwatcher.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.qualy.tempwatcher.TempWatcherApplication
import com.qualy.tempwatcher.data.PCStatsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TempViewModel(application: Application) : AndroidViewModel(application) {

    private val api = PCStatsApi()
    private val settingsRepository = (application as TempWatcherApplication).settingsRepository

    private val _stats = MutableStateFlow<TempUiState>(
        TempUiState.Connecting
    )

    val stats = _stats.asStateFlow()

    init {
        startUpdating()
    }

    private fun startUpdating() {
        viewModelScope.launch {
            while (isActive) {
                try {
                    val ip = settingsRepository.ipFlow.first()
                    val port = settingsRepository.portFlow.first()

                    val result = api.getStats(ip, port)

                    println("Received: CPU=${result.cpuTemperature}, GPU=${result.gpuTemperature}")

                    _stats.value = TempUiState.Success(result)

                } catch (e: Exception) {
                    _stats.value = TempUiState.Error(
                        e.message ?: "Unknown error"
                    )
                }

                delay(1000)
            }
        }
    }
}