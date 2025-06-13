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
import com.example.internship1project.screens.dashboard.MyExpenseScreen
import com.example.internship1project.screens.dashboard.MyPaySlipsScreen
import com.example.internship1project.screens.dashboard.MyResignationScreen
import com.example.internship1project.screens.dashboard.TeamExpenseScreen
import com.example.internship1project.screens.dashboard.TeamResignationScreen
import com.example.internship1project.screens.drawer.MyHolidaysScreen
import com.example.internship1project.screens.drawer.MyTeamEmployeesScreen
import com.example.internship1project.screens.drawer.PolicyScreen
import java.security.Policy

enum class ABStartApp() {
    Splash,
    Dashboard
}


enum class DashboardAndDrawerScreens {
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
    TeamResignation,

    //Dashboard Floating Action Button
    DashboardFloatingActionButton,

    // drawer Screen unique items
    Policy,
    MyHolidays,
    MyTeamEmployees
}

enum class ScreenToScreen {
    HelpSupportToRaiseTicket
}

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
                            R.string.my_attendance -> DashboardAndDrawerScreens.MyAttendance.name
                            R.string.team_attendance -> DashboardAndDrawerScreens.TeamAttendance.name
                            R.string.my_regularization -> DashboardAndDrawerScreens.MyRegularization.name
                            R.string.team_regularization -> DashboardAndDrawerScreens.TeamRegularization.name
                            R.string.my_leaves -> DashboardAndDrawerScreens.MyLeaves.name
                            R.string.team_leaves -> DashboardAndDrawerScreens.TeamLeaves.name
                            R.string.my_expense -> DashboardAndDrawerScreens.MyExpense.name
                            R.string.team_expense -> DashboardAndDrawerScreens.TeamExpense.name
                            R.string.my_payslips -> DashboardAndDrawerScreens.MyPayslips.name
                            R.string.my_resignation -> DashboardAndDrawerScreens.MyResignation.name
                            R.string.team_resignation -> DashboardAndDrawerScreens.TeamResignation.name
                            else -> ABStartApp.Dashboard.name
                        }
                    )
                },
                onDrawerOptionClicked = { titleResId ->
                    navController.navigate(
                        when (titleResId) {
                            R.string.my_attendance -> DashboardAndDrawerScreens.MyAttendance.name
                            R.string.team_attendance -> DashboardAndDrawerScreens.TeamAttendance.name
                            R.string.my_regularization -> DashboardAndDrawerScreens.MyRegularization.name
                            R.string.team_regularization -> DashboardAndDrawerScreens.TeamRegularization.name
                            R.string.my_leaves -> DashboardAndDrawerScreens.MyLeaves.name
                            R.string.team_leaves -> DashboardAndDrawerScreens.TeamLeaves.name
                            R.string.my_expense -> DashboardAndDrawerScreens.MyExpense.name
                            R.string.team_expense -> DashboardAndDrawerScreens.TeamExpense.name
                            R.string.my_payslips -> DashboardAndDrawerScreens.MyPayslips.name
                            R.string.policy -> DashboardAndDrawerScreens.Policy.name
                            R.string.my_holidays -> DashboardAndDrawerScreens.MyHolidays.name
                            R.string.my_team_employees -> DashboardAndDrawerScreens.MyTeamEmployees.name
                            else -> ABStartApp.Dashboard.name
                        }
                    )
                },
                onFloatingActionButtonClicked = {
                    navController.navigate(DashboardAndDrawerScreens.DashboardFloatingActionButton.name)
                }
            )
        }


        // Help and Support Screen from Dashboard Floating Action Button

        composable(route= DashboardAndDrawerScreens.DashboardFloatingActionButton.name){
            HelpAndSupportScreen(
                navigateBack = { navController.popBackStack() },
                onRaiseTicketButtonClick = {
                    navController.navigate(ScreenToScreen.HelpSupportToRaiseTicket.name)
                }
            )
        }

        // Raise a Ticket Screen From Help and Support

        composable(route = ScreenToScreen.HelpSupportToRaiseTicket.name) {
            RaiseTicketScreen(
                navigateBack = {navController.popBackStack()}
            )
        }

        // Individual Screens
        composable(route = DashboardAndDrawerScreens.MyAttendance.name) {
            MyAttendanceScreen(
                navigateBack = { navController.navigateUp() },
            )
        }
        composable(route = DashboardAndDrawerScreens.TeamAttendance.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_attendance
            )
        }
        composable(route = DashboardAndDrawerScreens.MyRegularization.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.my_regularization
            )
        }
        composable(route = DashboardAndDrawerScreens.TeamRegularization.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_regularization
            )
        }
        composable(route = DashboardAndDrawerScreens.MyLeaves.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.my_leaves
            )
        }
        composable(route = DashboardAndDrawerScreens.TeamLeaves.name) {
            CommonScreen(
                navigateBack = { navController.navigateUp() },
                screenTitle = R.string.team_leaves
            )
        }
        composable(route = DashboardAndDrawerScreens.MyExpense.name) {
            MyExpenseScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.TeamExpense.name) {
            TeamExpenseScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.MyPayslips.name) {
            MyPaySlipsScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.MyResignation.name) {
            MyResignationScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.TeamResignation.name) {
            TeamResignationScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        // Navigation Drawer Unique Screens
        composable(route = DashboardAndDrawerScreens.Policy.name) {
            PolicyScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.MyHolidays.name) {
            MyHolidaysScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(route = DashboardAndDrawerScreens.MyTeamEmployees.name) {
            MyTeamEmployeesScreen(
                navigateBack = { navController.popBackStack()}
            )
        }
    }
}


