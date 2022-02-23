package com.danchoo.date.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.danchoo.date.presentation.editor.category.addCategoryEditorNavGraph
import com.danchoo.date.presentation.home.addHomeNavGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable


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
