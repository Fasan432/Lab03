package com.example.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CountApp() {

    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = count.toString(),
            fontSize = 50.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = {
                if (count > 0) count--
            }) {
                Text("-")
            }

            Button(onClick = {
                count++
            }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            count = 0
        }) {
            Text("Reset")
        }
    }
}