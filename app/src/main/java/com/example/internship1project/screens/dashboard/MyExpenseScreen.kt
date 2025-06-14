package com.example.internship1project.screens.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bed
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.LocalHotel
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship1project.R
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExpenseScreen(
    navigateBack: () -> Unit,
    onApplyExpenseButtonClick:() -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = Color(0xFF0a3579)
    val navigationBarColor = Color(0xFFe5f2fb)

    SideEffect {
        systemUiController.setStatusBarColor(color = statusBarColor)
        systemUiController.setNavigationBarColor(color = navigationBarColor)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = (stringResource(id = R.string.my_expense)),
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { navigateBack() }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black,
                        )
                    }
                },
                actions = {
                    Icon(
                        imageVector = Icons.Filled.Tune,
                        contentDescription = "App Logo",
                        tint = Color.Black,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            Button(
                onClick = {onApplyExpenseButtonClick()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                Text(
                    text = stringResource(R.string.expense_apply_expense_button)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        contentWindowInsets = WindowInsets.safeContent
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(8) {
                ExpenseDetailCard()
            }
        }
    }
}


@Composable
fun ExpenseDetailCard(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp)
            .border(1.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = modifier, verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Hotel,
                            contentDescription = stringResource(R.string.expense_accommodation),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                        Text(
                            text = stringResource(R.string.expense_accommodation),
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                    AppliedFilterChip()
                }// Row Ends Here

                Row(
                    modifier = Modifier
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.expense_date_label),
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                        Text(
                            text = "12-Jun-2025",
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }

                    Column(
                        modifier = Modifier.padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.expense_applied_date_label),
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                        Text(
                            text = "14-Jun-2025",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                // new row starts
                ExpenseAmountChip()
                // Description starts here
                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primary)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.expense_description),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                    IconButton(
                        onClick = { expanded = !expanded }
                    ) {

                        Icon(
                            if (expanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                            contentDescription = "Open or Close Description"
                        )
                    }
                }
                if (expanded) {
                    Text(
                        text = "I have dedicated myself to crafting a seamless and intuitive user experience, ensuring that every interaction feels natural and efficient. My approach goes beyond just functionality—I focus on creating an environment where users can navigate effortlessly, making complex tasks feel simple. Through meticulous attention to detail, I have refined UI elements to enhance accessibility and responsiveness, ensuring that every component serves a meaningful purpose.",
                        textAlign = TextAlign.Justify,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium)
                        )
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        CancelExpenseButton()
                    }
                }
            }
        }
    }
}

@Composable
fun AppliedFilterChip() {
    var selected by remember { mutableStateOf(true) }

    FilterChip(
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                text = "APPLIED",
                style = MaterialTheme.typography.labelMedium,
                fontSize = 10.sp
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            disabledContainerColor = MaterialTheme.colorScheme.tertiary,
            disabledLabelColor = MaterialTheme.colorScheme.onTertiary,
            selectedContainerColor = MaterialTheme.colorScheme.secondary,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondary
        ),
        modifier = Modifier.padding(8.dp)
    )
}


@Composable
fun ExpenseAmountChip() {

    FilterChip(
        selected = false,
        onClick = {},
        label = {
            Text(
                text = stringResource(R.string.expense_amount_label),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 10.sp
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(0.2f)
        ),
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun CancelExpenseButton() {

    FilterChip(
        selected = false,
        onClick = {},
        label = {
            Text(
                text = stringResource(R.string.expense_cancel),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Red.copy(0.8f)
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.Red.copy(0.2f)
        ),
        modifier = Modifier.padding(end = 8.dp)
    )
}


@Preview
@Composable
fun ExpensePreview() {
    Internship1ProjectTheme {
        MyExpenseScreen(
            navigateBack = {  },
            onApplyExpenseButtonClick = {}
        )
    }
}