package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ListHeader
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.qualy.tempwatcher.presentation.components.SettingsButton


@WearPreviewDevices
@Composable
fun SettingsScreen() {

    val listState = rememberScalingLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        ScalingLazyColumn(
            state = listState
        ) {

            item {
                ListHeader {
                    Text("Settings")
                }
            }

            item {
                SettingsButton(
                    title = "IP Address",
                    value = "192.168.0.246"
                )
            }

            item {
                SettingsButton(
                    title = "Port",
                    value = "5208"
                )
            }
        }
    }
}