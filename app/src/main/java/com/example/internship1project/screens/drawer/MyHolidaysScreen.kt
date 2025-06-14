package com.example.internship1project.screens.drawer

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship1project.R
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyHolidaysScreen(
    navigateBack: () -> Unit
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
                        text = (stringResource(id = R.string.my_holidays)),
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
                        onClick = {navigateBack()}
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Menu",
                            tint = Color.Black,
                        )
                    }
                },
            )
        },
        contentWindowInsets = WindowInsets.safeContent
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            , horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center
        ) {
            MyHolidaysScreenContent()
        }
    }
}


data class Holiday(val name: String, val month: String, val date: String, val type: String, val day: String)
@Composable
fun MyHolidaysScreenContent(modifier: Modifier = Modifier) {
    val statusBarColor = Color(0xFF0a3579)
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedTabIndex, modifier = Modifier.height(30.dp) .background(MaterialTheme.colorScheme.onPrimary), contentColor = statusBarColor, containerColor = MaterialTheme.colorScheme.onPrimary) {
                Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                    Text("Upcoming Holidays", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp), fontWeight = FontWeight.Medium)
                }
                Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                    Text("Past Holidays", fontSize = 18.sp, modifier = Modifier.padding(bottom = 8.dp), fontWeight = FontWeight.Medium)
                }
            }
        when (selectedTabIndex) {
            0 -> UpComingHolidayColumn()
            1 -> PastHolidayColumn()
        }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

@Composable
fun HolidayList(holidays: List<Holiday>, isEnabled: Boolean) {
    LazyColumn {
        items(holidays) { holiday ->
            HolidayItem(holiday, isEnabled)
        }
    }
}

@Composable
fun HolidayItem(holiday: Holiday, isEnabled: Boolean) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = if (isEnabled) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)),
        elevation = CardDefaults.cardElevation(if (isEnabled) 8.dp else 0.dp)
    ) {
        Row(modifier = Modifier.padding( 8.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .size(56.dp)
                .background(
                    color = if (isEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.5f
                    ), shape = RoundedCornerShape(4.dp)
                ), contentAlignment = Alignment.Center){
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(3.dp)) {
                    Text(text = holiday.month, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onPrimary)
                    Text(text = holiday.date, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onPrimary, fontSize = 32.sp)

                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = holiday.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (isEnabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(text = holiday.type, style = MaterialTheme.typography.labelMedium)
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    Text(text = "|", style = MaterialTheme.typography.labelMedium, color = Color.DarkGray)
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    Text(text = holiday.day, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
fun PastHolidayColumn() {

    val holidays = listOf(
        // **Holidays Before June 14, 2025**
        Holiday("New Year's Day", "JAN", "01", "Fixed Holiday", "Wednesday"),
        Holiday("Republic Day", "JAN", "26", "Fixed Holiday", "Sunday"),
        Holiday("Maha Shivratri", "MAR", "06", "Variable Holiday", "Thursday"),
        Holiday("Holi", "MAR", "25", "Variable Holiday", "Tuesday"),
        Holiday("Good Friday", "APR", "18", "Fixed Holiday", "Friday"),
        Holiday("Eid-ul-Fitr", "APR", "10", "Variable Holiday", "Thursday"),
        Holiday("Labour Day", "MAY", "01", "Fixed Holiday", "Thursday"),
        Holiday("Buddha Purnima", "MAY", "12", "Variable Holiday", "Monday"),
        Holiday("Eid-ul-Adha", "JUN", "17", "Variable Holiday", "Monday"),
    )

    val isEnabled by remember { mutableStateOf(false) }

    HolidayList(holidays, isEnabled)

    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun UpComingHolidayColumn() {

    val holidays = listOf(
        // **Holidays Before June 14, 2025**
        Holiday("Raksha Bandhan", "AUG", "19", "Variable Holiday", "Monday"),
        Holiday("Independence Day", "AUG", "15", "Fixed Holiday", "Thursday"),
        Holiday("Ganesh Chaturthi", "AUG", "27", "Fixed Holiday", "Wednesday"),
        Holiday("Gandhi Jayanti", "OCT", "02", "Fixed Holiday", "Wednesday"),
        Holiday("Dussehra", "OCT", "13", "Variable Holiday", "Monday"),
        Holiday("Diwali", "NOV", "01", "Variable Holiday", "Friday"),
        Holiday("Guru Nanak Jayanti", "NOV", "15", "Variable Holiday", "Friday"),
        Holiday("Christmas", "DEC", "25", "Fixed Holiday", "Wednesday")
    )

    val isEnabled by remember { mutableStateOf(true) }

    HolidayList(holidays, isEnabled)

    Spacer(modifier = Modifier.height(16.dp))

}

@Preview
@Composable
fun HolidayScreenPreview() {
    Internship1ProjectTheme {
        MyHolidaysScreen(
            navigateBack = {  }
        )
    }
}
