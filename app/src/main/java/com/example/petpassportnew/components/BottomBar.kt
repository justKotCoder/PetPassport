package com.example.petpassportnew.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.ui.theme.CustomBlue
import com.example.core.ui.theme.Secondary
import com.example.petpassportnew.navigation.Screen

@Composable
fun BottomNavBar(
    navController: NavController,
    currentRoute: String
) {
    val items = listOf(
        Screen.Services,
        Screen.Appointments,
        Screen.PetPassport,
        Screen.Chat,
        Screen.Profile
    )

    BottomAppBar(
        containerColor = Secondary,
        tonalElevation = 6.dp,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items.forEachIndexed { index, screen ->
            if (index == 2) {
                // Центральная иконка (паспорт)
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    FloatingActionButton(
                        onClick = { navController.navigate(screen.route) },
                        containerColor = CustomBlue,
                        shape = CircleShape,
                        elevation = FloatingActionButtonDefaults.elevation(0.dp)
                    ) {
                        Icon(painterResource(id = screen.icon), contentDescription = null, tint = Color.White)
                    }
                }
            } else {
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    IconButton(onClick = { navController.navigate(screen.route) }) {
                        Icon(
                            painterResource(id = screen.icon),
                            contentDescription = null,
                            tint = if (currentRoute == screen.route) CustomBlue else Color.White
                        )
                    }
                }
            }
        }
    }
}
