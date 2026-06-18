package com.example.statelab

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp

@Composable
fun LoginForm() {

    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var showPassword by remember {
        mutableStateOf(false)
    }

    var status by remember {
        mutableStateOf("")
    }

    val isValid =
        email.contains("@") &&
                password.length >= 6

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Login Form")

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },

            visualTransformation =
                if (showPassword)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()
        )

        Row {

            Checkbox(
                checked = showPassword,
                onCheckedChange = {
                    showPassword = it
                }
            )

            Text("Show Password")
        }

        Button(
            onClick = {

                status = "Login Successful"

                Toast.makeText(
                    context,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()
            },

            enabled = isValid
        ) {
            Text("Login")
        }

        Text(status)
    }
}