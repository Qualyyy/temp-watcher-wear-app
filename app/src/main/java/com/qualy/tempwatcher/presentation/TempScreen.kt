package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.qualy.tempwatcher.data.PCStats
import com.qualy.tempwatcher.presentation.components.CenteredText
import com.qualy.tempwatcher.presentation.components.TemperatureDashboard
import com.qualy.tempwatcher.presentation.components.TimeDisplay
import com.qualy.tempwatcher.presentation.models.TempViewModel


@Composable
fun TempScreen(
    viewModel: TempViewModel = viewModel()
) {

    val state by viewModel.stats.collectAsState()
    val currentTime = rememberCurrentTime()

    TempScreenContent(
        state = state,
        onRetry = viewModel::retry,
        currentTime = currentTime
    )
}

@Composable
fun TempScreenContent(
    state: TempUiState,
    onRetry: () -> Unit = {},
    currentTime: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        TimeDisplay(
            time = currentTime,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is TempUiState.Connecting -> {
                    Text("Connecting...")
                }

                is TempUiState.Success -> {
                    TemperatureDashboard(
                        cpuTemperature = state.stats.cpuTemperature,
                        gpuTemperature = state.stats.gpuTemperature
                    )
                }

                is TempUiState.Error -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Disconnected", style = MaterialTheme.typography.labelLarge)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = onRetry, modifier = Modifier.fillMaxWidth(.75f)) {
                            CenteredText("Retry")
                        }
                    }
                }
            }
        }
    }
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun TempScreenPreview() {
    TempScreenContent(
        state = TempUiState.Success(
            PCStats(
                cpuTemperature = 57f,
                gpuTemperature = 47f
            )
        ),
        currentTime = "14:37"
    )
}