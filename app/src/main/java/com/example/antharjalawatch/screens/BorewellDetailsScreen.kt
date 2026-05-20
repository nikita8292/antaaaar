package com.example.antharjalawatch.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorewellDetailsScreen(
    latitude: String,
    longitude: String,
    depth: String,
    yieldValue: String,
    year: String,
    navController: NavController
) {

    val lat = latitude.toDoubleOrNull() ?: 12.9716
    val lng = longitude.toDoubleOrNull() ?: 77.5946

    val location = LatLng(lat, lng)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            location,
            15f
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = {
                Text("Borewell Details")
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
                .height(250.dp),

            cameraPositionState = cameraPositionState
        ) {

            Marker(
                state = MarkerState(position = location),
                title = "Borewell"
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Row {

                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {

                        Text("Location")

                        Text(
                            "$latitude , $longitude",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Icon(
                        imageVector = Icons.Default.WaterDrop,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {

                        Text("Depth (ft)")

                        Text(
                            depth,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Icon(
                        imageVector = Icons.Default.WaterDrop,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {

                        Text("Yield (inches)")

                        Text(
                            yieldValue,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {

                        Text("Year Of Digging")

                        Text(
                            year,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row {

                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {

                        Text("Added On")

                        Text(
                            "20 May 2026, 10:30 AM",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}