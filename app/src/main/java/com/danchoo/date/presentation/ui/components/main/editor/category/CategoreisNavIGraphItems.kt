package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalCoilApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.addCategoriesEditorNavGraph(
    modifier: Modifier = Modifier,
    onSelected: (Long, NavBackStackEntry) -> Unit
) {
    composable(CategoriesEditorSections.CREATE) { from ->

    }

    composable(
        "${CategoriesEditorSections.CREATE}/{${CategoriesArgsKeys.CATEGORY_ID_KEY}}",
        arguments = listOf(navArgument(CategoriesArgsKeys.CATEGORY_ID_KEY) {
            type = NavType.StringType
        })
    ) { from ->
        val arguments = requireNotNull(from.arguments)
        val contentsId = arguments.getString(CategoriesArgsKeys.CATEGORY_ID_KEY)
    }
}
