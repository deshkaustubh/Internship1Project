package com.example.internship1project.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import com.example.internship1project.R
import com.example.internship1project.model.DashboardOption
import com.example.internship1project.model.NavItem

object DataSource {
    val dashboardOptions = listOf(
        DashboardOption(R.drawable.icon_1, R.string.my_attendance), // Green
        DashboardOption(R.drawable.icon_2, R.string.team_attendance), // Blue
        DashboardOption(R.drawable.icon_3, R.string.my_regularization), // Orange
        DashboardOption(R.drawable.icon_4, R.string.team_regularization), // Deep Purple
        DashboardOption(R.drawable.icon_5, R.string.my_leaves), // Pink
        DashboardOption(R.drawable.icon_6, R.string.team_leaves), // Teal
        DashboardOption(R.drawable.icon_7, R.string.my_expense), // Lime
        DashboardOption(R.drawable.icon_8, R.string.team_expense), // Deep Orange
        DashboardOption(R.drawable.icon_9, R.string.my_payslips), // Purple
        DashboardOption(R.drawable.icon_10, R.string.my_resignation), // Blue Grey
        DashboardOption(R.drawable.icon_11, R.string.team_resignation) // Brown
    )

    // Navigation Drawer
    val navItems = listOf(
        NavItem(R.string.policy, Icons.Filled.Description),
        NavItem(R.string.my_holidays, Icons.Filled.Event),
        NavItem(R.string.my_attendance, Icons.Filled.CheckCircle),
        NavItem(R.string.team_attendance, Icons.Filled.Group),
        NavItem(R.string.my_team_employees, Icons.Filled.Work),
        NavItem(R.string.my_regularization, Icons.Filled.Schedule),
        NavItem(R.string.team_regularization, Icons.Filled.List),
        NavItem(R.string.my_leaves, Icons.Filled.BeachAccess),
        NavItem(R.string.team_leaves, Icons.Filled.AirplaneTicket),
        NavItem(R.string.my_payslips, Icons.Filled.AttachMoney),
        NavItem(R.string.my_expense, Icons.Filled.Receipt),
        NavItem(R.string.team_expense, Icons.Filled.AccountBalance)
    )
}
