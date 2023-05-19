package com.example.myapplication.components


import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItemSample() {

//    var list by remember {
//        mutableStateOf(
//            listOf(
//                false, false, false, false, false
//            )
//        )
//    }
    var list by remember {
        mutableStateOf(
            listOf(
                ListItem("item 0", false),
                ListItem("item 1", false),
                ListItem("item 1", false),
                ListItem("item 2", false),
                ListItem("item 0", false)
            )
        )
    }
    Column() {
        list.forEachIndexed() { rawIndex, listItem ->
            ListItem(
                leadingContent = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "Localized description",
                    )
                },
                headlineText = {
                    Text(text = "ccc $rawIndex")
                },
                supportingText = {
                    Text(text = listItem.title)
                },
                trailingContent = {
                    Checkbox(checked = listItem.checked, onCheckedChange = {
                        list = list.mapIndexed { newIndex, listItem ->
                            // 需把原本的listItem copy出來，才能改變屬性
                            var newItem = listItem.copy()
                            if (newIndex == rawIndex) {
                                newItem.checked = !listItem.checked
                            } else {
                                newItem.checked = listItem.checked
                            }
                            //要記得返回新的對象
                            return@mapIndexed newItem
                        }
                        Log.i("====", "${list}")
                    })
                },
                overlineText = {
                    Text(text = "ggg")
                }
            )
        }
    }
}

data class ListItem(val title: String, var checked: Boolean) //checked會被更改，要設成var

@Preview
@Composable
fun ListItemSamplePreview() {
    ListItemSample()
}

