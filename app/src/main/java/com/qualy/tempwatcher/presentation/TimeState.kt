package com.qualy.tempwatcher.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun rememberCurrentTime(): String {
    val formatter = remember {
        DateTimeFormatter.ofPattern("HH:mm")
    }

    return produceState(
        initialValue = LocalTime.now().format(formatter)
    ) {
        while (true) {
            value = LocalTime.now().format(formatter)
            delay(1_000)
        }
    }.value
}