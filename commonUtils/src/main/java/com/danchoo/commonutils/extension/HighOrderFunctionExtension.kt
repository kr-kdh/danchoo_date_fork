package com.danchoo.commonutils.extension

import java.util.*
import kotlin.concurrent.schedule

private const val DEBOUNCE_DELAY_TIME = 200L

fun (() -> Unit).debounce(delayTime: Long = DEBOUNCE_DELAY_TIME): (() -> Unit) {
    var debounce = false
    return {
        if (!debounce) {
            debounce = true

            this()

            Timer().schedule(delayTime) {
                debounce = false
            }
        }
    }
}

fun <T : Any> ((arg0: T) -> Unit).debounce(
    delayTime: Long = DEBOUNCE_DELAY_TIME
): ((arg0: T) -> Unit) {
    var debounce = false
    return {
        if (!debounce) {
            debounce = true

            this(it)

            Timer().schedule(delayTime) {
                debounce = false
            }
        }
    }
}

fun <T : Any, R : Any> ((arg0: T, arg1: R) -> Unit).debounce(
    delayTime: Long = DEBOUNCE_DELAY_TIME
): ((arg0: T, arg1: R) -> Unit) {
    var debounce = false
    return { arg0, arg1 ->
        if (!debounce) {
            debounce = true

            this(arg0, arg1)

            Timer().schedule(delayTime) {
                debounce = false
            }
        }
    }
}


