package com.example.myapplication.components


import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnSample() {
    val data = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.verticalScroll(scrollState)){
        data.forEach{
            ListItem(
                leadingContent = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "Localized description",
                    )
                },
                headlineText = {
                    Text(text = "ccc $it")
                },
                supportingText = {
                    Text(text = "aaa")
                },
                overlineText = {
                    Text(text = "ggg")
                }, modifier = Modifier.clickable{
                    //滾動到什麼地方  滾動到最大值
                    //suspend掛起的方法，要用協程
                    coroutineScope.launch {
                        //滑鼠一點就移到最後的位置
                        //scrollState.scrollTo(scrollState.maxValue)

                        //從當前的地方往下移動100px
                        scrollState.scrollBy(100f)
                    }
                })
            //監聽生命周期
            DisposableEffect(Unit) {
                Log.d("====", "effect:$it") //每一項初始會印這個
                onDispose {
                    Log.d("====", "onDispose:$it")//每一項消毀會印這個
                }
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnSample1() {
    val data = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    LazyColumn {
        //items自帶for each功能，可以遍歷
        items(data) {
            ListItem(
                leadingContent = {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "Localized description",
                    )
                },
                headlineText = {
                    Text(text = "ccc $it")
                },
                supportingText = {
                    Text(text = "aaa")
                },
                overlineText = {
                    Text(text = "ggg")
                }, modifier = Modifier.clickable{

                })
            //監聽生命周期
            DisposableEffect(Unit) {
                Log.d("====", "effect:$it") //每一項初始會印這個
                onDispose {
                    Log.d("====", "onDispose:$it")//每一項消毀會印這個
                }
            }
        }
    }
}
private fun <E> List<E>.forEach(action: Unit) {

}

@Preview
@Composable
fun LazyColumnSamplePreview() {
    LazyColumnSample1()
}

