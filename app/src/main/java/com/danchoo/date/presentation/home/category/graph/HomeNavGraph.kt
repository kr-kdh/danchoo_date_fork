package com.danchoo.date.presentation.home.category.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.HomeScreen
import com.danchoo.date.presentation.MainRoute
import com.danchoo.date.presentation.home.category.CategoryScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation


fun NavGraphBuilder.addHomeNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
    actions: HomeNavActions
) {
    navigation(
        route = MainRoute.HOME_ROUTE,
        startDestination = HomeScreen.CATEGORY.route
    ) {
        composable(
            route = HomeScreen.CATEGORY.route,
            enterTransition = EnterTransition.fadeIn,
            exitTransition = ExitTransition.fadeOut
        ) {
            CategoryScreen(
                modifier = modifier,
                onClickCategoryAdd = {
                    actions.onClickCategoryAdd()
                },
                onClickCategory = { categoryId ->
                    actions.onClickCategory(categoryId)
                }
            )
        }

        composable(HomeScreen.FAVORITE.route) {
            CategoryScreen(modifier)
        }

        composable(HomeScreen.SETTING.route) {
            CategoryScreen(modifier)
        }
    }
}
