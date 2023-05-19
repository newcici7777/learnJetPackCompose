package com.example.myapplication.components


import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.Checkbox
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstrainsSample() {
    var checked by remember {
        mutableStateOf(false)
    }
    //modifier = Modifier.fillMaxWidth() 設最大寬度
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
    ) {
        //建立多個引用
        val (icon, primaryText, secondlyText, checkBox) = createRefs()
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.constrainAs(icon) {
                //置中
                //parent 是constrainLayout
                top.linkTo(parent.top) // icon的頂部關連到constrainLayout的頂部
                bottom.linkTo(parent.bottom) // icon的底部關連到constrainLayout的底部

                //第二個參數是設置間距
                //第三個參數是隱藏時還有多少間距
                start.linkTo(parent.start, 10.dp) // start是左邊，關連到
            }
        )
        Text(
            text = "Primary",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(primaryText) {
                start.linkTo(icon.end, margin = 8.dp) // text的左邊連到icon的右邊，間距8dp
                //置中
                top.linkTo(parent.top) // 頂部關連到constrainLayout的頂部
                bottom.linkTo(parent.bottom) // 底部關連到constrainLayout的底部
            }
        )
        Text(
            text = "Secondary Text",
            color = Color.Gray,
            modifier = Modifier.constrainAs(secondlyText) {
                start.linkTo(primaryText.start) // text的左邊跟 primaryText左邊對齊
                top.linkTo(primaryText.bottom, margin = 8.dp) //頂端 對到primaryText的bottom , 間距 8dp
                bottom.linkTo(parent.bottom)// 底部關連到constrainLayout的底部
            }
        )
        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        }, modifier = Modifier.constrainAs(checkBox) {
            //在父佈局(constrainLayout)中垂直居中
            centerVerticallyTo(parent)
            end.linkTo(parent.end, margin = 8.dp) //右邊關連到父佈局的右邊 有8dp的間距
        })
    }
}

@Composable
fun ConstrainsSample1() {
    var checked by remember {
        mutableStateOf(false)
    }
    val constraints = ConstraintSet {
        val icon = createRefFor("icon")
        val primaryText = createRefFor("primaryText")
        val secondlyText = createRefFor("secondlyText")
        val checkBox = createRefFor("checkBox")
        constrain(icon) {
            centerVerticallyTo(parent)
            start.linkTo(parent.start , margin = 8.dp)
        }
        constrain(primaryText) {
            start.linkTo(icon.end , margin = 8.dp)
            top.linkTo(parent.top, margin = 8.dp)
        }
        constrain(secondlyText) {
            start.linkTo(primaryText.start)
            top.linkTo(primaryText.bottom, margin = 8.dp)
            bottom.linkTo(parent.bottom, margin = 8.dp)
        }
        constrain(checkBox) {
            centerVerticallyTo(parent)
            end.linkTo(parent.end, margin = 8.dp)
        }

    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        constraintSet = constraints
    ) {
        //建立多個引用
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.layoutId("icon")
        )
        Text(
            text = "Primary",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.layoutId("primaryText")
        )
        Text(
            text = "Secondary Text",
            color = Color.Gray,
            modifier = Modifier.layoutId("secondlyText")
        )
        Checkbox(checked = checked,
            onCheckedChange = {
                checked = it
            },
            modifier = Modifier.layoutId("checkBox")
        )
    }
}

@Preview
@Composable
fun ConstrainsSamplePreview() {
    ConstrainsSample1()
}

