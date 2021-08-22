package com.danchoo.date.presentation.ui.components.main

import android.app.Activity
import android.util.Log
import androidx.annotation.FloatRange
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.os.ConfigurationCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.common.Surface
import com.danchoo.date.presentation.ui.theme.BottomNavIndicatorShape
import com.danchoo.date.presentation.ui.theme.MainTheme
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme
import com.google.accompanist.insets.navigationBarsPadding
import androidx.compose.ui.util.lerp


enum class MainSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    CATEGORY(R.string.fragment_category_nav_title, Icons.Outlined.Home, "main/category"),
    FAVORITE(R.string.fragment_favorite_nav_title, Icons.Outlined.Search, "main/favorite"),
    SETTING(R.string.fragment_setting_nav_title, Icons.Outlined.ShoppingCart, "main/setting"),
}


@Composable
fun MainBottomBar(
    navController: NavController,
    tabs: Array<MainSections>,
    color: Color = MainTheme.colors.primary,
    contentColor: Color = MainTheme.colors.textPrimary
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val sections = remember { MainSections.values() }
    val routes = remember { sections.map { it.route } }
    if (currentRoute in routes) {
        val currentSection = sections.first { it.route == currentRoute }
        Surface(
            color = color,
            contentColor = contentColor
        ) {
            val springSpec = SpringSpec<Float>(
                // Determined experimentally
                stiffness = 800f,
                dampingRatio = 0.8f
            )

            MainBottomNavLayout(
                selectedIndex = currentSection.ordinal,
                itemCount = routes.size,
                indicator = { MainBottomNavIndicator() },
                animSpec = springSpec,
                modifier = Modifier.navigationBarsPadding(start = false, end = false)
            ) {
                MainTabItems(
                    navController = navController,
                    tabs = tabs,
                    currentSection = currentSection,
                    springSpec = springSpec,
                    currentRoute = currentRoute
                )
            }
        }
    }

//    val navBackStackEntry by navController.currentBackStackEntryAsState()


}

@Composable
private fun MainTabItems(
    navController: NavController,
    tabs: Array<MainSections>,
    currentSection: MainSections,
    springSpec: SpringSpec<Float>,
    currentRoute: String?
) {
    tabs.forEach { section ->
        val selected = section == currentSection
        val tint by animateColorAsState(
            if (selected) {
                MainTheme.colors.textPrimary
            } else {
                MainTheme.colors.textSecondary
            }
        )

        MainBottomNavigationItem(
            icon = {
                Icon(
                    imageVector = section.icon,
                    tint = tint,
                    contentDescription = null
                )
            },
            text = {
                Text(
                    text = stringResource(section.title).uppercase(
                        ConfigurationCompat.getLocales(
                            LocalConfiguration.current
                        ).get(0)
                    ),
                    color = tint,
                    style = MaterialTheme.typography.button,
                    maxLines = 1
                )
            },
            selected = selected,
            onSelected = {
                if (section.route != currentRoute) {
                    navController.navigate(section.route) {
                        launchSingleTop = true
                        restoreState = true
                        /**
                         *  navController.enableOnBackPressed(true) -> 으로 설정 했을 때
                         *  Back Press 를 눌렀을 때 root 로 가기 위해서 아래 주석을 제거
                         */
                        popUpTo(findStartDestination(navController.graph).id) {
                            saveState = true
                        }
                    }
                }
            },
            animSpec = springSpec,
            modifier = BottomNavigationItemPadding.clip(BottomNavIndicatorShape)
        )
    }
}


