package com.cme.platform

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

val LocalThemeStatusBars = compositionLocalOf {
    mutableStateOf(PreRenderCurrentThemeStatusBars.activeTheme)
}
