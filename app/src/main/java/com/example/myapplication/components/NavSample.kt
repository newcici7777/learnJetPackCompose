package com.example.myapplication.components


import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavSample() {
    val navController = rememberNavController()
    //builder 放置所有想導航的頁面
    //NavHost(navController = navController, startDestination = "First") {
    NavHost(navController = navController, startDestination = Screen.First.route) {
        //builder用尾隨lambda，最後一個參數直接在外寫花括號
        //裡面不能直接呼叫函數
        //需要NavGraphBuilder.composable擴展函數來幫忙，直接放要導向的Compose的頁面
        //route路由名稱
        //route的名稱跟startDestination的名稱相同,代表導覽的起始點是FirstPage
        //若起始點想設置Second 就startDestination設Second
        //composable(route = "First") {
        composable(route = Screen.First.route) {
//            FirstPage(navController = navController)
            FirstPage {
                //navController.navigate("Second/Cici/19")
                navController.navigate("${Screen.Second.route}/Cici/19")
            }
        }

        //括號是帶參數 {name}默認是String類型
        //arguments 定義參數類型
        //composable(route = "Second/{name}/{age}", arguments = listOf(
        composable(route = "${Screen.Second.route}/{name}/{age}", arguments = listOf(
            //定義參數類型 參考NavArgument
            navArgument("age") {
                type = NavType.IntType //整數類型
                //nullable = true //Int類型不能設空，會報錯
            }
        )) {
//            SecondPage(navController = navController)
            //NavBackStackEntry參數值從這取
            val name = it.arguments?.getString("name") //取得參數，可能為空，要用?取得
            //使用貓王，若為空就用18
            val age = it.arguments?.getInt("age") ?: 18
            SecondPage("name", age) {
                //navController.navigate("Third?carName=c300") // 假設傳值carName都沒傳值
                navController.navigate("${Screen.Third.route}?carName=c300") // 假設傳值carName都沒傳值
            }
        }

        //可選參數 默認為String 可用arguments設置參數類型
        //composable(route = "Third?carName={carName}",arguments = listOf(
        composable(route = "${Screen.Third.route}?carName={carName}",arguments = listOf(
            navArgument("carName") {
                defaultValue = "vovo" //默認值  但好像沒什麼效果
            }
        )) {
            val carName = it.arguments?.getString("carName")
//            ThirdPage(navController = navController)
            ThirdPage(carName){

                //navController.popBackStack("First" , inclusive = false)
                navController.popBackStack(Screen.First.route, inclusive = false)

                //true會怪怪的
                //navController.popBackStack("First" , inclusive = true)
            }
        }


    }
}
//定義一個類 枚舉類型
//維護每個頁的名稱，不要使用String，要記得把建構函數的參數變成val，才可以取得
sealed class Screen(val route: String){
    object First:Screen("First") //Screen的子類，繼承Screen要把父類的建構函數給實現
    object Second:Screen("Second")
    object Third:Screen("Third")
}
@Composable
//fun FirstPage(navController: NavHostController) {
fun FirstPage(onNavigateToSecond:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,//設置居中
        verticalArrangement = Arrangement.Center//設置居中
    ) {
        Text("First Screen")
        Button(onClick = {
//            navController.navigate("second")
            onNavigateToSecond()
        }) {
            Text("Navigate to sencond")
        }
    }
}

@Composable
//fun SecondPage(navController: NavHostController) {
//傳進name的參數，有可能為空
//因age有默認值，所以age肯定有
fun SecondPage(name:String?, age: Int, onNavigateToThird:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        horizontalAlignment = Alignment.CenterHorizontally,//設置居中
        verticalArrangement = Arrangement.Center//設置居中
    ) {
        Text("Second Screen:$name  age:$age") // 顯示出來參數名
        Button(onClick = {
//            navController.navigate("third")
            onNavigateToThird()
        }) {
            Text("Navigate to third")
        }
    }
}

@Composable
//fun thirdPage(navController: NavHostController) {
fun ThirdPage(carName: String?, onBackToRoot:()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,//設置居中
        verticalArrangement = Arrangement.Center//設置居中
    ) {
        Text("Third Screen")
        Button(onClick = {
//            navController.popBackStack(
//                "First", inclusive = false
//            )
            onBackToRoot()
        }) {
            Text("back to first page : carName :$carName")
        }
    }
}

@Preview
@Composable
fun NavSamplePreview() {
    NavSample()
}

