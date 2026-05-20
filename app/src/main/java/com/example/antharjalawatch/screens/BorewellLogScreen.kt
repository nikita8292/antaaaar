package com.example.antharjalawatch.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorewellLogScreen(
    navController: NavController
) {

    val context = LocalContext.current

    val db = FirebaseFirestore.getInstance()

    var latitude by remember { mutableStateOf("") }

    var longitude by remember { mutableStateOf("") }

    var depth by remember { mutableStateOf("") }

    var yieldValue by remember { mutableStateOf("") }

    var year by remember { mutableStateOf("") }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text("Borewell Log")
                },

                navigationIcon = {

                    IconButton(
                        onClick = {

                            navController.popBackStack()
                        }
                    ) {

                        Icon(
                            imageVector =
                                Icons.AutoMirrored.Filled.ArrowBack,

                            contentDescription = "Back"
                        )
                    }
                }
            )
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)

        ) {

            OutlinedTextField(

                value = latitude,

                onValueChange = {
                    latitude = it
                },

                label = {
                    Text("Latitude")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(

                value = longitude,

                onValueChange = {
                    longitude = it
                },

                label = {
                    Text("Longitude")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(

                value = depth,

                onValueChange = {
                    depth = it
                },

                label = {
                    Text("Depth")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(

                value = yieldValue,

                onValueChange = {
                    yieldValue = it
                },

                label = {
                    Text("Yield")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            OutlinedTextField(

                value = year,

                onValueChange = {
                    year = it
                },

                label = {
                    Text("Year")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(

                onClick = {

                    val borewellData = hashMapOf(

                        "latitude" to latitude,

                        "longitude" to longitude,

                        "depth" to depth,

                        "yield" to yieldValue,

                        "year" to year
                    )

                    db.collection("borewells")
                        .add(borewellData)

                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Data Saved Successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                            navController.navigate(

                                "borewell_details/" +
                                        latitude + "/" +
                                        longitude + "/" +
                                        depth + "/" +
                                        yieldValue + "/" +
                                        year
                            )
                        }

                        .addOnFailureListener {

                            Toast.makeText(
                                context,
                                "Failed To Save",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(14.dp)

            ) {

                Text("Save Data")
            }
        }
    }
}