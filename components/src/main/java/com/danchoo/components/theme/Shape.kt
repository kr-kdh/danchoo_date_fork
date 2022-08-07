package com.danchoo.components.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(50)
)

object ShapeSize {
    val smallest = 56.dp
    val small = 96.dp
    val medium = 128.dp
    val large = 192.dp
    val xlarge = 256.dp
    val xxlarge = 384.dp
}


object BorderWidth {
    val borderHarf = 0.5.dp
    val borderBase = 1.dp
    val borderMedium = 2.dp
    val borderLarge = 4.dp
    val borderLargest = 8.dp
}