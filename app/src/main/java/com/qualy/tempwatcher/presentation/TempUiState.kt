package com.qualy.tempwatcher.presentation

import com.qualy.tempwatcher.data.PCStats

sealed interface TempUiState {
    data object Connecting : TempUiState

    data class Success(
        val stats: PCStats
    ) : TempUiState

    data class Error(
        val message: String
    ) : TempUiState
}