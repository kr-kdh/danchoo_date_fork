package com.danchoo.date.presentation.common.extension

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
fun NavBackStackEntry.lifecycleIsResumed(block: () -> Unit) {
    if (this.lifecycle.currentState == Lifecycle.State.RESUMED) {
        block()
    }
}

fun NavBackStackEntry.lifecycleIsCreated(block: () -> Unit) {
    if (this.lifecycle.currentState == Lifecycle.State.CREATED) {
        block()
    }
}