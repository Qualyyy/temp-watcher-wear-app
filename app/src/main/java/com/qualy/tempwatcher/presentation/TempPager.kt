package com.qualy.tempwatcher.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TempPager() {

    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = { 2 }
    )

    HorizontalPager(
        state = pagerState
    ) { page ->

        when (page) {
            0 -> SettingsScreen()
            1 -> TempScreen()
        }
    }
}