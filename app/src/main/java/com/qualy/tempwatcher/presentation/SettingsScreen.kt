package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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

            }

            item {
                Button(
                    onClick = {
                        // Open IP input
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        """
                        IP Address
                        192.168.0.246
                        """.trimIndent()
                    )
                }
            }

            item {
                Button(
                    onClick = {
                        // Open port input later
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        """
                    Port
                    5208
                    """.trimIndent()
                    )
                }
            }
        }
    }
}