package com.danchoo.date.presentation.utils.extension

import androidx.navigation.NavController
import kotlin.contracts.ExperimentalContracts

@OptIn(ExperimentalContracts::class)
fun NavController.launchResumed(block: NavController.() -> Unit) {
    with(this) {
        if (currentBackStackEntry?.lifecycle?.currentState == androidx.lifecycle.Lifecycle.State.RESUMED) {
            block()
        }
    }
}