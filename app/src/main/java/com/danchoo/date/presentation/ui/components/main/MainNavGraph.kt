package com.danchoo.date.presentation.ui.components.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.danchoo.date.presentation.ui.components.main.category.CategoryDestination
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

/**
 * Destinations used in the ([MainNavGraph]).
 */
object MainDestinations {
    const val MAIN_ROUTE = "main"
    const val CATEGORY_DETAIL_ROUTE = "categoryDetail"
}

object MainRouteArgsKeys {
    const val CATEGORY_DETAIL_ID = "categoryId"
}

@ExperimentalAnimationApi
@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {
    AnimatedNavHost(
        navController = navHostController.apply {
            // Backstack 을 저장하지 않기 위함.
            enableOnBackPressed(false)
        },
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = MainDestinations.MAIN_ROUTE,
            startDestination = MainSections.CATEGORY.route
        ) {

            addMainGraph(modifier, navHostController)
        }
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addMainGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(MainSections.CATEGORY.route) {
        CategoryDestination(modifier, navController)
    }

    composable(MainSections.FAVORITE.route) {
        CategoryDestination(modifier, navController)
    }

    composable(MainSections.SETTING.route) {
        CategoryDestination(modifier, navController)
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






