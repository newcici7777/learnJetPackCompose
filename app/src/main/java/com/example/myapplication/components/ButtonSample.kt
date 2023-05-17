package com.example.myapplication.components


import android.support.v4.os.IResultReceiver.Default
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonSample() {
//    Button(onClick = {
//        Log.d("====", "click button")
//    }, colors = ButtonDefaults.buttonColors(Color.Red)){
//        Text(text = "click")
//    }

//    TextButton(onClick = { /*TODO*/ }) {
//        Text(text = "test")
//    }
    OutlinedButton(onClick = { /*TODO*/ }) {
        Text("test")
    }
}

@Preview
@Composable
fun ButtonSamplePreview() {
    ButtonSample()
}

