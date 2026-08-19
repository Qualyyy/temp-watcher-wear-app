package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TemperatureDashboard(
    cpuTemperature: Float?,
    gpuTemperature: Float?
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TemperatureGauge(
            "CPU",
            cpuTemperature,
            Color(0xFF3B82F6),
            modifier = Modifier.weight(1f)
        )

        TemperatureGauge(
            "GPU",
            gpuTemperature,
            Color(0xFFF59E0B),
            modifier = Modifier.weight(1f)
        )
    }
}