package com.example.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.ui.theme.BlueFont
import com.example.core.ui.theme.DarkGrey
import com.example.core.ui.theme.Grey
import com.example.core.ui.theme.LightBlue
import com.example.petpassport.feature.profile.R

@Composable
fun ProfileScreen(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp) // Добавлен верхний отступ
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Внутренний отступ для контента
        ) {
            // Заголовок профиля
            ProfileHeader(
                name = "Иванов Иван",
                email = "pochta@gmail.com"
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Пункты меню с закругленными углами
            ProfileMenuItem(
                text = "Настройки",
                onClick = { /* Обработка клика */ }
            )
            ProfileMenuItem(
                text = "Избранное",
                onClick = { /* Обработка клика */ }
            )
            ProfileMenuItem(
                text = "Помощь",
                onClick = { /* Обработка клика */ }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Кнопка выхода
            Button(
                onClick = { /* Обработка выхода */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp) // Увеличена высота кнопки
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Grey,
                    contentColor = Color.Red
                )
            ) {
                Text("Выйти", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Иконка профиля с голубым фоном
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(LightBlue),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.profile_ic),
                contentDescription = "Profile",
                modifier = Modifier.size(32.dp),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Иконка уведомлений сдвинута вправо
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.notification_ic),
            contentDescription = "Notification",
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun ProfileMenuItem(text: String, onClick: () -> Unit = {}) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp) // Увеличен вертикальный отступ
            .height(56.dp) // Увеличена высота кнопки
            .clip(RoundedCornerShape(12.dp)),
        color = Grey
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp) // Увеличен горизонтальный отступ
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = BlueFont
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.right_ic),
                contentDescription = null,
                modifier = Modifier.size(24.dp), // Увеличена иконка
                tint = DarkGrey
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(navController = null)
    }
}