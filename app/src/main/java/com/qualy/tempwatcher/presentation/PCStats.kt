package com.qualy.tempwatcher.presentation

import kotlinx.serialization.Serializable

@Serializable
data class PCStats(
    val cpuTemperature: Float,
    val gpuTemperature: Float
)