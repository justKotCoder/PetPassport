package com.example.petpassportnew.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core.ui.theme.CustomBlue

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Services,
        Screen.Appointments,
        Screen.PetPassport,
        Screen.Chat,
        Screen.Profile
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    // Общая высота навбара (56dp) + выступ круга (12dp)
    Box(modifier = Modifier.height(68.dp)) {
        // Основной контейнер навбара
        Surface(
            color = Color(0xFF033957),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly, // Равные промежутки
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    if (index != 2) { // Пропускаем позицию для круглой кнопки
                        val selected = navBackStackEntry.value?.destination?.route == item.route

                        IconButton(
                            onClick = { navController.navigate(item.route) },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route,
                                modifier = Modifier.size(24.dp),
                                tint = if (selected) CustomBlue else Color.White.copy(alpha = 0.7f)
                            )
                        }
                    } else {
                        // Пустой Box для сохранения места
                        Spacer(modifier = Modifier.size(48.dp))
                    }
                }
            }
        }

        // Плавающая круглая кнопка (выступает вверх)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Surface(
                shape = CircleShape,
                color = CustomBlue,
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = (-12).dp), // Выступ вверх на 12dp
                tonalElevation  = 8.dp
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.PetPassport.route) },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        painter = painterResource(id = Screen.PetPassport.icon),
                        contentDescription = "Pet Passport",
                        modifier = Modifier.size(28.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}