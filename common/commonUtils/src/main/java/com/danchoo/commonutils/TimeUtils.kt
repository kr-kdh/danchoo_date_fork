package com.danchoo.commonutils

import android.os.Build
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

object TimeUtils {

    fun getCurrentRealTimestamp(): Long {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter.ISO_INSTANT.format(Instant.now())?.toLong() ?: Date().time
        } else {
            Date().time
        }
    }
}