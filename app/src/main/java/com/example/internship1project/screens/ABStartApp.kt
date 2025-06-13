package com.example.internship1project.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class ABStartApp() {
    Splash,
    Dashboard
}


@Composable
fun ABStartApp(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = backStackEntry?.destination?.route ?: ABStartApp.Splash.name

    NavHost(
        navController = navController,
        startDestination = ABStartApp.Splash.name,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(route = ABStartApp.Splash.name) {
            SplashScreen {
                navController.navigate(ABStartApp.Dashboard.name) {
                    popUpTo(ABStartApp.Splash.name) { inclusive = true } // Clears Splash Screen from back stack
                }
            }
        }

        composable(ABStartApp.Dashboard.name) {
            DashboardScreen()
          }
    }
}