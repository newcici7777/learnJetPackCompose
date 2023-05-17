package com.example.myapplication.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TextSample() {
    Text(
        text = stringResource(id = R.string.testData),
        color = Color(255, 255, 255),
        //fontSize = TextUnit(16f, TextUnitType.Sp)
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,//斜體
        fontWeight = FontWeight.Bold,//粗體
        fontFamily = FontFamily.SansSerif,//字型
        letterSpacing = 10.sp,//字之間的距離
        //底線跟中線
        textDecoration = TextDecoration.combine(
            listOf(
                TextDecoration.LineThrough,
                TextDecoration.Underline
            )
        ),
        //文字居右
        textAlign = TextAlign.Center,
        //行高
        lineHeight = 30.sp,
        maxLines = 1,//最大行數
        //超出就...
        overflow = TextOverflow.Ellipsis,
        style = TextStyle()
    )
}
@Preview(widthDp = 100)
@Composable
fun TextSamplePreview() {
    TextSample()
}