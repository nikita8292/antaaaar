package com.example.antharjalawatch.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaterMapScreen(
    navController: NavController
){

    val bengaluru = LatLng(12.9716, 77.5946)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            bengaluru,
            12f
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(

            title = {
                Text(text = "Water Map")
            },

            navigationIcon = {

                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            cameraPositionState = cameraPositionState
        ) {

            // GREEN ZONES

            Circle(
                center = LatLng(12.9716, 77.5946),
                radius = 500.0,
                fillColor = Color.Green.copy(alpha = 0.4f),
                strokeColor = Color.Green,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9816, 77.6046),
                radius = 500.0,
                fillColor = Color.Green.copy(alpha = 0.4f),
                strokeColor = Color.Green,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9616, 77.5846),
                radius = 500.0,
                fillColor = Color.Green.copy(alpha = 0.4f),
                strokeColor = Color.Green,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9750, 77.5700),
                radius = 500.0,
                fillColor = Color.Green.copy(alpha = 0.4f),
                strokeColor = Color.Green,
                strokeWidth = 2f
            )

            // YELLOW ZONES

            Circle(
                center = LatLng(12.9352, 77.6245),
                radius = 500.0,
                fillColor = Color.Yellow.copy(alpha = 0.4f),
                strokeColor = Color.Yellow,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9452, 77.6345),
                radius = 500.0,
                fillColor = Color.Yellow.copy(alpha = 0.4f),
                strokeColor = Color.Yellow,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9552, 77.6445),
                radius = 500.0,
                fillColor = Color.Yellow.copy(alpha = 0.4f),
                strokeColor = Color.Yellow,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9652, 77.6545),
                radius = 500.0,
                fillColor = Color.Yellow.copy(alpha = 0.4f),
                strokeColor = Color.Yellow,
                strokeWidth = 2f
            )

            // RED ZONES

            Circle(
                center = LatLng(12.9260, 77.6762),
                radius = 500.0,
                fillColor = Color.Red.copy(alpha = 0.5f),
                strokeColor = Color.Red,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9360, 77.6862),
                radius = 500.0,
                fillColor = Color.Red.copy(alpha = 0.5f),
                strokeColor = Color.Red,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9460, 77.6962),
                radius = 500.0,
                fillColor = Color.Red.copy(alpha = 0.5f),
                strokeColor = Color.Red,
                strokeWidth = 2f
            )

            Circle(
                center = LatLng(12.9560, 77.7062),
                radius = 500.0,
                fillColor = Color.Red.copy(alpha = 0.5f),
                strokeColor = Color.Red,
                strokeWidth = 2f
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "🟢 Good (0 - 80 ft)",
                    color = Color(0xFF2E7D32)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "🟡 Moderate (80 - 150 ft)",
                    color = Color(0xFFFF9800)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "🔴 Low (150+ ft)",
                    color = Color.Red
                )
            }
        }
    }
}