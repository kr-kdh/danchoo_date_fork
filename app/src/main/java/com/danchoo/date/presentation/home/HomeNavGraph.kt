package com.danchoo.date.presentation.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.HomeScreen
import com.danchoo.date.presentation.MainRoute
import com.danchoo.date.presentation.home.category.CategoryScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation

fun addHomeNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.addGraph(modifier, navHostController)
}

private fun NavGraphBuilder.addGraph(
    modifier: Modifier,
    navHostController: NavHostController
) {
    navigation(
        route = MainRoute.HOME_ROUTE,
        startDestination = HomeScreen.CATEGORY.route
    ) {
        addComposable(modifier, navHostController)
    }
}

private fun NavGraphBuilder.addComposable(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(
        route = HomeScreen.CATEGORY.route,
        enterTransition = EnterTransition.fadeIn,
        exitTransition = ExitTransition.fadeOut
    ) {
        CategoryScreen(modifier, navController)
    }

    composable(HomeScreen.FAVORITE.route) {
        CategoryScreen(modifier, navController)
    }

    composable(HomeScreen.SETTING.route) {
        CategoryScreen(modifier, navController)
    }
}
