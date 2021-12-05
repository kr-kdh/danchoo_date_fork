package com.danchoo.components.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val RoundedCornerShape50percent = RoundedCornerShape(percent = 50)

val RoundedCornerShape4percent = RoundedCornerShape(percent = 4)
val RoundedCornerShape8percent = RoundedCornerShape(percent = 4)
val RoundedCornerShape16percent = RoundedCornerShape(percent = 4)
val RoundedCornerShape32percent = RoundedCornerShape(percent = 4)

val RoundedCornerShape4dp = RoundedCornerShape(size = 4.dp)
val RoundedCornerShape8dp = RoundedCornerShape(size = 8.dp)
val RoundedCornerShape16dp = RoundedCornerShape(size = 16.dp)
val RoundedCornerShape32dp = RoundedCornerShape(size = 32.dp)


object CardViewShape {
    val startImageShape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
    val endImageShape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)
    val middleImageShape = RoundedCornerShape(0.dp)
}


object BorderWidth {
    val borderHarf = 0.5.dp
    val borderBase = 1.dp
    val borderMedium = 1.5.dp
    val borderLarge = 2.dp
    val borderLargest = 4.dp
}