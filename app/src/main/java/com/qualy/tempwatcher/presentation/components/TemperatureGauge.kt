package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.wear.compose.material3.CircularProgressIndicator
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.ProgressIndicatorDefaults
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices

@Composable
fun TemperatureGauge(
    label: String,
    temperature: Float?,
    indicatorColor: Color,
    modifier: Modifier = Modifier
) {
    val progress = (temperature?.div(100f) ?: 0f).coerceIn(0f, 1f)
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier.matchParentSize(),
            colors = ProgressIndicatorDefaults.colors(
                indicatorColor = indicatorColor,
                trackColor = Color(0xFF17181A)
            )
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )

            Text(
                text = if (temperature == null) {
                    "--"
                } else {
                    "${temperature.toInt()}°"
                },
                style = MaterialTheme.typography.displayMedium.copy(
                    fontFamily = FontFamily.Monospace
                )
            )
        }
    }
}

@WearPreviewDevices
@Composable
fun TemperatureGaugePreview() {
    TemperatureGauge(
        label = "CPU",
        temperature = 55f,
        indicatorColor = Color(0xFF3B82F6)
    )
}