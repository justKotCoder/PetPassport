package com.example.petpassport.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.ui.theme.CustomRadioButton
import com.example.core.ui.theme.CustomRadioGroup
import com.example.core.ui.theme.LightBlue

@Composable
fun PetPassportEditScreen(
    navController: NavController,
    viewModel: PetPassportEditViewModel = hiltViewModel(),
    modifier: Modifier = Modifier


) {
    // Используем collectAsState для состояния из ViewModel
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    // Обработка состояний при изменении состояния isSaved
    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            navController.popBackStack() // Навигация назад
        }
    }

    // Обработка ошибок и их отображение через Toast
    LaunchedEffect(state.error) {
        state.error?.let { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show() // Показываем ошибку в виде Toast
        }
    }


    // Состояния для полей формы
    val petName = remember { mutableStateOf("") }
    val birthDate = remember { mutableStateOf("") }
    val breed = remember { mutableStateOf("") }
    val color = remember { mutableStateOf("") }
    val specialMarks = remember { mutableStateOf("") }
    val chipNumber = remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Мужской") }
    var petImage by remember { mutableStateOf<ImageBitmap?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Кнопка "назад" вверху экрана
        Text(
            text = "Назад",
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .padding(vertical = 16.dp),
            fontWeight = FontWeight.Bold,
            color = LightBlue
        )

        // Контейнер для добавления фото
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.LightGray, CircleShape)
                    .background(Color.White)
                    .clickable {
                        // TODO: Реализовать выбор изображения
                    }
            ) {
                if (petImage == null) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Добавить фото",
                        tint = Color.LightGray,
                        modifier = Modifier.size(40.dp)
                    )
                } else {
                    Image(
                        bitmap = petImage!!,
                        contentDescription = "Фото питомца",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "добавить фото",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }        // Поля формы
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
            onClick = {
                // Сохранение данных и возврат на предыдущий экран
                navController.popBackStack()
            },
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
