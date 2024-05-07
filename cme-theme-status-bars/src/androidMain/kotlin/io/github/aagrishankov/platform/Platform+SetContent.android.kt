package io.github.aagrishankov.platform

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat

fun ComponentActivity.setContentThemeWithStatusBars(
    content: @Composable () -> Unit,
) {
    changeThemeStatusBar(PreRenderCurrentThemeStatusBars.activeTheme.isDark)
    setContent {
        ThemeStatusBarsProvider(
            onChangeSystemBarsTheme = ::changeThemeStatusBar,
            content = content,
        )
    }
}

internal fun Activity.changeThemeStatusBar(isDark: Boolean) {
    val window = this.window
    WindowCompat.getInsetsController(window, window.decorView).apply {
        isAppearanceLightStatusBars = !isDark
        isAppearanceLightNavigationBars = !isDark
    }
}