@Composable
private fun MainBottomNavLayout(
    selectedIndex: Int,
    itemCount: Int,
    animSpec: AnimationSpec<Float>,
    indicator: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Track how "selected" each item is [0, 1]
    val selectionFractions = remember(itemCount) {
        List(itemCount) { i ->
            Animatable(if (i == selectedIndex) 1f else 0f)
        }
    }
    selectionFractions.forEachIndexed { index, selectionFraction ->
        val target = if (index == selectedIndex) 1f else 0f
        LaunchedEffect(target, animSpec) {
            selectionFraction.animateTo(target, animSpec)
        }
    }

    // Animate the position of the indicator
    val indicatorIndex = remember { Animatable(0f) }
    val targetIndicatorIndex = selectedIndex.toFloat()
    LaunchedEffect(targetIndicatorIndex) {
        indicatorIndex.animateTo(targetIndicatorIndex, animSpec)
    }

    Layout(
        modifier = modifier.height(BottomNavHeight),
        content = {
            content()
            Box(Modifier.layoutId("indicator"), content = indicator)
        }
    ) { measurables, constraints ->
        check(itemCount == (measurables.size - 1)) // account for indicator

        // Divide the width into n+1 slots and give the selected item 2 slots
        val unselectedWidth = constraints.maxWidth / (itemCount + 1)
        val selectedWidth = 2 * unselectedWidth
        val indicatorMeasurable = measurables.first { it.layoutId == "indicator" }

        val itemPlaceables = measurables
            .filterNot { it == indicatorMeasurable }
            .mapIndexed { index, measurable ->
                // Animate item's width based upon the selection amount
                val width = lerp(unselectedWidth, selectedWidth, selectionFractions[index].value)
                measurable.measure(
                    constraints.copy(
                        minWidth = width,
                        maxWidth = width
                    )
                )
            }
        val indicatorPlaceable = indicatorMeasurable.measure(
            constraints.copy(
                minWidth = selectedWidth,
                maxWidth = selectedWidth
            )
        )

        layout(
            width = constraints.maxWidth,
            height = itemPlaceables.maxByOrNull { it.height }?.height ?: 0
        ) {
            val indicatorLeft = indicatorIndex.value * unselectedWidth
            indicatorPlaceable.placeRelative(x = indicatorLeft.toInt(), y = 0)
            var x = 0
            itemPlaceables.forEach { placeable ->
                placeable.placeRelative(x = x, y = 0)
                x += placeable.width
            }
        }
    }
}

@Composable
private fun MainBottomNavIndicator(
    strokeWidth: Dp = 2.dp,
    color: Color = MainTheme.colors.textPrimary,
    shape: Shape = BottomNavIndicatorShape
) {
    Spacer(
        modifier = Modifier
            .fillMaxSize()
            .then(BottomNavigationItemPadding)
            .border(strokeWidth, color, shape)
    )
}


@Composable
fun MainBottomNavigationItem(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    selected: Boolean,
    onSelected: () -> Unit,
    animSpec: AnimationSpec<Float>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.selectable(selected = selected, onClick = onSelected),
        contentAlignment = Alignment.Center
    ) {
        // Animate the icon/text positions within the item based on selection
        val animationProgress by animateFloatAsState(if (selected) 1f else 0f, animSpec)
        MainBottomNavItemLayout(
            icon = icon,
            text = text,
            animationProgress = animationProgress
        )
    }
}

@Composable
private fun MainBottomNavItemLayout(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
) {
    Layout(
        content = {
            Box(
                modifier = Modifier
                    .layoutId("icon")
                    .padding(horizontal = TextIconSpacing),
                content = icon
            )
            val scale = lerp(0.6f, 1f, animationProgress)
            Box(
                modifier = Modifier
                    .layoutId("text")
                    .padding(horizontal = TextIconSpacing)
                    .graphicsLayer {
                        alpha = animationProgress
                        scaleX = scale
                        scaleY = scale
                        transformOrigin = BottomNavLabelTransformOrigin
                    },
                content = text
            )
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)
        val textPlaceable = measurables.first { it.layoutId == "text" }.measure(constraints)

        placeTextAndIcon(
            textPlaceable,
            iconPlaceable,
            constraints.maxWidth,
            constraints.maxHeight,
            animationProgress
        )
    }
}

private fun MeasureScope.placeTextAndIcon(
    textPlaceable: Placeable,
    iconPlaceable: Placeable,
    width: Int,
    height: Int,
    @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
): MeasureResult {
    val iconY = (height - iconPlaceable.height) / 2
    val textY = (height - textPlaceable.height) / 2

    val textWidth = textPlaceable.width * animationProgress
    val iconX = (width - textWidth - iconPlaceable.width) / 2
    val textX = iconX + iconPlaceable.width

    return layout(width, height) {
        iconPlaceable.placeRelative(iconX.toInt(), iconY)
        if (animationProgress != 0f) {
            textPlaceable.placeRelative(textX.toInt(), textY)
        }
    }
}


private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)


private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val BottomNavLabelTransformOrigin = TransformOrigin(0f, 0.5f)
private val TextIconSpacing = 2.dp
private val BottomNavHeight = 56.dp
private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

@Preview
@Composable
private fun MainBottomNavPreview() {
    MyApplicationTheme {
        MainBottomBar(
            navController = rememberNavController(),
            tabs = MainSections.values()
        )
    }
}
