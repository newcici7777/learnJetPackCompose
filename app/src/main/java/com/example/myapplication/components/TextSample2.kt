package com.example.myapplication.components

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalUnitApi::class)
@Composable
fun TextSample2() {
    val annotationStr = buildAnnotatedString {
        append("text text")
        pushStringAnnotation("tag1", "http://xxxx.xxxx/xx")
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            )
        ) {
            append("tag1")
        }
        pop()
        append("ggg")

        pushStringAnnotation("tag2", "http://123.xxxx/123")
        withStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            )
        ) {
            append("tag2")
        }
        pop()
    }
    ClickableText(text = annotationStr, onClick = { offset ->
        annotationStr.getStringAnnotations("tag1", start = offset, end = offset).firstOrNull()
            ?.let { annotation ->
                Log.d("///aaaa", "test${annotation.item}")
            }
        annotationStr.getStringAnnotations("tag2", start = offset, end = offset).firstOrNull()
            ?.let { annotation ->
                Log.d("///aaaa", "test${annotation.item}")
            }
    })

}

@Preview
@Composable
fun TextSample2Preview() {
    TextSample2()
}