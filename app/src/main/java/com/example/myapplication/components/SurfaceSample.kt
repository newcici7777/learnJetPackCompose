package com.example.myapplication.components


import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun SurfaceSample() {
    //shape默認是矩形
    //CircleShape
    //RoundedCornerShape corner圓角大小 percent百分比 RoundedCornerShape(20)
    //CutCornerShape(20)每一個角都切去一點
//    Surface(shape = CutCornerShape(20)) {
//        Image(
//            painter = painterResource(id = R.drawable.img1),
//            contentDescription = null
//        )
//    }
    Surface(
        modifier = Modifier.size(100.dp, 100.dp), //100寬 20高
        shape = CutCornerShape(20),
        color = Color.Yellow, //背景顏色
        border = BorderStroke(1.dp, Color.Green),//邊框線大小跟顏色
        shadowElevation = 10.dp // 陰影
    ) {

    }
}

@Preview
@Composable
fun SurfaceSamplePreview() {
    SurfaceSample()
}

