package io.github.aagrishankov.platform

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

val LocalThemeStatusBars = compositionLocalOf {
    mutableStateOf(PreRenderCurrentThemeStatusBars.activeTheme)
}
