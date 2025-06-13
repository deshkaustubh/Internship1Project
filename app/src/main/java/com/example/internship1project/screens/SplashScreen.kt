package com.example.internship1project.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.internship1project.R
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }
    val density = LocalDensity.current

    LaunchedEffect(Unit) {
        delay(500) // Start animation after 500ms
        isVisible = true
        delay(2000) // Show splash for 2 seconds
        navController.navigate("home") // Navigate to main screen
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF87CEEB)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

                Image(
                    painter = painterResource(id = R.drawable.splash_screen_abstart_trademark),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .size(400.dp)
                )

            AnimatedVisibility(
                visible = isVisible,
                enter = slideInVertically { with(density) { -40.dp.roundToPx() } } +
                        expandVertically(expandFrom = Alignment.Top) +
                        fadeIn(initialAlpha = 0.3f),
                exit = slideOutVertically() +
                        shrinkVertically() +
                        fadeOut()

                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ColorText(
                        textFirst = "YOUR",
                        textFirstColor = MaterialTheme.colorScheme.onPrimary,
                        emptySpace = " ",
                        textSecond = "DIGITAL",
                        textSecondColor = MaterialTheme.colorScheme.primary,
                        fontSize = 50.sp
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                    ColorText(
                        textFirst = "HR",
                        textFirstColor = MaterialTheme.colorScheme.primary,
                        emptySpace = " ",
                        textSecond = "PARTNER",
                        textSecondColor = MaterialTheme.colorScheme.onPrimary,
                        fontSize = 40.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ColorText(
    textFirst: String,
    textSecond: String,
    emptySpace: String,
    textFirstColor: Color,
    textSecondColor: Color,
    fontSize: TextUnit
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = textFirstColor, shadow = Shadow(
                        color = Color.Gray, // Shadow color
                        offset = Offset(4f, 4f), // X and Y offset
                        blurRadius = 8f // Blur effect
                    )
                )
            ) {
                append(textFirst)
            }
            append(emptySpace)
            withStyle(
                style = SpanStyle(
                    color = textSecondColor, shadow = Shadow(
                        color = Color.Gray, // Shadow color
                        offset = Offset(4f, 4f), // X and Y offset
                        blurRadius = 8f // Blur effect
                    )
                )
            ) {
                append(textSecond)
            }
        },
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Preview()
@Composable
fun SplashPreview() {
    Internship1ProjectTheme {
        SplashScreen(navController = rememberNavController())
    }
}

