package com.example.myapplication.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.R.drawable.ic_android_black_24dp
import com.example.myapplication.R.mipmap.ic_launcher

@Composable
fun IconSample() {
//    Icon(imageVector = Icons.Default.Translate, contentDescription = null, tint = Color.Red)
//    Icon(painter = painterResource(id = ic_android_black_24dp), contentDescription = null)
    Image(
        painter = painterResource(id = R.drawable.ic_android_black_24dp),
        contentDescription = null,
        modifier = Modifier.size(50.dp),
        colorFilter = ColorFilter.tint(Color.Red, blendMode = BlendMode.Color)
    )
}

@Preview
@Composable
fun IconSamplePreview() {
    IconSample()
}

