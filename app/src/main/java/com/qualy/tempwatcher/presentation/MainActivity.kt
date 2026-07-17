/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package com.qualy.tempwatcher.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import com.qualy.tempwatcher.presentation.theme.TempWatcherTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.isActive
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    private var cpuTemperature by mutableStateOf(0f)
    private var gpuTemperature by mutableStateOf(0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = PCStatsApi()

        lifecycleScope.launch {
            while (isActive) {
                try {
                    val stats = api.getStats()

                    cpuTemperature = stats.cpuTemperature
                    gpuTemperature = stats.gpuTemperature

                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }

                delay(1000.milliseconds)
            }
        }

        setContent {
            WearApp(cpuTemperature, gpuTemperature)
        }
    }
}

@Composable
fun WearApp(cpuTemperature: Float, gpuTemperature: Float) {
    TempWatcherTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CPU: ${cpuTemperature.toInt()}°C\nGPU: ${gpuTemperature.toInt()}°C"
            )
        }
    }
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun DefaultPreview() {
    WearApp(0f, 0f)
}