package com.example.core.nav_profile


sealed class InnerScreen(val route: String) {
    object Settings : InnerScreen("settings")
    object Favorites : InnerScreen("favorites")
    object Help : InnerScreen("help")
}

