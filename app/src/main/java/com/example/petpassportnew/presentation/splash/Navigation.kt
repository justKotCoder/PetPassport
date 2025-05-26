package com.example.petpassportnew.presentation.splash


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController

const val SplashRoute = "splash"

fun NavGraphBuilder.splashScreen(navController: NavController) {
    composable(SplashRoute) {
        SplashScreen(
            onFinished = {
                navController.navigate("services") {
                    popUpTo(SplashRoute) { inclusive = true }
                }
            }
        )
    }
}
