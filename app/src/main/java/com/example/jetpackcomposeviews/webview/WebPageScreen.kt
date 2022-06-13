package com.example.jetpackcomposeviews.webview

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposeviews.webview.view.UrlScreen
import com.example.jetpackcomposeviews.webview.view.WebViewScreen

@Composable
fun WebPageScreen() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "url") {
        composable("url") {
            UrlScreen(navController = navHostController)
        }
        composable(
            "webview/{url}",
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                }
            )
        ) {
            it.arguments?.getString("url")?.let { url ->
                WebViewScreen(url = url)
            }
        }
    }
}