package com.example.petpassportnew.navigation

import androidx.annotation.DrawableRes
import com.example.petpassportnew.R

sealed class Screen(val route: String, @DrawableRes val icon: Int) {
    object Services : Screen("services", R.drawable.services_ic)
    object Appointments : Screen("appointments", R.drawable.appointments_ic)
    object PetPassport : Screen("pet_passport", R.drawable.paw_ic)
    object Chat : Screen("chat", R.drawable.chat_ic)
    object Profile : Screen("profile", R.drawable.profile_ic)
}