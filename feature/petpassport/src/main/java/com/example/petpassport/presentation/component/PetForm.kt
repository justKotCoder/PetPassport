package com.example.petpassport.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.core.ui.theme.CustomRadioButton
import com.example.core.ui.theme.CustomRadioGroup
import com.example.petpassport.presentation.intent.PetIntent
import com.example.petpassport.presentation.state.PetState

@Composable
fun PetForm(
    state: PetState,
    onIntent: (PetIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Поля формы, аналогичные вашему коду, но связанные с state и onIntent
        OutlinedTextField(
            value = state.name,
            onValueChange = { onIntent(PetIntent.SetName(it)) },
            label = { Text("Имя питомца (кличка)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Остальные поля...

        // Радио-кнопки для пола
        CustomRadioGroup {
            CustomRadioButton(
                isSelected = state.sex == "Мужской",
                text = "Мужской",
                modifier = Modifier.weight(1f),
                onClick = { onIntent(PetIntent.SetSex("Мужской")) }
            )
            CustomRadioButton(
                isSelected = state.sex == "Женский",
                text = "Женский",
                modifier = Modifier.weight(1f),
                onClick = { onIntent(PetIntent.SetSex("Женский")) }
            )
        }
    }
}