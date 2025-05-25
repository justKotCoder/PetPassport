package com.example.chat


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ChatScreen(navController: NavController) {
    // Содержимое экрана настроек
    Box(modifier = Modifier.padding(16.dp)) {
        Text("Экран чат")
    }
}
