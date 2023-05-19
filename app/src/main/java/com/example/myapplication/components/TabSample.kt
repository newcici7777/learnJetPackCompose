package com.example.myapplication.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select

@Composable
fun TabSample() {
    var selectedTabIndex by remember {
        mutableStateOf(0) //默認選中第一個
    }
    Column {
        //contentColor 設置內容的顏色
        //indicator帶有底部指示條 默認有 ，不想要就設置空indicator = {}
        //divider分割線 默認有
        //tabs想放幾個tabs就放多少個
        TabRow(selectedTabIndex = selectedTabIndex) {
            Text(
                text = "Tab1",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        selectedTabIndex = 0
                    },
                color = if (selectedTabIndex == 0) Color.Black else Color.Red
            )
            Text(
                text = "Tab2",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        selectedTabIndex = 1
                    },
                color = if (selectedTabIndex == 1) Color.Black else Color.Red
            )
            Text(
                text = "Tab3",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable {
                        selectedTabIndex = 2
                    },
                color = if (selectedTabIndex == 2) Color.Black else Color.Red
            )
        }

        Text(text = "Curren index: $selectedTabIndex")
    }
}


@Composable
fun TabSample1() {
    var selectedTabIndex by remember {
        mutableStateOf(0) //默認選中第一個
    }
    Column {
        //contentColor 設置內容的顏色
        //indicator帶有底部指示條 默認有 ，不想要就設置空indicator = {}
        //divider分割線 默認有
        //tabs想放幾個tabs就放多少個
        TabRow(selectedTabIndex = selectedTabIndex) {
            //selectedContentColor 選中的文字顏色
            //unselectedContentColor被選中的文字顏色
            //當tab是0，就把selectedTabIndex 給值0
            Tab(selected = selectedTabIndex == 0,
                onClick = {
                    selectedTabIndex = 0
                },
            selectedContentColor = Color.Red,
            unselectedContentColor = Color.Gray){
                Text(text = "Tab0")
            }
            Tab(selected = selectedTabIndex == 1,
                onClick = {
                    selectedTabIndex = 1
                },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray){
                Text(text = "Tab1")
            }
            Tab(selected = selectedTabIndex == 2,
                onClick = {
                    selectedTabIndex = 2
                },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray){
                Text(text = "Tab2")
            }
        }

        Text(text = "Curren index: $selectedTabIndex")
    }
}

@Preview
@Composable
fun TabSamplePreview() {
    TabSample1()
}

