package com.cme.platform

enum class SystemThemeStatusBars {
    DARK, LIGHT;
}

val SystemThemeStatusBars.isDark: Boolean
    get() = this == SystemThemeStatusBars.DARK
