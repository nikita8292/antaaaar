package com.example.antharjalawatch.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.antharjalawatch.model.BorewellData
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun BorewellResultScreen() {

    val db = FirebaseFirestore.getInstance()

    var borewellList by remember {
        mutableStateOf<List<BorewellData>>(emptyList())
    }

    LaunchedEffect(Unit) {

        db.collection("borewells")
            .get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<BorewellData>()

                for (document in result) {

                    val data =
                        document.toObject(BorewellData::class.java)

                    list.add(data)
                }

                borewellList = list
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Borewell Results",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(borewellList) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),

                    shape = RoundedCornerShape(16.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(text = "Latitude: ${item.latitude}")

                        Text(text = "Longitude: ${item.longitude}")

                        Text(text = "Depth: ${item.depth} ft")

                        Text(text = "Yield: ${item.yield}")

                        Text(text = "Year: ${item.year}")
                    }
                }
            }
        }
    }
}