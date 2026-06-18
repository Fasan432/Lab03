package com.example.statelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

@Composable
fun Calculator() {

    var bill by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf("15") }
    var roundUp by remember { mutableStateOf(false) }

    TipCalculator(
        bill = bill,
        onBillChange = { bill = it },

        tipPercent = tipPercent,
        onTipPercentChange = { tipPercent = it },

        roundUp = roundUp,
        onRoundUpChange = { roundUp = it }
    )
}

@Composable
fun TipCalculator(
    bill: String,
    onBillChange: (String) -> Unit,

    tipPercent: String,
    onTipPercentChange: (String) -> Unit,

    roundUp: Boolean,
    onRoundUpChange: (Boolean) -> Unit
) {

    val billAmount = bill.toDoubleOrNull() ?: 0.0
    val tipValue = tipPercent.toDoubleOrNull() ?: 0.0

    var tip = billAmount * tipValue / 100

    if (roundUp) {
        tip = ceil(tip)
    }

    val total = billAmount + tip

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text("Tip Calculator")

        OutlinedTextField(
            value = bill,
            onValueChange = onBillChange,
            label = { Text("Bill Amount") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        OutlinedTextField(
            value = tipPercent,
            onValueChange = onTipPercentChange,
            label = { Text("Tip %") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Row {
            Text("Round up tip")

            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = roundUp,
                onCheckedChange = onRoundUpChange
            )
        }

        Text("Tip: %.2f".format(tip))

        Text("Total: %.2f".format(total))
    }
}