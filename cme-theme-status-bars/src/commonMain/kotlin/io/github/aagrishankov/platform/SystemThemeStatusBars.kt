package io.github.aagrishankov.platform

enum class SystemThemeStatusBars {
    DARK, LIGHT;
}

val SystemThemeStatusBars.isDark: Boolean
    get() = this == SystemThemeStatusBars.DARK
