package com.example.myapplication.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DividerSample() {
    Column(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Green)
    ) {
        //Modifier.weight(1f) 比重 fill預設為TRUE，填滿所有空間
        //先佈局沒有分配比重的Text()，剩餘的空間就分配給有比重
        Text(
            "Column First Item",
            modifier = Modifier.background(Color.Red)
        )
        Divider(
            thickness = 10.dp, color = Color.Magenta)
        Text("Column Second Item",
            modifier = Modifier.background(Color.Red))
    }
}

@Preview
@Composable
fun DividerSamplePreview() {
    DividerSample()
}

