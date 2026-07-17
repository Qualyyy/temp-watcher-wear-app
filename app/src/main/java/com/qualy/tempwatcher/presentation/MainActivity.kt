package com.qualy.tempwatcher.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.qualy.tempwatcher.data.SettingsRepositoryProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SettingsRepositoryProvider.init(applicationContext)

        setContent {
            TempPager()
        }
    }
}