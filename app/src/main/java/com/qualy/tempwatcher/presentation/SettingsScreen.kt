package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.ListHeader
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.qualy.tempwatcher.presentation.components.NumPadDialog
import com.qualy.tempwatcher.presentation.components.SettingsButton


@WearPreviewDevices
@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {

    val ip by viewModel.ip.collectAsState()
    val port by viewModel.port.collectAsState()
    val listState = rememberScalingLazyListState()

    var editingIp by remember { mutableStateOf(false) }
    var editingPort by remember { mutableStateOf(false) }

    when {
        editingIp -> {
            NumPadDialog(
                initialValue = ip,
                allowDot = true,
                onConfirm = { newValue ->
                    viewModel.updateIp(newValue)
                    editingIp = false
                },
                onDismiss = { editingIp = false }
            )
        }

        editingPort -> {
            NumPadDialog(
                initialValue = port,
                allowDot = false,
                onConfirm = { newValue ->
                    viewModel.updatePort(newValue)
                    editingPort = false
                },
                onDismiss = { editingPort = false }
            )
        }

        else -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                ScalingLazyColumn(state = listState) {
                    item { ListHeader { Text("Settings") } }

                    item {
                        SettingsButton(
                            title = "IP Address",
                            value = ip,
                            onClick = { editingIp = true }
                        )
                    }

                    item {
                        SettingsButton(
                            title = "Port",
                            value = port,
                            onClick = { editingPort = true }
                        )
                    }
                }
            }
        }
    }
}