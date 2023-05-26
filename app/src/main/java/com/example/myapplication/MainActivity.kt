package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.myapplication.components.PermissionSample3
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main2)
        //取得composeView
        val composeView = findViewById<ComposeView>(R.id.composeView)
        //xml透過composeView的寫法
        //透過 composeView setContent可以寫composeable的函數
        composeView.setContent {
            Column() {
                Greeting(name = "android")

                //在composeview中建立text view
                AndroidView(factory = {
                    //it參數是context
                    TextView(it) //創建一個TextView
                }) {
                    it.apply {//設置屬性
                        text = "這是 compose裡的textView"
                    }
                }
            }
            PermissionSample3()
        }

//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    group = "Group 1"
)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        //Greeting("Android")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    group = "Group 2"
)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        Greeting("aaaa")
    }
}