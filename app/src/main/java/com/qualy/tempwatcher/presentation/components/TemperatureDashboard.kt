package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TemperatureDashboard(
    cpuTemperature: Float?,
    gpuTemperature: Float?
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TemperatureGauge(
            label = "CPU",
            temperature = cpuTemperature,
            indicatorColor = Color(0xFF3B82F6),
            modifier = Modifier.weight(1f)
        )

        TemperatureGauge(
            label = "GPU",
            temperature = gpuTemperature,
            indicatorColor = Color(0xFFF59E0B),
            modifier = Modifier.weight(1f)
        )
    }
}