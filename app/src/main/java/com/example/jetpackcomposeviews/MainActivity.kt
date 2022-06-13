package com.example.jetpackcomposeviews

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeviews.chip.ChipScreen
import com.example.jetpackcomposeviews.coil.ImageLoaderScreen
import com.example.jetpackcomposeviews.collapse.CollapseActionBar
import com.example.jetpackcomposeviews.flip.FlipScreen
import com.example.jetpackcomposeviews.floating.FloatingActionBtn
import com.example.jetpackcomposeviews.list_item.FruitScreen
import com.example.jetpackcomposeviews.music.MusicPlayScreen
import com.example.jetpackcomposeviews.nav.MyNavigation
import com.example.jetpackcomposeviews.ui.theme.JetpackComposeViewsTheme
import com.example.jetpackcomposeviews.weather.WeatherScreen
import com.example.jetpackcomposeviews.webview.WebPageScreen
import com.example.jetpackcomposeviews.webview.view.UrlScreen
import com.example.jetpackcomposeviews.zoom_image.ZoomImage

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {
            JetpackComposeViewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageLoaderScreen()
                    //FlipScreen()
                    //WebPageScreen()
                }
            }
        }
    }
}
//ZoomImage()
//MusicPlayScreen()
//CollapseActionBar()
//WeatherScreen()
// ChipScreen()
//FruitScreen()
// MyNavigation()
//FloatingActionBtn()