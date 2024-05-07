@file:Suppress("FunctionName")

package io.github.aagrishankov.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun StatusBarsProviderUIViewController(
    content: @Composable () -> Unit,
): UIViewController = StatusBarsProviderUIViewController().apply {
    setContentThemeWithStatusBars { content() }
}

internal fun StatusBarsProviderUIViewController.setContentThemeWithStatusBars(
    content: @Composable () -> Unit,
) {
    childComposeViewController = ComposeUIViewController {
        ThemeStatusBarsProvider(
            onChangeSystemBarsTheme = ::changeThemeStatusBar,
            content = content,
        )
    }
}

internal fun StatusBarsProviderUIViewController.changeThemeStatusBar(isDark: Boolean) {
    this.isDark = isDark
    setNeedsStatusBarAppearanceUpdate()
}
