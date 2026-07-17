package com.qualy.tempwatcher.data

import kotlinx.serialization.Serializable

@Serializable
data class PCStats(
    val cpuTemperature: Float,
    val gpuTemperature: Float
)