package com.qualy.tempwatcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qualy.tempwatcher.data.PCStatsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TempViewModel : ViewModel() {

    private val api = PCStatsApi()

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
                    val result = api.getStats()

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