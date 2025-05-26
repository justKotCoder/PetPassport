package com.example.petpassportnew.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
    onFinished: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val effect = viewModel.effect.collectAsState(initial = null).value

    // Реагируем на эффект — переходим к приложению
    LaunchedEffect(effect) {
        when (effect) {
            is SplashContract.Effect.NavigateToMain -> onFinished()
            null -> Unit
        }
    }

    if (state.isLoading) {
        LottieAnimationScreen()
    } else {
        // можно отрисовать пустоту или fade-out-анимацию
        Box(Modifier.fillMaxSize())
    }
}


