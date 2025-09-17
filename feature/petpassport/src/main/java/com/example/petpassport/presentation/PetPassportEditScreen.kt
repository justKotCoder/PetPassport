package com.example.petpassport.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.ui.theme.LightBlue
import com.example.petpassport.presentation.component.PetForm
import com.example.petpassport.presentation.intent.PetIntent
import com.example.petpassport.presentation.state.PetState // Убедитесь, что PetState правильно определен

@Composable
fun PetPassportEditScreen(
    navController: NavController,
    viewModel: PetPassportEditViewModel = hiltViewModel()
) {
    // Используем collectAsState для состояния из ViewModel
    val state = viewModel.state.collectAsState().value
    val context = LocalContext.current

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Кнопка "назад"
        Text(
            text = "назад",
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .padding(vertical = 16.dp),
            fontWeight = FontWeight.Bold,
            color = LightBlue
        )

        // Форма питомца
        PetForm(
            state = state, // Передаем состояние в форму
            onIntent = viewModel::onIntent, // Обрабатываем интенты
            modifier = Modifier.fillMaxWidth()
        )

        // Кнопка сохранения
        Button(
            onClick = { viewModel.onIntent(PetIntent.SavePet) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue,
                contentColor = Color.White
            ),
            enabled = !state.isLoading
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(color = Color.White) // Индикатор загрузки, когда состояние loading
            } else {
                Text(
                    text = "Сохранить",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
