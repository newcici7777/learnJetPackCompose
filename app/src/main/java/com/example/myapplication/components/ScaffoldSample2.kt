package com.example.myapplication.components


import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun ScaffoldSample2() {
    val navs = listOf("Home", "Study", "Profile")

    var currentNavIndex: Int by remember {
        mutableStateOf(0)
    }

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    //topbar 頂部的bar
    //bottom bar底部的bar
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Title")
            }, navigationIcon = {
                IconButton(onClick = {
                    Log.d("===", "click")
                    coroutineScope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }, actions = {//top bar右上方
                IconButton(onClick = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("你同意", "yes")
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Edit")
            })
        },
        bottomBar = {
            BottomAppBar() {
                //在方法的前面必須加上@OptIn(ExperimentalMaterialApi::class
                //否則無法使用BottomNavigation的套件
                //bottomNavigation有背景顏色backgroundColor
                //contentColor字的顏色
                BottomNavigation() {
                    //會用到下標，所以使用forEachIndexed
                    navs.forEachIndexed { index, s ->
                        BottomNavigationItem(selected = currentNavIndex == index,
                            onClick = {
                                currentNavIndex = index //保存index
                            },
                            icon = {
                                Icon(
                                    Icons.Default.AccountBox,
                                    contentDescription = null
                                )
                            },
                            label = {
                                Text(text = s)
                            }
                        )
                    }
                }
            }
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            Text("Drawer Content")
        },
        drawerBackgroundColor = Color.Yellow,//背景顏色
        drawerContentColor = Color.Red,//文字顏色
        drawerScrimColor = Color.Green
    ) {
        Text(text = "Scaffold Body Content")
    }
}

@Preview
@Composable
fun ScaffoldSample2Preview() {
    ScaffoldSample2()
}

