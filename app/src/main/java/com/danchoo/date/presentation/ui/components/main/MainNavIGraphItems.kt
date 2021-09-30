package com.danchoo.date.presentation.ui.components.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.danchoo.date.presentation.ui.components.main.category.Category
import com.google.accompanist.navigation.animation.composable


@ExperimentalAnimationApi
fun NavGraphBuilder.addMainGraph(
    modifier: Modifier = Modifier,
    onSelected: (Long, NavBackStackEntry) -> Unit
) {
    composable(MainSections.CATEGORY.route) { from ->
        Category(modifier = modifier) {
            onSelected(it, from)
        }
    }
    composable(MainSections.FAVORITE.route) { from ->
        Category(modifier = modifier) {
            onSelected(it, from)
        }
    }
    composable(MainSections.SETTING.route) { from ->
        Category(modifier = modifier) {
            onSelected(it, from)
        }
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addCategoryDetail(upPress: () -> Unit) {
    composable(
        "${MainDestinations.CATEGORY_DETAIL_ROUTE}/{${MainRouteArgsKeys.CATEGORY_DETAIL_ID}}",
        arguments = listOf(navArgument(MainRouteArgsKeys.CATEGORY_DETAIL_ID) {
            type = NavType.LongType
        }),
        enterTransition = { _, _ ->
            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
        }
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val categoryId = arguments.getLong(MainRouteArgsKeys.CATEGORY_DETAIL_ID)

//        ContentListApp(categoryId = categoryId, upPress = upPress)
    }
}