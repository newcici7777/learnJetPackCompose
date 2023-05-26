package com.example.myapplication.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogSample() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    Column() {
        Button(onClick = {
            showDialog = true //點擊按鈕 設值給showDialog
        }) {
            Text("show dialog")
        }
        if (showDialog) { // 是true
//            Dialog(onDismissRequest = { showDialog = false }) {
//                //Text("Dialog Content")
//                Surface(
//                    color = Color.White,//設置顏色
//                    modifier = Modifier.size(200.dp, 100.dp) //設置大小 寬 高
//                ) {
//                    Column() {
//                        Text("Dialog Content")
//                    }
//                }
//            }
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                title = {
                    Text("title")
                },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                },
                text = {
                    Text("這是Dialog的內容")
                })
        }

    }
}

@Preview
@Composable
fun DialogSamplePreview() {
    DialogSample()
}

