package com.example.myapplication.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckBoxSample() {
//    //只有一個
//    var checked by remember{
//        mutableStateOf(false)
//    }
//    Checkbox(checked = checked, onCheckedChange = {
//        checked = it // 直接等於 回傳參數
//    })

    //多選
    var checkedList by remember {
        mutableStateOf(listOf(false, false))
    }

    Column{
        checkedList.forEachIndexed(){
            i, item ->
            Checkbox(checked = item, onCheckedChange = {
                checkedList = checkedList.mapIndexed(){ j, b ->
                    if(i == j) {//i 和 j是同一個item
                        !b //不同的操作
                    } else {
                        b
                    }
                }
            })
        }
    }
}

@Preview
@Composable
fun CheckBoxSamplePreview() {
    CheckBoxSample()
}

