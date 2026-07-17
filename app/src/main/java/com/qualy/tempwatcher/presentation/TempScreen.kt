package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material3.*
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.qualy.tempwatcher.data.PCStats
import com.qualy.tempwatcher.presentation.components.TemperatureDisplay


@Composable
fun TempScreen(
    viewModel: TempViewModel = viewModel()
) {

    val stats by viewModel.stats.collectAsState()

    TempScreenContent(
        stats = stats
    )
}

@Composable
fun TempScreenContent(
    stats: PCStats?
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TemperatureDisplay(
                "CPU",
                stats?.cpuTemperature
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            TemperatureDisplay(
                "GPU",
                stats?.gpuTemperature
            )
        }
    }
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun TempScreenPreview() {
    TempScreenContent(
        stats = PCStats(
            cpuTemperature = 57f,
            gpuTemperature = 47f
        )
    )
}