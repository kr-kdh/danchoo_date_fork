package com.danchoo.components.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacing {
    /**
     * Icons, type, and some elements within components can align to a 4dp grid.
     */
    val baseLineSpacingSmall: Dp = 4.dp

    /**
     * https://material.io/design/layout/spacing-methods.html#spacing
     * All components align to an 8dp square baseline grid for mobile, tablet, and desktop.
     */
    val baseLineSpacing: Dp = 8.dp

    val baseLineSpacingMedium: Dp = 16.dp

    val baseLineSpacingLarge: Dp = 24.dp

    val baseLineSpacingLargest: Dp = 48.dp
}