package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TemperatureDashboard(
    cpuTemperature: Float?,
    gpuTemperature: Float?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TemperatureDisplay(
            "CPU",
            cpuTemperature
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        TemperatureDisplay(
            "GPU",
            gpuTemperature
        )
    }
}