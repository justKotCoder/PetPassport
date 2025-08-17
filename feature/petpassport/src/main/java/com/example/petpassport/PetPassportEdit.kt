package com.example.petpassport

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.core.ui.theme.CustomRadioButton
import com.example.core.ui.theme.CustomRadioGroup
import com.example.core.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetEditScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {
    val scrollState = rememberScrollState()

    // Состояния для полей формы
    val petName = remember { mutableStateOf("") }
    val birthDate = remember { mutableStateOf("") }
    val breed = remember { mutableStateOf("") }
    val color = remember { mutableStateOf("") }
    val specialMarks = remember { mutableStateOf("") }
    val chipNumber = remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Мужской") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {


        Spacer(modifier = Modifier.height(16.dp))

        // Поля формы
        OutlinedTextField(
            value = petName.value,
            onValueChange = { petName.value = it },
            label = { Text("Имя питомца (кличка)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = birthDate.value,
            onValueChange = { birthDate.value = it },
            label = { Text("Дата рождения") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = breed.value,
            onValueChange = { breed.value = it },
            label = { Text("Порода") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomRadioGroup {
            CustomRadioButton(
                isSelected = selectedGender == "Мужской",
                text = "Мужской",
                modifier = Modifier.weight(1f),
                onClick = { selectedGender = "Мужской" }
            )
            CustomRadioButton(
                isSelected = selectedGender == "Женский",
                text = "Женский",
                modifier = Modifier.weight(1f),
                onClick = { selectedGender = "Женский" }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = color.value,
            onValueChange = { color.value = it },
            label = { Text("Окрас") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = specialMarks.value,
            onValueChange = { specialMarks.value = it },
            label = { Text("Особые приметы") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = chipNumber.value,
            onValueChange = { chipNumber.value = it },
            label = { Text("Номер чипа") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))


        // Кнопка сохранения
        Button(
            onClick = { /* ... */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Сохранить",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}