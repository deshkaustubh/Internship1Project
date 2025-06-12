package com.example.internship1project.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import com.example.internship1project.R
import com.example.internship1project.model.DashboardOption

object DataSource {
    val dashboardOptions = listOf(
        DashboardOption(Icons.Filled.Event, Color(0xFF4CAF50), R.string.my_attendance), // Green
        DashboardOption(Icons.Filled.Groups, Color(0xFF03A9F4), R.string.team_attendance), // Blue
        DashboardOption(Icons.Filled.Edit, Color(0xFFFF9800), R.string.my_regularization), // Orange
        DashboardOption(Icons.Filled.List, Color(0xFF673AB7), R.string.team_regularization), // Deep Purple
        DashboardOption(Icons.Filled.DateRange, Color(0xFFE91E63), R.string.my_leaves), // Pink
        DashboardOption(Icons.Filled.People, Color(0xFF009688), R.string.team_leaves), // Teal
        DashboardOption(Icons.Filled.AttachMoney, Color(0xFFCDDC39), R.string.my_expense), // Lime
        DashboardOption(Icons.Filled.Money, Color(0xFFFF5722), R.string.team_expense), // Deep Orange
        DashboardOption(Icons.Filled.ReceiptLong, Color(0xFF9C27B0), R.string.my_payslips), // Purple
        DashboardOption(Icons.Filled.ExitToApp, Color(0xFF607D8B), R.string.my_resignation), // Blue Grey
        DashboardOption(Icons.Filled.WorkOff, Color(0xFF795548), R.string.team_resignation) // Brown
    )
}
