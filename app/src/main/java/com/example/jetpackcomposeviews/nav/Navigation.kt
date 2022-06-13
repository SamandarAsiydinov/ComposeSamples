package com.example.jetpackcomposeviews.nav

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun MyNavigation() {
    val animDur = 800
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = "screen_one"
    ) {
        composable(
            "screen_one",
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "screen_two" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    "screen_two" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "screen_two" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    "screen_two" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            }
        ) {
            ScreenOne(navController)
        }

        //Second Screen
        composable(
            "screen_two",
            enterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "screen_one" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            exitTransition = { _, target ->
                when (target.destination.route) {
                    "screen_one" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            popEnterTransition = { initial, _ ->
                when (initial.destination.route) {
                    "screen_one" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            },
            popExitTransition = { _, target ->
                when (target.destination.route) {
                    "screen_one" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(animDur)
                        )
                    else -> null
                }
            }
        ) {
            ScreenTwo(navController)
        }
    }
}