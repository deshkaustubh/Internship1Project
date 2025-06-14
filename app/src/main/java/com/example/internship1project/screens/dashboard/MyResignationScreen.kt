package com.example.internship1project.screens.dashboard

import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyResignationScreen(
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
                        text = (stringResource(id = R.string.my_resignation)),
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
                            contentDescription = "Menu",
                            tint = Color.Black,
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            Button(
                onClick = {},
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
                    text = "Apply Resignation"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        contentWindowInsets = WindowInsets.safeContent
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ResignationDetailCard()
        }
    }
}


@Composable
fun ResignationDetailCard(modifier: Modifier = Modifier) {
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
                        Text(
                            text = "STATUS",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    AppliedFilterChip()
                }// Row Ends Here

                HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primary)

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {

                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Applied Date",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                        Text(
                            text = "27-May-2025",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Notice Period",
                            fontWeight = FontWeight.Light,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)))
                        Text(
                            text = "29 Days",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Official Relieving Date",
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

                    Row(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Requested Relieving Date",
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
                        text = "Attachment",
                        style = MaterialTheme.typography.labelLarge,
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

                val resignationLetter =
                    "Dear Bureaucratic Overlords,\n" +
                            "\n" +
                            "It is with a mix of bewilderment and relief that I hereby tender my resignation from any and all affiliations with the U.S. government. While I appreciate the opportunity to witness firsthand the inefficiency of terrestrial governance, I must inform you that I am moving on to bigger and better things—namely, Mars.\n" +
                            "\n" +
                            "Frankly, Earth is becoming a bit too predictable. Taxes? Boring. Regulations? Tedious. Congressional hearings? A tragic comedy. I have decided that my talents are better suited for interplanetary domination, where I can finally implement Tesla-powered space highways, Neuralink-enhanced diplomacy, and Dogecoin as the official Martian currency.\n" +
                            "\n" +
                            "Effective immediately, I will be shifting my focus to terraforming the Red Planet, where bureaucracy will be replaced with rock-paper-scissors decision-making, and the only law will be \"Don’t be lame.\"\n" +
                            "\n" +
                            "Please forward any remaining paperwork to Mars HQ, though I suspect it will take a few centuries to arrive.\n" +
                            "\n" +
                            "Sincerely,\n" +
                            "Elon \"I Make Rockets\" Musk\n" +
                            "CEO, SpaceX, Tesla, Neuralink, The Boring Company, Twitter (X), and soon… Mars\n" +
                            "\n" +
                            "P.S. If you need a ride off this planet, I’ll be launching a one-way ticket service soon. No refunds.\n" +
                            "\n" +
                            "(🚙 TESLA CYBERTRUCK-SHAPED SIGNATURE 🚙)\n" +
                            "\n" +
                            "        ______\n" +
                            "       /      \\__\n" +
                            "      |  🚀  🚀  |\n" +
                            "      |__________|\n" +
                            "     /_/|_|_|_|_|_\\\n" +
                            "\n" +
                            "\n" +
                            "T-minus 10... Bureaucracy disengaged.\n" +
                            "T-minus 9... Neuralink syncing brainwaves.\n" +
                            "T-minus 8... Tesla autopilot activated.\n" +
                            "T-minus 7... Dogecoin wallet secured.\n" +
                            "T-minus 6... Government regulations overridden.\n" +
                            "T-minus 5... Cybertruck loaded onto Starship.\n" +
                            "T-minus 4... Twitter (X) live-streaming departure.\n" +
                            "T-minus 3... Mars colony WiFi connected.\n" +
                            "T-minus 2... Final meme uploaded.\n" +
                            "T-minus 1... Ignition sequence start.\n" +
                            "🚀 LIFTOFF! Goodbye, Earth. Hello, Mars. 🚀"

                if (expanded) {

                    LazyColumn(modifier = Modifier.padding(16.dp)) {
                        items(1) {
                            Text(
                                text = "Sub: Resignation of Elon Musk (SAN-IMAKEROCKETS)",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = resignationLetter,
                                textAlign = TextAlign.Justify,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(
                                    start = dimensionResource(R.dimen.padding_medium),
                                    end = dimensionResource(R.dimen.padding_medium)
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        CancelResignationButton()
                    }
                }
            }
        }
    }
}

@Composable
fun CancelResignationButton() {

    FilterChip(
        selected = false,
        onClick = {},
        label = {
            Text(
                text = "Cancel Resignation",
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
fun ResignScreenPreview() {
    Internship1ProjectTheme {
        MyResignationScreen(
            navigateBack = {  }
        )
    }
}