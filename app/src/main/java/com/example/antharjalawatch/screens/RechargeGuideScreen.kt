package com.example.antharjalawatch.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RechargeGuideScreen(
    navController: NavController
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        TopAppBar(

            title = {
                Text(
                    text = "Recharge Guide",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            },

            navigationIcon = {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF1565C0)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        RechargeCard(
            title = "1. Rainwater Harvesting",
            description = "Collect and store rainwater from rooftops.",
            emoji = "💧"
        )

        RechargeCard(
            title = "2. Recharge Pit",
            description = "Allow rainwater to seep into the ground.",
            emoji = "🪣"
        )

        RechargeCard(
            title = "3. Percolation Tank",
            description = "Store rainwater and increase groundwater.",
            emoji = "🏞️"
        )

        RechargeCard(
            title = "4. Save Water",
            description = "Save water today for better tomorrow.",
            emoji = "💦"
        )
    }
}

@Composable
fun RechargeCard(
    title: String,
    description: String,
    emoji: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),

        shape = RoundedCornerShape(16.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = emoji,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(
                    text = title,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    color = Color.DarkGray
                )
            }
        }
    }
}