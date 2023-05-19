package com.example.myapplication.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyVerticalGridSample() {
    val data = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    //GridCells.Adaptive(50.dp) Adaptive是自適應
    //GridCells.Fixed(3)固定三欄
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(data) {
            Card() {
                Text(
                    "Grid Item $it",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun LazyVerticalGridSamplePreview() {
    LazyVerticalGridSample()
}

