package com.example.myapplication.components


import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SwitchSample() {
    var checked by remember{ mutableStateOf(false)}
    //var switch by remember { mutableStateOf(false) }
    Switch(checked = checked, onCheckedChange = {
        //checked = !checked
        checked = it
    })

}

@Preview
@Composable
fun SwitchSamplePreview() {
    SwitchSample()
}

