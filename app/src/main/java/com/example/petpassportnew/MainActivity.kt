package com.example.petpassportnew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.petpassportnew.navigation.BottomNavigationBar
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

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        MainNavigation(
            navController = navController,
            modifier = Modifier.padding(innerPadding))
    }
}