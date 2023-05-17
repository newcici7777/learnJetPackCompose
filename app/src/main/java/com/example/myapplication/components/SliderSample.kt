package com.example.myapplication.components


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderSample() {
//    var values by remember{
//        mutableStateOf(0f)
//    }
//
//    Slider(value = values, onValueChange = {
//        values = it
//    }, valueRange = 0f..100f, steps = 4)

    var values by remember {
        mutableStateOf(0.2f..0.8f)
    }
    RangeSlider(value = values, onValueChange ={
        values = it
    } )
}

@Preview
@Composable
fun SliderSamplePreview() {
    SliderSample()
}

