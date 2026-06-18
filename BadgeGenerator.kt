package com.example.statelab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BadgeGenerator() {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    var fontSize by remember {
        mutableStateOf(24f)
    }

    var selectedColor by remember {
        mutableStateOf(Color.Black)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Name Badge Generator")

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") }
        )

        Text("Font Size: ${fontSize.toInt()}")

        Slider(
            value = fontSize,
            onValueChange = { fontSize = it },
            valueRange = 0f..72f
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            ColorCircle(Color.Red) {
                selectedColor = Color.Red
            }

            ColorCircle(Color.Blue) {
                selectedColor = Color.Blue
            }

            ColorCircle(Color.Green) {
                selectedColor = Color.Green
            }

            ColorCircle(Color.Black) {
                selectedColor = Color.Black
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "$firstName $lastName",
                    color = selectedColor,
                    fontSize = fontSize.sp
                )
            }
        }
    }
}

@Composable
fun ColorCircle(
    color: Color,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color)
            .clickable {
                onClick()
            }
    )
}