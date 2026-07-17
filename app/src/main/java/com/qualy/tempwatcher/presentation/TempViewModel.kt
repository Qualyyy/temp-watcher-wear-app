package com.qualy.tempwatcher.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qualy.tempwatcher.data.PCStats
import com.qualy.tempwatcher.data.PCStatsApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TempViewModel : ViewModel() {

    private val api = PCStatsApi()

    private val _stats = MutableStateFlow<PCStats?>(null)
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

                    _stats.value = result

                } catch (e: Exception) {
                    println("API ERROR: ${e.message}")
                }

                delay(1000)
            }
        }
    }
}