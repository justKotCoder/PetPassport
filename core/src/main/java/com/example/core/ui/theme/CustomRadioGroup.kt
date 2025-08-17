package com.example.core.ui.theme

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CustomRadioGroup(
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(width = 0.5.dp, color = Color(0xFFD5D5D5), shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.Start
    ) {
        content()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomRadioGroupPreview() {
    var selectedGender by remember { mutableStateOf("Мужской") }

    CustomRadioGroup {
        CustomRadioButton(
            isSelected = selectedGender == "Мужской",
            text = "Мужской",
            modifier = Modifier.weight(1f),
            onClick = { selectedGender = "Мужской" }
        )
        CustomRadioButton(
            isSelected = selectedGender == "Женский",
            text = "Женский",
            modifier = Modifier.weight(1f),
            onClick = { selectedGender = "Женский" }
        )
    }
}
