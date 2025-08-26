package com.example.petpassport.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.petpassport.PetPassportEdit
import com.example.petpassport.PetpassportScreen

fun NavGraphBuilder.passportNavGraph(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    navigation(
        startDestination = PassportRoutes.Main.route,
        route = "petpassport_graph"
    ) {
        composable(PassportRoutes.Main.route) {
            PetpassportScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(PassportRoutes.Edit.route) {
            PetPassportEdit(
                navController = navController,
                modifier = modifier
            )
        }
    }
}