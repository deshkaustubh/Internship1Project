package com.example.internship1project.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.internship1project.R
import com.example.internship1project.composables.NavigationDrawer
import com.example.internship1project.composables.ProfileBox
import com.example.internship1project.model.NavItem
import com.example.internship1project.ui.theme.Internship1ProjectTheme


@Composable
fun NavDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            NavigationDrawer(
                drawerState = drawerState,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }, drawerState = drawerState
    ) {
        DashboardScreen()
    }
}

@Preview()
@Composable
fun DrawerPreview() {
    Internship1ProjectTheme {
        NavDrawer()
    }
}