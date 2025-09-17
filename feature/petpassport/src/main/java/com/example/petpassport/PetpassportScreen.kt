package com.example.petpassport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.core.ui.theme.BlueFont
import com.example.core.ui.theme.LightBlue
import com.example.petpassport.feature.petpassport.R
import com.example.petpassport.navigation.PassportRoutes

@Composable
fun PetpassportScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .clipToBounds(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Обертка для текста и изображения
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .zIndex(2f),
                contentAlignment = Alignment.TopCenter
            ) {
                // Текстовый блок
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 40.dp)
                        .zIndex(1f)
                ) {
                    Text(
                        text = "Добавь меня чтобы",
                        style = TextStyle(
                            color = BlueFont,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        text = "ты мог заказать",
                        style = TextStyle(
                            color = BlueFont,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        text = "уникальный паспорт",
                        style = TextStyle(
                            color = BlueFont,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                // Изображение питомца
                Image(
                    painter = painterResource(id = R.drawable.pet2),
                    contentDescription = "Pet Image",
                    modifier = Modifier
                        .size(230.dp)
                        .align(Alignment.BottomCenter)
                        .offset(x = 30.dp, y = 20.dp)
                        .zIndex(3f)
                )
            }

            // Кнопка (используем offset вместо отрицательного padding)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 85.dp)
                    .offset(y = (-1).dp)
                    .zIndex(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                Button(
                    onClick = {
                        navController.navigate(PassportRoutes.Edit.route)
                    },
                    modifier = Modifier
                        .width(148.dp)
                        .height(43.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightBlue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Добавить",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}