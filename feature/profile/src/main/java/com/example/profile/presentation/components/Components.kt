package com.example.profile.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Временная замена для FullScreenLoader
@Composable
fun FullScreenLoader(text: String = "Загрузка...") {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Spacer(Modifier.height(16.dp))
            Text(text)
        }
    }
}

// Временная замена для ErrorView
@Composable
fun ErrorView(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Ошибка: $message", color = Color.Red)
    }
}

// Временная реализация SettingsList
@Composable
fun SettingsList() {
    Column {
        Text("Избранное", modifier = Modifier.padding(16.dp))
        Text("Помощь", modifier = Modifier.padding(16.dp))
        Text("Выйти", modifier = Modifier.padding(16.dp))
    }
}