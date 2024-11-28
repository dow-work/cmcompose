package com.dow.cmcompose.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun changeToColumInGrid(): Int {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    return when {
        screenWidth < 320 -> 2 // small device 2
        screenWidth < 440 -> 3 // medium 3
        screenWidth < 630 -> 4 // large 4
        else -> 5 // x-large 5
    }
}

@Composable
fun changeToHeaderSliderHeight(): Int {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    return when {
        screenWidth < 320 -> 220 // small device 2
        screenWidth < 440 -> 320 // medium 3
        screenWidth < 630 -> 420 // large 4
        else -> 520 // x-large 5
    }
}
