package com.example.myapplication.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowSample() {
    Row(
        modifier = Modifier
            .size(400.dp)
            .background(Color.Green),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            "Column First Item",
            modifier = Modifier.weight(1f, true)
                .background(Color.Red)
        )
        Text("Column Second Item",
            modifier = Modifier.weight(1f, true))
    }
}

@Preview
@Composable
fun RowSamplePreview() {
    RowSample()
}

