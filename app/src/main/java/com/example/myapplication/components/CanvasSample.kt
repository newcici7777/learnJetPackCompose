package com.example.myapplication.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun CanvasSample() {
    var imageBitmap: ImageBitmap? = null //圖形默認為空
    //拿到當前的context, 對當前context進行一些 操作
    with(LocalContext.current) {
        imageBitmap = ImageBitmap.imageResource(id = R.drawable.img1)
    }

    //第一參數設置畫布大小
    Canvas(modifier = Modifier.size(200.dp)) {
        //畫直線
        drawLine(
            Color.Yellow,
            start = Offset(0f, 10f), //線開始位置
            end = Offset(100f, 200f), //線結束位置
            strokeWidth = 10f, //線的寬度
            cap = StrokeCap.Round //線的二頭端點的形狀
        )
        //畫矩形
        drawRect(
            Color.Green,
            topLeft = Offset(100f, 200f),//開始位置
            size = Size(100f, 100f) //大小
        )
        //判斷不空，才在圖上畫圖
//        imageBitmap?.let{
//            //畫 圖形
//            drawImage(it )
//        }

        //圓角矩形，參數跟矩形差不多
        drawRoundRect(
            Color.Red,
            topLeft = Offset(100f, 200f),//開始位置
            size = Size(100f, 100f), //大小
            cornerRadius = CornerRadius(20f, 20f) // 圓角 默認是0 ， 0還是個矩形
        )

        //圓形
        drawCircle(
            Color.Blue,
            style = Stroke(width = 10f) //設置成外框
        )

        //預設是圓形
        drawOval(Color.Blue,
            size = Size(300f,200f))//寬度設大一點，高度設小一點就可以是oval

        //扇形
        drawArc(
            Color.Magenta,
            startAngle = 0f,//起始角度 0是水平面
            sweepAngle = 30f,//從0開始 向下滑出30的角度
            useCenter = true,//設置中間為圓點
            style = Stroke(20f) //樣式
        )

        //
        drawPoints(
            listOf(
                Offset(10f,10f),
                Offset(20f,50f),
                Offset(40f,60f),
                Offset(60f,100f)
            ),
            pointMode = PointMode.Lines, // 每二個點連起來
            //PointMode.Polygon每個點都連起來
            //PointMode.Point由每個點連起來
            color = Color.Magenta
        )
    }
}

@Preview
@Composable
fun CanvasSamplePreview() {
    CanvasSample()
}

