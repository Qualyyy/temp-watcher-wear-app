package com.qualy.tempwatcher.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.Text
import kotlin.text.ifEmpty

@Composable
fun NumPadDialog(
    initialValue: String,
    allowDot: Boolean = true,
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var value by remember { mutableStateOf(initialValue) }

    val rows = listOf(
        listOf("1", "2", "3"),
        listOf("4", "5", "6"),
        listOf("7", "8", "9"),
        listOf(if (allowDot) "." else "", "0", "⌫")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 6.dp, start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = value.ifEmpty { "-" },
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(0.8f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                rows.forEach { rowKeys ->
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        rowKeys.forEach { key ->
                            if (key.isEmpty()) {
                                Spacer(modifier = Modifier.weight(1f))
                            } else {
                                Button(
                                    onClick = {
                                        value = when (key) {
                                            "⌫" -> value.dropLast(1)
                                            "." -> if (value.contains(".")) value else value + key
                                            else -> value + key
                                        }
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()

                                ) {
                                    Text(key)
                                }
                            }
                        }
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(.25f)
            ) {
                Button(onClick = onDismiss) { Text("Cancel") }
                Button(onClick = { onConfirm(value) }) { Text("OK") }
            }
        }
    }
}