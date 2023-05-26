package com.example.myapplication.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CompositionLocalSample() {
    val navController = rememberNavController()
    val user = User("Test")
    //把user對象 提供給 localActivieUser
    CompositionLocalProvider(localActivieUser provides user) {
        //將NavHost包進CompositionLocalProvider，就可以拿到 user的對象
        NavHost(navController = navController, startDestination = "Home") {
            composable("Home"){
                HomeScreen {
                    navController.navigate("Detail")
                }
            }
            composable("Detail") {
                DetailScreen()
            }
        }
    }
}

//需要一個User的對象
val localActivieUser = compositionLocalOf<User> {
    //若為空就會報錯
    error("user is null")
}

@Composable
fun HomeScreen(onTap: () -> Unit) {
    Column {
        //current指向的是當前User的對象
        Text(text = "Home Screen${localActivieUser.current.name}")
        Button(onClick = { onTap() }) {
            Text(text = "Navigate to Detail")
        }
    }
}

@Composable
fun DetailScreen() {
    Text(text = "Detail Screen${localActivieUser.current.name}")
}

data class User(val name: String)

@Preview
@Composable
fun CompositionLocalSamplePreview() {
    CompositionLocalSample()
}

