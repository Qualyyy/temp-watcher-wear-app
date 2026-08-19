package com.qualy.tempwatcher.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices

@Composable
fun TimeDisplay(
    time: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = time,
        color = Color.LightGray,
        style = MaterialTheme.typography.labelLarge.copy(
            fontFamily = FontFamily.Monospace
        )
    )
}

@WearPreviewDevices
@Composable
fun TimeDisplayPreview() {
    TimeDisplay(time = "14:37")
}