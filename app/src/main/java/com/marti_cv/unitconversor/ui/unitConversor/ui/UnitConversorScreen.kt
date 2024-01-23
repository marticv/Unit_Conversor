package com.marti_cv.unitconversor.ui.unitConversor.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marti_cv.unitconversor.ui.unitConversor.ui.composables.ItemValueAndUnit

@Composable
fun UnitConversorScreen(unitConversorViewModel: UnitConversorViewModel) {

    val expandedFirstSpinner by unitConversorViewModel.exposeFirstSpinner.observeAsState()
    val expandedSecondSpinner by unitConversorViewModel.exposeSecondSpinner.observeAsState()
    val valueFirstText by unitConversorViewModel.valueFirstText.observeAsState()
    val valueSecondText by unitConversorViewModel.valueSecondText.observeAsState()
    val selectedOptionText by unitConversorViewModel.selectedOptionText.observeAsState(initial = "Km2")
    val selectedOptionText2 by unitConversorViewModel.selectedOptionText2.observeAsState(initial = "Km2")


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ItemValueAndUnit(
            options = unitConversorViewModel.options,
            selectedOptionText = selectedOptionText,
            value = valueFirstText!!,
            onValueChange = {unitConversorViewModel.onValueChange(it)},
            expanded = expandedFirstSpinner!!,
            onExpandedChanged = { unitConversorViewModel.changeFirstSpinnerExposedState() },
            onSpinnerClose = { unitConversorViewModel.onCloseFirstSpinner() },
            readOnly = true,
            onItemChanged = {unitConversorViewModel.onSelectedItemChanged(it)})
        Spacer(modifier = Modifier.size(16.dp))
//        Button(onClick = { unitConversorViewModel.onExchangeClicked() }) {
//            Icon(
//                painterResource(id = R.drawable.baseline_sync_24),
//                contentDescription = "change icon"
//            )
//        }
        Spacer(modifier = Modifier.size(16.dp))
        ItemValueAndUnit(
            options = unitConversorViewModel.options,
            selectedOptionText= selectedOptionText2,
            value = valueSecondText!!,
            onValueChange ={unitConversorViewModel.onValueChange2(it)},
            expanded = expandedSecondSpinner!!,
            onExpandedChanged = { unitConversorViewModel.changeSecondSpinnerExposedState() },
            onSpinnerClose = { unitConversorViewModel.onCloseSecondSpinner() },
            onItemChanged = {unitConversorViewModel.onSelectedItemChanged2(it)}
        )
    }
}