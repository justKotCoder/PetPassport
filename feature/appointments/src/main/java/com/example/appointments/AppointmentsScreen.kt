package com.example.appointments


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.w3c.dom.Text


@Composable
fun AppointmentsScreen(navController: NavController) {
    // Содержимое экрана настроек
    Box(modifier = Modifier.padding(16.dp)) {
        Text("Экран мои записи")
    }
}
