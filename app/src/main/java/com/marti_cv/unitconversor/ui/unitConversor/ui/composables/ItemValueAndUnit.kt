package com.marti_cv.unitconversor.ui.unitConversor.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemValueAndUnit(
    options: List<String>,
    selectedOptionText: String,
    value: String,
    onValueChange: (String) -> Unit,
    expanded: Boolean,
    onExpandedChanged: () -> Unit,
    onSpinnerClose: () -> Unit,
    readOnly: Boolean = false,
    onItemChanged:(String)->Unit
) {


    Column {
        Text(text = "Convertir")
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                label = { Text("Introduce valor") },
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(3f),
                enabled = readOnly

            )
            Spacer(modifier = Modifier.size(8.dp))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    onExpandedChanged()
                },
                modifier = Modifier.weight(1f)
            ) {
                TextField(
                    value = selectedOptionText,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { onSpinnerClose }) {
                    options.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item) },
                            onClick = {
                                //selectedOptionText = item
                                onItemChanged(item)
                                onSpinnerClose()

                            }
                        )
                    }
                }
            }
        }
    }
}