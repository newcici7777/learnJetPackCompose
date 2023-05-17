package com.example.myapplication.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CardSample() {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Red)
    ) {
        Text("text")
    }
}

@Preview
@Composable
fun CardSamplePreview() {
    CardSample()
}

