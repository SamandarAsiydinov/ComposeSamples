package com.example.jetpackcomposeviews.weather

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeviews.R

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun WeatherScreen() {
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)

    Image(
        painter = painterResource(id = R.drawable.img_w),
        contentDescription = "Weather",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_notes_24),
                contentDescription = "Image",
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = "Weather",
                color = Color.White,
                fontSize = 18.sp,
                style = TextStyle(
                    fontFamily = FontFamily.Serif
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_add_location_24),
                contentDescription = "",
                modifier = Modifier.size(25.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Andijan",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontFamily = FontFamily.Serif
            )
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = Calendar.getInstance().time.toString(),
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            style = TextStyle(
                fontFamily = FontFamily.Serif
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "40°C+",
            color = Color.White,
            fontSize = 70.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontFamily = FontFamily.Serif
            )
        )
        Canvas(modifier = Modifier.fillMaxWidth(0.5f)) {
            drawLine(
                color = Color.White,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                pathEffect = pathEffect,
                strokeWidth = 8f
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Sunny",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontFamily = FontFamily.Serif
            )
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "38°C / 18°c",
            color = Color.White,
            fontSize = 20.sp,
            style = TextStyle(
                fontFamily = FontFamily.Serif
            )
        )
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                    contentDescription = "null",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "35°C / 23°C",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_cloud_24),
                    contentDescription = "image",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "14°C",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif
                    )
                )
                Text(
                    text = "Saturday",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_cloud_queue_24),
                    contentDescription = "img",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "3°C",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif
                    )
                )
                Text(
                    text = "Sunday",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .width(80.dp)
                .height(20.dp)
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_up_24),
                contentDescription = "Key",
                modifier = Modifier.size(20.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}