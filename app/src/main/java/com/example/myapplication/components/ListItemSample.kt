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

    var list by remember {
        mutableStateOf(
            listOf(
                false, false, false, false, false
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
                    Text(text = "aaa")
                },
                trailingContent = {
                    Checkbox(checked = listItem, onCheckedChange = {
                        list = list.mapIndexed { newIndex, listItem ->
                            if (rawIndex == newIndex) {
                                !listItem
                            } else {
                                listItem
                            }
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


@Preview
@Composable
fun ListItemSamplePreview() {
    ListItemSample()
}

