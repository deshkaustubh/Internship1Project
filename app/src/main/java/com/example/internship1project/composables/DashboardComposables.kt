package com.example.internship1project.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internship1project.R
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
fun DashboardOptionsCard(
//    icon: Int,
//    optionText: String
) {
    val paddingSmall = dimensionResource(R.dimen.padding_small)
    val paddingMedium = dimensionResource(R.dimen.padding_medium)
    val paddingLarge = dimensionResource(R.dimen.padding_large)

    Card(
        modifier = Modifier,
        onClick = {},
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(paddingLarge)
        ) {
            Icon(
                imageVector = Icons.Filled.EventAvailable,
                contentDescription = null,
                tint = Color.Blue
            )
            Spacer(modifier = Modifier.height(paddingSmall))
            Text("My Attendance" , style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DashboardComposablePreview() {
    Internship1ProjectTheme {

        DashboardOptionsCard()
    }
}