package com.example.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.core.nav_profile.InnerScreen
import com.example.core.ui.theme.BlueFont
import com.example.core.ui.theme.DarkGrey
import com.example.core.ui.theme.Grey
import com.example.core.ui.theme.LightBlue
import com.example.petpassport.feature.profile.R
import com.example.profile.presentation.ProfileUiEffect
import com.example.profile.presentation.ProfileUiEvent
import com.example.profile.presentation.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavController? = null,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.setEvent(ProfileUiEvent.OnAppear)
        viewModel.effect.collect { effect ->
            when (effect) {
                is ProfileUiEffect.ShowToast -> {
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        ProfileContent(
            name = state.name,
            email = state.email,
            onLogoutClick = { /* TODO */ },
            onItemClick = { screen ->
                navController?.navigate(screen.route)
            }
        )
    }
}

@Composable
fun ProfileContent(
    name: String,
    email: String,
    onLogoutClick: () -> Unit,
    onItemClick: (InnerScreen) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ProfileHeader(name = name, email = email)

            Spacer(modifier = Modifier.height(32.dp))

            ProfileMenuItem(text = "Настройки", onClick = { onItemClick(InnerScreen.Settings) })
            ProfileMenuItem(text = "Избранное", onClick = {  })
            ProfileMenuItem(text = "Помощь", onClick = {  })

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onLogoutClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Grey,
                    contentColor = Color.Red
                )
            ) {
                Text("Выйти", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(LightBlue),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.profile_ic),
                contentDescription = "Profile",
                modifier = Modifier.size(32.dp),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = name, style = MaterialTheme.typography.titleLarge)
            Text(
                text = email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.notification_ic),
            contentDescription = "Notification",
            modifier = Modifier
                .size(32.dp)
                .padding(end = 8.dp)
        )
    }
}

@Composable
fun ProfileMenuItem(text: String, onClick: () -> Unit = {}) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(12.dp)),
        color = Grey
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge.copy(color = BlueFont),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.right_ic),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = DarkGrey
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileContentPreview() {
    MaterialTheme {
        ProfileContent(
            name = "Жан",
            email = "zhan@future.com",
            onLogoutClick = {},
            onItemClick = {}
        )
    }
}
