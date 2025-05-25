package com.example.petpassportnew

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chat.ChatScreen
import com.example.petpassport.PetpassportScreen
import com.example.petpassportnew.navigation.Screen
import com.example.profile.ProfileScreen
import com.example.services.ServicesScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Services.route,
        modifier = modifier
    ) {
        composable(Screen.Services.route) {
            ServicesScreen(navController = navController)
        }
        composable(Screen.Appointments.route) {
            ServicesScreen(navController = navController)
        }
        composable(Screen.PetPassport.route) {
            PetpassportScreen(navController = navController)
        }
        composable(Screen.Chat.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}