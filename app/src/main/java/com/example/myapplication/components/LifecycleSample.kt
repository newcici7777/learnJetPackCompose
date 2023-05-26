package com.example.myapplication.components


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun LifecycleSample() {
    var count by remember {
        mutableStateOf(0)
    }

    //參數傳Unit的時候，就啟動一次，不會隨著頁面重繪一次就啟動LaunchedEffect
    //LaunchedEffect(Unit) {
    //若參數是count，監控count有改變就會啟動一次 有點像watchDog
    LaunchedEffect(count) {
        Log.i("====","Launch effect")
    }
    Column() {
        Text(" cout: $count")
        Button(onClick = { count++ }) {
            Text("Button")
        }
        if(count == 3) { //等於3創建子佈局，大於3銷毀子佈局
            SubScreen(count = count)
        }
    }

    //監聽LifeCycle
    val lifecycleOwner = LocalLifecycleOwner.current
    //當lisfecycleOwner變數被創建跟銷毀就會執行下方
    DisposableEffect(lifecycleOwner){
        //創建 或註冊
        //呼叫 onStateChanged(source: LifecycleOwner, event: Lifecycle.Event)
        //source是事件來源,event是事件本身
        val lifecycleEventObserver = LifecycleEventObserver{_, event->
            when(event){
                Lifecycle.Event.ON_PAUSE->{
                    //假設有一個播放器，進入後台，暫停播放方法
                }
                Lifecycle.Event.ON_RESUME->{
                    //回到前台，繼續播放
                }
                else -> {}
            }
        }
        //創建時註冊LifeCycle監聽器
        lifecycleOwner.lifecycle.addObserver(lifecycleEventObserver)
        onDispose {
            //銷毀
            //移除監聽器
            lifecycleOwner.lifecycle.removeObserver(lifecycleEventObserver)
        }
    }
}

@Composable
fun SubScreen(count: Int){
    //監聽子佈局什麼時候創建 什麼時候銷毀
    DisposableEffect(Unit ){
        Log.i("====", "DisposableEffect")
        onDispose {
            Log.i("====", "DisposableEffect:onDispose")
        }
    }
    Text("subview count:$count")
}

@Preview
@Composable
fun LifecycleSamplePreview() {
    LifecycleSample()
}

