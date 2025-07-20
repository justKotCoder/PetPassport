package com.example.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.core.nav_profile.InnerScreen
import com.example.settings.presentation.SettingsScreen

fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "profile_main",
        route = "profile_graph"
    ) {
        composable("profile_main") {
            ProfileScreen(navController = navController)
        }

        composable(InnerScreen.Settings.route) {
            SettingsScreen(navController = navController)
        }

        composable(InnerScreen.Favorites.route) {
            /* FavoritesScreen(navController) */
        }

        composable(InnerScreen.Help.route) {
            /* HelpScreen(navController) */
        }
    }
}