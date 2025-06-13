package com.example.internship1project.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.internship1project.R
import com.example.internship1project.data.DataSource
import com.example.internship1project.ui.theme.Internship1ProjectTheme
import kotlinx.coroutines.launch

// Complete Punch card with background gradients
@Composable
fun DashboardPunchCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
//                            Color(0xFF1E1E1E), // Dark top bar color
                            Color(0xFF1976D2), // Medium blue
                            Color(0xFF00AAFF),  // Light blue at the bottom
//                            Color(0xFF0057B7) // Deep blue transition
//                            Color(0xFF80D8FF) // Softer, pastel blue
                        )
                    )
                )
                .padding(end = 24.dp, start = 24.dp, bottom = 32.dp)
        ) {
            // Inner Box with Whitish-Blue Fading Effect
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                    .height(140.dp) // Adjust height as needed
                    .padding(top = 8.dp)
                    .align(Alignment.TopCenter) // Position over the gradient
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFEFEFEF).copy(alpha = 0.7f),  // Fades out at the bottom
                                Color(0xFFEFEFEF).copy(alpha = 0.5f), // Light whitish-blue at the top
                                Color(0xFFEFEFEF).copy(alpha = 0.3f) // Slightly deeper blue in the middle
                            )
                        )
                    )
                    .padding(top = 8.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
            ) {
                // main element -> Punch card
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 32.dp,
                                bottomEnd = 32.dp,
                                topStart = 1.dp,
                                topEnd = 1.dp
                            )
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFdaebfd)
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Thursday",
                                    fontSize = 13.sp,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Normal
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "12 Jun",
                                    fontSize = 14.sp,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "2025",
                                    fontSize = 10.sp,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontWeight = FontWeight.Light
                                )
                            }
                        Spacer(modifier = Modifier.width(20.dp))
                        Spacer(modifier = Modifier
                            .height(40.dp)
                            .background(color = Color(0xFFd8e5ee))
                            .padding(1.dp))
                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.onSecondary, containerColor = MaterialTheme.colorScheme.secondary),
                            elevation = ButtonDefaults.buttonElevation(13.dp),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(0.dp),
                        ) {
                            Text(
                                text = "PUNCH OUT",
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

    }
}


// top bar of the dashboard screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopAppBar(drawerState: DrawerState ) {
    val scope = rememberCoroutineScope()
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,//MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        title = {
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    "Hi, Kaustubh 👋🏼",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Text(
                    "Chief Pixel Pusher",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {scope.launch { drawerState.open() }}) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .width(28.dp)
                        .height(21.dp)
                )
            }
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.hrms_applogo),
                contentDescription = "App Logo",
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    )
}

// Support button - bottom right
@Composable
fun DashboardFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() } ,
        containerColor = MaterialTheme.colorScheme.tertiary,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Icon(
//                imageVector = Icons.Filled.SupportAgent,
                painter = painterResource(R.drawable.help_desk),
                contentDescription = "SUPPORT",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "SUPPORT", color = Color.White, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)
        }
    }
}

// Lazy Vertical Grid
@Composable
fun DashboardGrid(
    onCardClick : (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val lazyGridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = lazyGridState,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        items(DataSource.dashboardOptions, key = { it.textResId }) { option ->
            DashboardOptionCard(
                optionText = option.textResId,
                optionIcon = option.icon,
                onClick = {onCardClick(option.textResId)}
            )
        }
    }
}

// Option card element
@Composable
fun DashboardOptionCard(
    optionIcon: Int,
    @StringRes optionText: Int,
    onClick: ()-> Unit ,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(bottom = 8.dp, top = 8.dp)
            .width(140.dp)
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = {onClick()},
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Icon(
                painter = painterResource(id = optionIcon),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
//                    .width(46.dp)
//                    .height(44.dp)
                    .size(46.dp)
                    .padding(top = dimensionResource(R.dimen.padding_small))
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(optionText),
                fontSize = 10.sp,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding( bottom = 2.dp, start = 4.dp, end = 4.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun DashboardComposablePreview() {
    Internship1ProjectTheme {
//        DashboardOptionCard(
//            optionIcon = R.drawable.icon_1,
//            optionText = R.string.my_attendance
//        )
//        DashboardPunchCard()
//        DashboardGrid()
//        DashboardTopAppBar()
    }
}