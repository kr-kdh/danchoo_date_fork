package com.danchoo.components.animation.navagation

import androidx.compose.animation.*
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavBackStackEntry
import com.danchoo.components.animation.ANIMATION_DURATION


object EnterTransition {

    @OptIn(ExperimentalAnimationApi::class)
    val slideInVertical: AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition =
        {
            slideIn(
                initialOffset = { IntOffset(0, it.height / 2) },
                animationSpec = tween(
                    durationMillis = ANIMATION_DURATION,
                    easing = LinearOutSlowInEasing
                )
            )
        }

    @OptIn(ExperimentalAnimationApi::class)
    val fadeIn: AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition =
        {
            fadeIn(animationSpec = tween(ANIMATION_DURATION))
        }
}
