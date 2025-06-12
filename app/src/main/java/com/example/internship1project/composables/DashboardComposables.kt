package com.example.internship1project.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship1project.R
import com.example.internship1project.data.DataSource
import com.example.internship1project.ui.theme.Internship1ProjectTheme

/*
    Attendance
    My Attendance: event_available

    Team Attendance: group

    Regularization
    My Regularization: check_circle

    Team Regularization: verified

    Leaves
    My Leaves: beach_access

    Team Leaves: nature_people

    Expense
    My Expense: receipt_long

    Team Expense: attach_money

    Payslips
    My Payslips: description

    Resignation
    My Resignation: exit_to_app

    Team Resignation: supervisor_account
 */

@Composable
fun DashboardGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.dashboardOptions) { option ->
            DashboardOptionsCard(
                optionIcon = option.icon,
                optionIconColor = option.iconColor,
                optionText = option.textResId
            )
        }
    }
}


@Composable
fun DashboardOptionsCard(
    optionIcon: ImageVector,
    optionIconColor: Color,
    @StringRes optionText: Int,
    modifier: Modifier = Modifier
) {
    val paddingSmall = dimensionResource(R.dimen.padding_small)
    val paddingMedium = dimensionResource(R.dimen.padding_medium)
    val paddingLarge = dimensionResource(R.dimen.padding_large)

    Card(
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .padding(top = 2.dp, bottom = 2.dp, start = 3.dp, end = 1.dp)
            .width(247.dp)
            .height(144.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingSmall)
                .fillMaxSize()
        ) {
            Icon(
                imageVector = optionIcon,
                contentDescription = stringResource(optionText),
                tint = optionIconColor,
                modifier = Modifier
                    .width(53.dp)
                    .height(27.dp)
            )
            Spacer(modifier = Modifier.height(paddingMedium))
            Text(
                text = stringResource(id = optionText),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardComposablePreview() {
    Internship1ProjectTheme {
        DashboardGrid()
    }
}