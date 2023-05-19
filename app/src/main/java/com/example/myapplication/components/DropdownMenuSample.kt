package com.example.myapplication.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DropdownMenuSample() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Column() {
        Button(onClick = {
            expanded = true
        }) {
            Text("快來點我")
        }
        //expanded代表菜單是否展開
        //onDismissRequest 點擊後是否消失
        DropdownMenu(expanded = expanded,
            onDismissRequest = {
                //按其它地方(非按鈕之外)也讓選單不見
                expanded = false
            }) {
            DropdownMenuItem(text = {Text("text1")},
                onClick = { expanded = false })

            DropdownMenuItem(text = {Text("text2")},
                onClick = { expanded = false })
            DropdownMenuItem(text = {Text("text3")},
                onClick = { expanded = false })
        }
    }
}

@Preview
@Composable
fun DropdownMenuSamplePreview() {
    DropdownMenuSample()
}

