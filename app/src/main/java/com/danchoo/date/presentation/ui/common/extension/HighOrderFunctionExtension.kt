package com.danchoo.date.presentation.ui.common.extension

import android.util.Log
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

fun <T: Any> ((item: T) -> Unit).debounce(delayTime: Long = DEBOUNCE_DELAY_TIME): ((item: T) -> Unit) {
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
