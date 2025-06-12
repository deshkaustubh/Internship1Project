package com.example.internship1project.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val PrimaryLight = Color(0xFFEBEDF2)
val OnPrimaryLight = Color(0xFF0F1417)
val PrimaryDark = Color(0xFF2B3640)
val OnPrimaryDark = Color(0xFFFFFFFF)

// Secondary Colors
val Secondary = Color(0xFFFAFAFA)
val OnSecondary = Color(0xFF5C738A)
val SecondaryDark = Color(0xFF1F262E)
val OnSecondaryDark = Color(0xFF9EADBF)


// Background & Surface
val Background = Color(0xFFFFFFF2)
val BackgroundDark = Color(0xFF141A1F)
val OnBackground = Color(0xFF0F1417)
val OnBackgroundDark= Color(0xFFFFFFFF)
val Surface = Color(0xFFFAFAFA)
val SurfaceDark = Color(0xFF1F262E)
val OnSurface = Color(0xFFFAFAFA)
val OnSurfaceDark = Color(0xFF9EADBF)



private val LightColorScheme = lightColorScheme(

    primary = PrimaryLight,
    secondary = Secondary,
    tertiary = Pink80,
    surface = Surface,
    background = Background,

    onPrimary = OnPrimaryLight,
    onSecondary = OnSecondary,
    onSurface = OnSurface,
    onBackground = OnBackground

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

private val DarkColorScheme = darkColorScheme(

    primary = PrimaryDark,
    secondary = SecondaryDark,
    tertiary = Pink40,
    background = BackgroundDark,
    surface = SurfaceDark,

    onPrimary = OnPrimaryDark,
    onSecondary = OnSecondaryDark,
    onSurface = OnSurfaceDark,
    onBackground = OnBackgroundDark,
)

@Composable
fun Internship1ProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}