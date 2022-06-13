package com.example.jetpackcomposeviews.flip

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun FlipScreen() {
    var flipCard by remember { mutableStateOf(FlipCard.Forward) }

    FlipRotate(
        flipCard = flipCard,
        onClick = { flipCard = flipCard.next },
        modifier = Modifier
            .fillMaxWidth(.6f)
            .aspectRatio(1f),
        forward = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "home",
                    modifier = Modifier.size(120.dp)
                )
            }
        },
        previous = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "s",
                    modifier = Modifier.size(120.dp)
                )
            }
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun FlipRotate(
    flipCard: FlipCard,
    onClick: (FlipCard) -> Unit,
    modifier: Modifier = Modifier,
    previous: @Composable () -> Unit = {},
    forward: @Composable () -> Unit = {}
) {
    val rotation = animateFloatAsState(
        targetValue = flipCard.angle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            onClick = { onClick(flipCard) },
            modifier = modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationY = rotation.value
                    cameraDistance = 12f * density
                },
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            if (rotation.value <= 90f) {
                Box(modifier = Modifier.fillMaxSize()) {
                    forward()
                }
            } else {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer { rotationY = 180f }) {
                    previous()
                }
            }
        }
    }
}