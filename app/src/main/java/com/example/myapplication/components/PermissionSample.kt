package com.example.myapplication.components


import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

//單一權限使用
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionSample() {
    //取得權限狀態
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.CAMERA
    )

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (permissionState.status) {
            PermissionStatus.Granted -> {
                Text(text = "permission is Granted")
            }
            is PermissionStatus.Denied -> {
                Column {
                    val text = if (permissionState.status.shouldShowRationale) {
                        "allow"
                    } else {
                        "deny"
                    }
                    Text(text = text)
                    Button(onClick = { permissionState.launchPermissionRequest() }) {
                        Text(text = "get permission")
                    }
                }
            }
        }
    }
}

//多權限使用
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionSample2() {
    //多權限設定
    val permissionState = rememberMultiplePermissionsState(
        permissions =
        listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    )
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionState.permissions.forEach(){permissionState ->
            when(permissionState.permission) {
                android.Manifest.permission.CAMERA ->{
                    when (permissionState.status) {
                        PermissionStatus.Granted -> {
                            Text(text = "camera permission is Granted")
                        }
                        is PermissionStatus.Denied -> {
                            Column {
                                val text = if (permissionState.status.shouldShowRationale) {
                                    "allow"
                                } else {
                                    "deny"
                                }
                                Text(text = text)
                            }
                        }
                    }
                }
                android.Manifest.permission.RECORD_AUDIO -> {
                    when (permissionState.status) {
                        PermissionStatus.Granted -> {
                            androidx.compose.material3.Text(text = "record audio permission is Granted")
                        }
                        is PermissionStatus.Denied -> {
                            Column {
                                val text = if (permissionState.status.shouldShowRationale) {
                                    "allow"
                                } else {
                                    "deny"
                                }
                                androidx.compose.material3.Text(text = text)
                            }
                        }
                    }
                }
            }
        }
        Button(onClick = { permissionState.launchMultiplePermissionRequest() }) {
            Text(text = "get permission")
        }
    }
}



//多權限使用
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionSample3() {
    //android 11之後
    //先獲取前台ACCESS_FINE_LOCATION，才能獲取後台ACCESS_BACKGROUND_LOCATION
    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    val backgroundPermissionState = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
    )
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (permissionState.status) {
            PermissionStatus.Granted -> {
                Button(onClick = { backgroundPermissionState.launchPermissionRequest() }) {
                    Text(text = "get background location")
                }
                androidx.compose.material3.Text(text = "permission is Granted")
            }
            is PermissionStatus.Denied -> {
                Column {
                    val text = if (permissionState.status.shouldShowRationale) {
                        "allow"
                    } else {
                        "deny"
                    }
                    Text(text = text)
                }
            }
        }

        when(backgroundPermissionState.status) {
            PermissionStatus.Granted->{
                Text("background allow")
            }
            is PermissionStatus.Denied -> {
                Column {
                    val text = if (permissionState.status.shouldShowRationale) {
                        "background  allow"
                    } else {
                        "background deny"
                    }
                    Text(text = text)
                }
            }
        }
        Button(onClick = { permissionState.launchPermissionRequest() }) {
            Text(text = "get permission")
        }
    }

}
