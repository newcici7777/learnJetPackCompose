package com.example.myapplication.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RadioButtonSample() {
    //單個按鈕
//    var selected by remember {
//        mutableStateOf(false) //Ò默認為false
//    }
//    RadioButton(selected = selected, onClick = {
//        /*TODO*/
//        selected = !selected
//    })

    //多個
    var checkedList by remember {
        mutableStateOf(listOf(false, false))
    }

    Column() {
        checkedList.forEachIndexed { index, item ->
            RadioButton(selected = item, onClick = {
                /*TODO*/
                //透過index判斷當前點擊的是那一個
                checkedList = checkedList.mapIndexed{
                    j,_ -> index == j
                }

            })
        }
    }
}

@Preview
@Composable
fun RadioButtonSamplePreview() {
    RadioButtonSample()
}

