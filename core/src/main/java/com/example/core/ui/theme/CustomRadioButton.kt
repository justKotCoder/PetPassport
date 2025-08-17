package com.example.core.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomRadioButton(
    isSelected: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val cornerShape = if (isSelected) {
            RoundedCornerShape(10.dp)
        } else {
            RoundedCornerShape(10.dp)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .background(if (isSelected) LightBlue else Color.Transparent, cornerShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text,
                modifier = Modifier.padding(10.dp),
                color = if (isSelected) Color.White else Color.Black,
                fontSize = 16.sp
            )
        }
    }
}
