package com.danchoo.date.presentation.ui.components.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.danchoo.date.presentation.ui.components.main.editor.category.addCategoryEditorNavGraph
import com.danchoo.date.presentation.ui.components.main.home.addHomeNavGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


@ExperimentalAnimationApi
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = MainRoute.HOME_ROUTE,
) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        addHomeNavGraph(modifier, navHostController, this)

        addCategoryEditorNavGraph(modifier, navHostController, this)
    }
}


@ExperimentalAnimationApi
fun NavGraphBuilder.addCategoryDetail(upPress: () -> Unit) {
    composable(
        "${MainRoute.CATEGORY_DETAIL_ROUTE}/{${MainRouteArgsKeys.CATEGORY_DETAIL_ID}}",
        arguments = listOf(navArgument(MainRouteArgsKeys.CATEGORY_DETAIL_ID) {
            type = NavType.LongType
        }),
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
        }
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val categoryId = arguments.getLong(MainRouteArgsKeys.CATEGORY_DETAIL_ID)

//        ContentListApp(categoryId = categoryId, upPress = upPress)
    }
}

