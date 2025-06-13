package com.example.internship1project.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.internship1project.R
import com.example.internship1project.composables.CommonScreen
import com.example.internship1project.screens.dashboard.MyAttendanceScreen
import com.example.internship1project.screens.dashboard.MyPaySlipsScreen

enum class ABStartApp() {
    Splash,
    Dashboard
}


enum class DashboardScreens {
    Dashboard,
    MyAttendance,
    TeamAttendance,
    MyRegularization,
    TeamRegularization,
    MyLeaves,
    TeamLeaves,
    MyExpense,
    TeamExpense,
    MyPayslips,
    MyResignation,
    TeamResignation
}
//
//enum class DashboardScreens(val route: String) {
//    Dashboard("dashboard"),
//    MyAttendance("my_attendance"),
//    TeamAttendance("team_attendance"),
//    MyRegularization("my_regularization"),
//    TeamRegularization("team_regularization"),
//    MyLeaves("my_leaves"),
//    TeamLeaves("team_leaves"),
//    MyExpense("my_expense"),
//    TeamExpense("team_expense"),
//    MyPayslips("my_payslips"),
//    MyResignation("my_resignation"),
//    TeamResignation("team_resignation")
//}


@Composable
fun ABStartApp(navController: NavHostController = rememberNavController()) {

//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = backStackEntry?.destination?.route ?: ABStartApp.Splash.name

    NavHost(
        navController = navController,
        startDestination = ABStartApp.Splash.name,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(route = ABStartApp.Splash.name) {
            SplashScreen {
                navController.navigate(ABStartApp.Dashboard.name) {
                    popUpTo(ABStartApp.Splash.name) {
                        inclusive = true
                    } // Clears Splash Screen from back stack
                }
            }
        }

        composable(ABStartApp.Dashboard.name) {
            DashboardScreen(
                onCardClicked = { textResId ->
                    navController.navigate(
                        when (textResId) {
                            R.string.my_attendance -> DashboardScreens.MyAttendance.name
                            R.string.team_attendance -> DashboardScreens.TeamAttendance.name
                            R.string.my_regularization -> DashboardScreens.MyRegularization.name
                            R.string.team_regularization -> DashboardScreens.TeamRegularization.name
                            R.string.my_leaves -> DashboardScreens.MyLeaves.name
                            R.string.team_leaves -> DashboardScreens.TeamLeaves.name
                            R.string.my_expense -> DashboardScreens.MyExpense.name
                            R.string.team_expense -> DashboardScreens.TeamExpense.name
                            R.string.my_payslips -> DashboardScreens.MyPayslips.name
                            R.string.my_resignation -> DashboardScreens.MyResignation.name
                            R.string.team_resignation -> DashboardScreens.TeamResignation.name
                            else -> DashboardScreens.Dashboard.name
                        }
                    )
                }
            )
        }

        // Individual Screens
        composable(route = DashboardScreens.MyAttendance.name) {
            MyAttendanceScreen(
                navigateBack = { navController.navigateUp() },
            )
        }
        composable(route = DashboardScreens.TeamAttendance.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_attendance
            )
        }
        composable(route = DashboardScreens.MyRegularization.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.my_regularization
            )
        }
        composable(route = DashboardScreens.TeamRegularization.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_regularization
            )
        }
        composable(route = DashboardScreens.MyLeaves.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.my_leaves
            )
        }
        composable(route = DashboardScreens.TeamLeaves.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_leaves
            )
        }
//        composable(route = DashboardScreens.MyExpense.name) { MyExpenseScreen() }
//        composable(route = DashboardScreens.TeamExpense.name) { TeamExpenseScreen() }
        composable(route = DashboardScreens.MyPayslips.name) {
            MyPaySlipsScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
//        composable(route = DashboardScreens.MyResignation.name) { MyResignationScreen() }
//        composable(route = DashboardScreens.TeamResignation.name) { TeamResignationScreen() }
    }
}


