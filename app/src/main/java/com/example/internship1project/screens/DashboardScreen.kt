package com.example.internship1project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internship1project.R
import com.example.internship1project.composables.DashboardFloatingActionButton
import com.example.internship1project.composables.DashboardGrid
import com.example.internship1project.composables.DashboardPunchCard
import com.example.internship1project.composables.DashboardTopAppBar
import com.example.internship1project.composables.NavigationDrawer
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(onCardClicked: (Int) -> Unit, onDrawerOptionClicked: (Int) -> Unit, onFloatingActionButtonClicked:()-> Unit, navigateBack:()-> Unit ) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color(0xFF0a3579)
    val navigationBarColor = Color(0xFFe5f2fb)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .width(if (drawerState.isOpen) 280.dp else 0.dp) // Partial width initially
            ) {
                NavigationDrawer(
                    onClickOfDrawerOption = { optionId ->
                        onDrawerOptionClicked(optionId)
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
                    onBackButtonPress = { navigateBack() }
                )
            }
        }, drawerState = drawerState
    ) {
        SideEffect {
            systemUiController.setStatusBarColor(color = statusBarColor)
            systemUiController.setNavigationBarColor(color = navigationBarColor)
        }
        Scaffold(
            topBar = { DashboardTopAppBar(drawerState) },
            floatingActionButton = {
                DashboardFloatingActionButton(
                    onClick = { onFloatingActionButtonClicked() }
                )
            },
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
                    onCardClick = onCardClicked,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    Internship1ProjectTheme {
//        DashboardScreen()
    }
}