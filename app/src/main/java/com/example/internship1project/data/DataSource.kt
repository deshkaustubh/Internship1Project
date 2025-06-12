package com.example.internship1project.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import com.example.internship1project.R
import com.example.internship1project.model.DashboardOption

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
}
