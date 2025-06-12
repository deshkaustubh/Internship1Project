package com.example.internship1project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internship1project.composables.DashboardFloatingActionButton
import com.example.internship1project.composables.DashboardGrid
import com.example.internship1project.composables.DashboardPunchCard
import com.example.internship1project.composables.DashboardTopAppBar
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun DashboardScreen() {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color(0xFF0a3579)

    SideEffect {
        systemUiController.setStatusBarColor(color = statusBarColor)
    }
    Scaffold(
        topBar = { DashboardTopAppBar() },
        floatingActionButton = { DashboardFloatingActionButton() },
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets.safeContent
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            DashboardPunchCard()
            Spacer(modifier = Modifier.height(8.dp))
            DashboardGrid(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    Internship1ProjectTheme {
        DashboardScreen()
    }
}