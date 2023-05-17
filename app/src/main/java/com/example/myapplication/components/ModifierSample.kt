package com.example.myapplication.components


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModifierSample() {
    Text(
        text = "text",
        modifier = Modifier
            .border(1.dp, Color.Red)
            .background(Color.Yellow)
            .padding(8.dp)
            .clickable {
                Log.i("-----","click me")
            }


    )
}

@Preview(widthDp = 100)
@Composable
fun ModifierSamplePreview() {
    ModifierSample()
}

