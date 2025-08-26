package com.example.petpassport.navigation

sealed class PassportRoutes(val route: String) {
    object Main : PassportRoutes("petpassport_main")
    object Edit : PassportRoutes("petpassport_edit")
}