package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.Text

@Composable
fun SettingsButton(
    title: String,
    value: String
) {
    Button(
        onClick = {
            // Open IP input
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(title)
            Text(value)
        }
    }
}