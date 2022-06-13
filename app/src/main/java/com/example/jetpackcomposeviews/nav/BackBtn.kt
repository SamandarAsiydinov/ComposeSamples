package com.example.jetpackcomposeviews.nav

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavController

@Composable
fun BackButton(
    navController: NavController
) {
    if (navController.currentBackStackEntry == LocalLifecycleOwner.current
        && navController.previousBackStackEntry != null
    ) {
        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.wrapContentWidth()
        ) {
            Text(text = "Back")
        }
    }
}