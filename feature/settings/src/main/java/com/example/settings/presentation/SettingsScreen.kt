package com.example.settings.presentation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun SettingsScreen(
    navController: NavController? = null,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.setEvent(SettingsUiEvent.OnAppear)
        viewModel.effect.collect { effect ->
            when (effect) {
                is SettingsUiEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Настройки", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(24.dp))

        FieldWithEditToggle(
            label = "Имя",
            value = state.name,
            isEditMode = state.isEditMode,
            onChange = { viewModel.setEvent(SettingsUiEvent.OnChangeName(it)) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        FieldWithEditToggle(
            label = "Почта",
            value = state.email,
            isEditMode = state.isEditMode,
            onChange = { viewModel.setEvent(SettingsUiEvent.OnChangeEmail(it)) }
        )

        Spacer(modifier = Modifier.height(12.dp))

        FieldWithEditToggle(
            label = "Телефон",
            value = state.phone,
            isEditMode = state.isEditMode,
            onChange = { viewModel.setEvent(SettingsUiEvent.OnChangePhone(it)) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(onClick = {
                viewModel.setEvent(SettingsUiEvent.OnToggleEdit)
            }) {
                Text(if (state.isEditMode) "Отмена" else "Редактировать")
            }

            if (state.isEditMode) {
                Button(onClick = {
                    viewModel.setEvent(SettingsUiEvent.OnSave)
                }) {
                    Text("Сохранить")
                }
            }
        }
    }
}

@Composable
private fun FieldWithEditToggle(
    label: String,
    value: String,
    isEditMode: Boolean,
    onChange: (String) -> Unit
) {
    if (isEditMode) {
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = label, style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = value, style = MaterialTheme.typography.bodyLarge)
            }
            IconButton(onClick = { /* Просто визуально — управление редактированием через кнопку ниже */ }) {
                Icon(Icons.Default.Edit, contentDescription = "Edit")
            }
        }
    }
}
