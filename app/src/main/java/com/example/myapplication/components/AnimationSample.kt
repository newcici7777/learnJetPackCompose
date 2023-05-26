package com.example.myapplication.components


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample() {
//    佈局(想讓組件消失或隱藏)帶動畫用AnimationVisibility
//            想讓內容消失或隱藏帶動畫用Crossfade AnimatedContent Modifier.animateContentSize
//    內容基於狀態
//    remeberInfiniteTransition
//    updateTranstion
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        Button(onClick = {
            visible = !visible //反選，既可以隱藏又可以顯示
        }) {
            Text("click")
        }
        //
        //enter: EnterTransition = fadeIn() + expandVertically(),fadeIn淡出 預設進入動畫垂直擴張 可以用+連接二個動畫
        //exit: ExitTransition = fadeOut() + shrinkVertically(),淡入 縱向收縮
        AnimatedVisibility(visible = visible, enter = scaleIn() + expandIn()) {

            Image(painter = painterResource(id = R.drawable.img1), contentDescription = null)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample1() {
    var visible by remember {
        mutableStateOf(false)
    }
    Column {
        Button(
            onClick = {
                visible = !visible
            }
        ) {
            Text("click")
        }
        //不要有動畫
        //enter = EnterTransition.None
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                Modifier
                    .size(300.dp)
                    .background(Color.Red)
            ) {
                //自訂義動畫
                //AnimatedVisibilityScope有一個animated的scope
                //包含transition對象，就是動畫對象，透過這個物件可以設置其它動畫
                //假設要改動畫顏色animateColor
                //通過state可以拿到狀態，判斷當前是顯示還是隱藏
                val background by transition.animateColor(label = "") { state ->
                    //如果動畫是顯示 就是藍色
                    if (state == EnterExitState.Visible) Color.Blue else Color.Gray
                }
                Box(
                    modifier = Modifier
                        //順序很重要，animate動畫要放前面
                        .animateEnterExit(
                            enter = slideInVertically(
                                //tween是延遲時間 延遲多少毫秒執行 速率
                                //delayMillis: Int = 0,//是否延遲執行
//                                easing: Easing = FastOutSlowInEasing //動畫的速率
                                animationSpec = tween(
                                    1000,
                                    delayMillis = 1000
                                )//動畫執行的毫秒
                            ),
                            exit = slideOutVertically()
                        )
                        .size(150.dp)
                        .background(background) //背景動畫
                        .align(Alignment.Center)
                    //內部個別元件動畫

                )
            }
        }
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample2() {
    var count by remember {
        mutableStateOf(0)
    }
    Row {
        Button(onClick = {
            count++
        }) {
            Text("Add")
        }
        Text("Count$count")
        //若count有變，就產生動畫
        AnimatedContent(targetState = count) { targetCount ->
            Text(text = "count:$targetCount")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample3() {
    var count by remember {
        mutableStateOf(0)
    }
    Row {
        Button(onClick = {
            count++
        }) {
            Text("Add")
        }
        Button(onClick = {
            count--
        }) {
            Text("---")
        }
        Text("Count$count")
        //若count有變，就產生動畫
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // initialState初始值
                //targetState 目標值
                //假設4變成5 4(initialState) 5(targetState)
                //假設5變成4 5(initialState) 4(targetState)

                //目標值大於初始值(就是4變成5)也就是++
                if (targetState > initialState) {
                    //slideInVertically出現動畫
                    //slideOutVertically 退出動畫
                    //fullHeight高度 預設是總高度的1/2 這裡設置就用整個高度淡入 淡出用-fullHeight
                    //slideInVertically fadeIn 淡入 要用with 才能接淡出
                    //++往下淡入
                    //++往上淡出
                    //從正的方向淡入，從負的方向淡出
                    slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                            slideOutVertically { fullHeight -> -fullHeight } + fadeOut()
                } else {//目標值小於初始值(就是5變成4)也就是--
                    //fullHeight 有改變
                    //從負的方向淡入，從正的方向淡出
                    //--往上淡入
                    //--往下淡出
                    slideInVertically { fullHeight -> -fullHeight } + fadeIn() with
                            slideOutVertically { fullHeight -> fullHeight } + fadeOut()
                }
            }
        ) { targetCount ->
            Text(text = "count:$targetCount")
        }
    }
}

@Composable
fun AnimationSample4() {
    var message by remember {
        mutableStateOf("hello")
    }
    Column {
        Button(onClick = {
            message += "china" //text一直增加china, text的長度就會改變
        }) {
            Text(text = "Button")
        }
        //組件的size有變化，就有動畫
        Text(text = message, modifier = Modifier.animateContentSize())
    }
}

@Composable
fun AnimationSample5() {
    var size by remember {
        mutableStateOf(39.dp)
    }
    //當size變化的時候，也產生一個動畫
    val sizeAnimation by animateDpAsState(
        targetValue = size,
        //spring彈性(有震動的感覺)
        //const val DampingRatioHighBouncy = 0.2f 值愈小，彈性愈高
        animationSpec = spring(Spring.DampingRatioHighBouncy)
    )
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = Icons.Default.Favorite,
            contentDescription = null,
            tint = Color.Red,
            modifier = Modifier
                .size(sizeAnimation)
                //不會有選取的圖示
                //interactionSource = MutableInteractionSource(), indication = null
                .clickable(interactionSource = MutableInteractionSource(), indication = null) {
                    size += 30.dp //size點擊時會愈來愈大
                })
    }
}

@Preview
@Composable
fun AnimationSamplePreview() {
    AnimationSample5()
}

