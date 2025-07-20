package com.example.petpassportnew.navigation

import androidx.compose.foundation.layout.*
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
    val currentDestination = navBackStackEntry.value?.destination

    Box(modifier = Modifier.height(68.dp)) {
        Surface(
            color = Color(0xFF033957),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    if (index != 2) {
                        // Проверяем активный маршрут с учетом вложенных графов
                        val isSelected = when {
                            item.route == Screen.Profile.route ->
                                currentDestination?.route?.startsWith(item.route) == true
                            else ->
                                currentDestination?.route == item.route
                        }

                        IconButton(
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route,
                                modifier = Modifier.size(24.dp),
                                tint = if (isSelected) CustomBlue else Color.White.copy(alpha = 0.7f)
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.size(48.dp))
                    }
                }
            }
        }

        Box(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)) {
            Surface(
                shape = CircleShape,
                color = CustomBlue,
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = (-12).dp),
                tonalElevation = 8.dp
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.PetPassport.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
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