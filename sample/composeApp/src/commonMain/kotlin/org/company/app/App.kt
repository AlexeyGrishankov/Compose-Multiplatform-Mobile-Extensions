package org.company.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.aagrishankov.platform.LocalThemeStatusBars
import io.github.aagrishankov.platform.SystemThemeStatusBars.DARK
import io.github.aagrishankov.platform.SystemThemeStatusBars.LIGHT
import io.github.aagrishankov.platform.isDark

@Composable
internal fun App() {
    var theme by LocalThemeStatusBars.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (theme.isDark) Color.Black else Color.White)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .background(if (!theme.isDark) Color.Black else Color.White)
                .clickable { theme = if (theme.isDark) LIGHT else DARK }
                .padding(16.dp),
        ) {
            Text(
                text = "Change Theme",
                color = if (theme.isDark) Color.Black else Color.White,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Status Bars is ${if (theme.isDark) "Light" else "Dark"}",
            color = if (!theme.isDark) Color.Black else Color.White,
        )
    }
}
