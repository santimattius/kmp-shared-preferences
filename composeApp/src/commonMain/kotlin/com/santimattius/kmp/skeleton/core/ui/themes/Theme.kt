package com.santimattius.kmp.skeleton.core.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.santimattius.kmp.entertainment.core.ui.themes.Pink40
import com.santimattius.kmp.entertainment.core.ui.themes.Pink80
import com.santimattius.kmp.entertainment.core.ui.themes.Purple40
import com.santimattius.kmp.entertainment.core.ui.themes.Purple80
import com.santimattius.kmp.entertainment.core.ui.themes.PurpleGrey40
import com.santimattius.kmp.entertainment.core.ui.themes.PurpleGrey80
import com.santimattius.kmp.entertainment.core.ui.themes.Typography

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    onPrimary = Color.White,
    background = Color.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}