package com.example.myapplication.components


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProgressIndicatorSample() {
//    CircularProgressIndicator(
//        color = Color.Red,
//        progress = 0.5f
//    )
    LinearProgressIndicator(
        color = Color.Red,
        progress = 0.5f
    )
}

@Preview
@Composable
fun ProgressIndicatorSamplePreview() {
    ProgressIndicatorSample()
}

