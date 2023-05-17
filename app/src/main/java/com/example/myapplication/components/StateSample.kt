package com.example.myapplication.components


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun StateSample() {
    var count by remember {
        mutableStateOf(1)
    }
    Log.d("xxxx","outter${count}")
    Text(text = "xx${count}xxx", Modifier.clickable {
        count++
        Log.d("xxxx","I comin")
    } )
}

@Preview
@Composable
fun StateSamplePreview() {
    StateSample()
}

