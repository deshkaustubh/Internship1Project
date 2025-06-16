package com.example.internship1project.composables


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.internship1project.R
import com.example.internship1project.data.DataSource.navItems
import com.example.internship1project.ui.theme.Internship1ProjectTheme


@Composable
fun NavigationDrawer(
    onClickOfDrawerOption: (Int) -> Unit,
    onBackButtonPress: () -> Unit,
    modifier: Modifier = Modifier
) {


    ModalDrawerSheet {

        BackHandler(
            onBack = { onBackButtonPress() }
        )

        ProfileBox(modifier = modifier)

        HorizontalDivider(modifier = modifier)

        LazyColumn(modifier = modifier.weight(4f)) {
            items(navItems) { item ->
                NavigationDrawerItem(
                    icon = {
                        Icon(
                            item.icon,
                            contentDescription = stringResource(item.titleResId)
                        )
                    },
                    label = {
                        Text(
                            stringResource(item.titleResId),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    },
                    selected = false,
                    onClick = { onClickOfDrawerOption(item.titleResId) }
                )
            }
        }
        HorizontalDivider(modifier = modifier)

        LogoutButton(modifier = modifier.weight(1f))
    }
}


@Composable
fun LogoutButton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "App Version: 2.0.12", style = MaterialTheme.typography.labelLarge, fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .weight(1f), shape = RoundedCornerShape(8.dp), onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onSecondary,
                containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.8f),
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout"
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = "Logout", style = MaterialTheme.typography.labelLarge, fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun ProfileBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.kd_profile_image),
                    contentDescription = "Profile Icon",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp), contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                Column {
                    Text(
                        text = "Kaustubh Deshpande",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "SAN-github.com/DeshKaustubh",
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            ManagerRmAndEmpId()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            PunchBox()
        }
    }
}

@Composable
fun ManagerRmAndEmpId() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.SupervisorAccount,
                contentDescription = null, modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = "RM",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

        }
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
        Column {
            Text(
                text = "SAN-CTRLALTDEL",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 12.sp
            )

            Text(
                text = "Deshpande",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )

        }
    }
}

@Composable
fun PunchBox() {
    Card(
        shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = Color.DarkGray
        ), modifier = Modifier
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp))
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Punch In",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = "---:---",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }

            VerticalDivider(
                thickness = 2.dp,
                color = Color.Gray,
                modifier = Modifier
                    .height(50.dp) // Restrict height
                    .align(Alignment.CenterVertically) // Center the divider
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Punch Out",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                Text(
                    text = "---:---",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationDrawer() {
    Internship1ProjectTheme {
//        NavigationDrawer(drawerState = rememberDrawerState(initialValue = DrawerValue.Open))
//        LogoutButton()
    }
}
