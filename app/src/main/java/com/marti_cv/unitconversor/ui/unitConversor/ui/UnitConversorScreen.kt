package com.marti_cv.unitconversor.ui.unitConversor.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.marti_cv.unitconversor.R
import com.marti_cv.unitconversor.ui.unitConversor.ui.composables.ItemValueAndUnit

@Composable
fun UnitConversorScreen(unitConversorViewModel: UnitConversorViewModel) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ItemValueAndUnit()
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = { }) {
            Icon(
                painterResource(id = R.drawable.baseline_sync_24),
                contentDescription = "change icon"
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        ItemValueAndUnit()
    }
}