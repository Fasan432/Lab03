package com.example.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiniApp() {

    var text by remember {
        mutableStateOf("")
    }

    val items = remember {
        mutableStateListOf<String>()
    }

    TodoList(
        text = text,
        onTextChange = { text = it },

        items = items,

        onAdd = {
            if (text.isNotBlank()) {
                items.add(text)
                text = ""
            }
        },

        onRemove = {
            items.remove(it)
        }
    )
}

@Composable
fun TodoList(
    text: String,
    onTextChange: (String) -> Unit,

    items: SnapshotStateList<String>,

    onAdd: () -> Unit,

    onRemove: (String) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Todo Mini-App")

        Row {

            OutlinedTextField(
                value = text,
                onValueChange = onTextChange,
                label = { Text("Task") }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = onAdd) {
                Text("Add")
            }
        }

        if (items.isEmpty()) {

            Text("No tasks available")

        } else {

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                items.forEach { item ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement =
                            Arrangement.SpaceBetween,
                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Text(item)

                        Button(
                            onClick = {
                                onRemove(item)
                            }
                        ) {
                            Text("✕")
                        }
                    }
                }
            }
        }
    }
}