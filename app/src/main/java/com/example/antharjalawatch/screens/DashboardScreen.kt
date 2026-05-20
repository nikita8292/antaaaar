package com.example.antharjalawatch.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.WaterDrop

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController

data class DashboardItem(

    val title: String,
    val icon: ImageVector,
    val route: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavController
){

    val dashboardItems = listOf(

        DashboardItem(
            title = "Borewell Log",
            icon = Icons.Default.AddLocation,
            route = "borewell_log"
        ),

        DashboardItem(
            title = "Water Map",
            icon = Icons.Default.Map,
            route = "water_map"
        ),

        DashboardItem(
            title = "Recharge Guide",
            icon = Icons.Default.WaterDrop,
            route = "recharge_guide"
        ),

        DashboardItem(
            title = "Alerts",
            icon = Icons.Default.Notifications,
            route = "alerts"
        )
    )

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(
                        text = "Anthar-Jala Watch",
                        color = Color.White
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0)
                )
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF5F5F5))

        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(

                text = "Groundwater Monitoring System",

                modifier = Modifier.padding(start = 16.dp),

                style = MaterialTheme.typography.titleMedium,

                fontWeight = FontWeight.Bold,

                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(

                columns = GridCells.Fixed(2),

                contentPadding = PaddingValues(12.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp),

                horizontalArrangement = Arrangement.spacedBy(12.dp)

            ) {

                items(dashboardItems) { item ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                            .clickable {

                                navController.navigate(item.route)
                            },

                        shape = RoundedCornerShape(20.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        )

                    ) {

                        Column(

                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),

                            horizontalAlignment = Alignment.CenterHorizontally,

                            verticalArrangement = Arrangement.Center

                        ) {

                            Icon(

                                imageVector = item.icon,

                                contentDescription = item.title,

                                tint = Color(0xFF1565C0),

                                modifier = Modifier.size(50.dp)
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(

                                text = item.title,

                                style = MaterialTheme.typography.titleMedium,

                                fontWeight = FontWeight.Bold,

                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}