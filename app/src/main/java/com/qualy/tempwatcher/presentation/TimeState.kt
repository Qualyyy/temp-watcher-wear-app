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
            val now = LocalTime.now()

            value = now.format(formatter)

            // Wait until the start of the next minute
            val delayMillis =
                (60 - now.second) * 1_000L - now.nano / 1_000_000L

            delay(delayMillis)
        }
    }.value
}