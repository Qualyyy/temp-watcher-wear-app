package com.qualy.tempwatcher.presentation.components

import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.MaterialTheme

@Composable
fun TemperatureDisplay(
    label: String,
    temperature: Float?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(
            modifier = Modifier.height(4.dp)
        )

        Text(
            text = if (temperature == null) {
                "--"
            } else {
                "${temperature.toInt()}°C"
            },
            style = MaterialTheme.typography.displayLarge
        )
    }
}