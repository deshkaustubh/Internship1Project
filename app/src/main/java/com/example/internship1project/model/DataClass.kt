package com.example.internship1project.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class DashboardOption(
    val icon: ImageVector,
    val iconColor: Color,
    @StringRes val textResId: Int
)
