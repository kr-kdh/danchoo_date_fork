package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.ui.components.main.CategoryEditorScreen
import com.danchoo.date.presentation.ui.components.main.MainRoute
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation


fun addCategoryEditorNavGraph(
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
        route = MainRoute.CATEGORY_EDITOR_ROUTE,
        startDestination = CategoryEditorScreen.CREATE
    ) {
        addComposable(modifier, navHostController)
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addComposable(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(
        route = CategoryEditorScreen.CREATE,
        enterTransition = EnterTransition.slideInVertical,
        exitTransition = ExitTransition.slideOutVertical
    ) {

        navController.enableOnBackPressed(true)
        CategoryEditorDestination(
            modifier = modifier,
            navController = navController
        )
    }
}

