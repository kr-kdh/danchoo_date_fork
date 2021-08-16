package com.danchoo.date.presentation.common.extension

import android.content.Context
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.Display
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context.dpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, dp,
        resources.displayMetrics
    )
}

fun Context.spToPx(sp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, resources.displayMetrics)
}

fun Context.getColorDrawable(res: Int): ColorDrawable {
    return ColorDrawable(ContextCompat.getColor(this, res))
}

fun Context.getColorInt(res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.drawable(res: Int): Drawable? {
    return ContextCompat.getDrawable(this, res)
}

fun Context.getStatusHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")

    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }

    return result
}

fun Context.getNavigationHeight(): Int {
    val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    val hasMenuKey = id > 0 && resources.getBoolean(id)

    val navigationHeight = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (navigationHeight > 0 && hasMenuKey) resources.getDimensionPixelSize(navigationHeight) else 0
}

fun Context.getNavigationBarSize(): Point {
    val appUsableSize = getAppUsableScreenSize()
    val realScreenSize = getRealScreenSize()

    // navigation bar on the right
    if (appUsableSize.x < realScreenSize.x) {
        return Point(realScreenSize.x - appUsableSize.x, appUsableSize.y)
    }

    // navigation bar at the bottom
    return if (appUsableSize.y < realScreenSize.y) {
        Point(appUsableSize.x, realScreenSize.y - appUsableSize.y)
    } else Point()
    // navigation bar is not present
}

fun Context.getAppUsableScreenSize(): Point {
    val windowManager: WindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display: Display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}

fun Context.getRealScreenSize(): Point {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getRealSize(size)
    return size
}

fun Context.toast(text: String, duration: Int) {
    Toast.makeText(this, text, duration).show()
}

fun Context.toast(@StringRes res: Int, duration: Int) {
    Toast.makeText(this, res, duration).show()
}