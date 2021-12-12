package com.danchoo.components.animation.navagation

import androidx.compose.animation.*
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry
import com.danchoo.components.animation.ANIMATION_DURATION


object ExitTransition {

    @OptIn(ExperimentalAnimationApi::class)
    val slideOutVertical: AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition =
        {
            slideOut(
                targetOffset = { IntOffset(0, it.height / 2) },
                animationSpec = tween(
                    durationMillis = ANIMATION_DURATION,
                    easing = LinearOutSlowInEasing
                )
            )
        }

    @OptIn(ExperimentalAnimationApi::class)
    val fadeOut: AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition =
        {
            fadeOut(
                animationSpec = tween(
                    durationMillis = ANIMATION_DURATION,
                    easing = LinearOutSlowInEasing
                )
            )
        }
}
