package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material3.Text

@Composable
fun TempScreen(
    viewModel: TempViewModel = viewModel()
) {

    val stats by viewModel.stats.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = if (stats == null) {
                "Connecting..."
            } else {
                """
                CPU: ${stats!!.cpuTemperature.toInt()}°C
                GPU: ${stats!!.gpuTemperature.toInt()}°C
                """.trimIndent()
            }
        )
    }
}