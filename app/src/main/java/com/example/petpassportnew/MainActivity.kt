package com.example.petpassportnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.petpassportnew.navigation.BottomNavigationBar
import com.example.petpassportnew.navigation.Screen
import com.example.petpassportnew.presentation.splash.SplashScreen
import com.example.petpassportnew.presentation.splash.SplashViewModel
import com.example.petpassportnew.ui.theme.PetPassportNewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetPassportNewTheme {
                AppEntryPoint()
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    val navController = rememberNavController()
    val splashViewModel: SplashViewModel = viewModel()
    var splashCompleted by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { if (splashCompleted) BottomNavigationBar(navController = navController) },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        if (!splashCompleted) {
            SplashScreen(splashViewModel) {
                splashCompleted = true
            }
        } else {
            MainNavigation(
                navController,
                modifier = Modifier.padding(innerPadding)
            )
            LaunchedEffect(Unit) {
                navController.navigate(Screen.Services.route)
            }
        }
    }
}