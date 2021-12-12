package com.danchoo.date.presentation.ui.components.main.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.ui.components.main.HomeScreen
import com.danchoo.date.presentation.ui.components.main.MainRoute
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryDestination
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
        navController.enableOnBackPressed(false)
        CategoryDestination(modifier, navController)
    }

    composable(HomeScreen.FAVORITE.route) {
        navController.enableOnBackPressed(false)
        CategoryDestination(modifier, navController)
    }

    composable(HomeScreen.SETTING.route) {
        navController.enableOnBackPressed(false)
        CategoryDestination(modifier, navController)
    }
}
