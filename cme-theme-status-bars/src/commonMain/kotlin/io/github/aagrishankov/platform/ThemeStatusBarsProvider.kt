package io.github.aagrishankov.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue

@Composable
internal fun ThemeStatusBarsProvider(
    onChangeSystemBarsTheme: (Boolean) -> Unit,
    content: @Composable () -> Unit,
) {
    val currentTheme by LocalThemeStatusBars.current
    LaunchedEffect(currentTheme) {
        onChangeSystemBarsTheme(currentTheme.isDark)
    }
    content()
}
