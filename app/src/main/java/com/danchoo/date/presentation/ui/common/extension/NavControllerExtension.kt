package com.danchoo.date.presentation.ui.common.extension

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun NavController.launchResumed(block: NavController.() -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    if (currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
        block()
    }
}