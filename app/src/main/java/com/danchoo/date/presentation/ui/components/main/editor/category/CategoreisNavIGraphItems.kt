package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addCategoriesEditorNavGraph(
    modifier: Modifier = Modifier,
    onSelected: (Long, NavBackStackEntry) -> Unit
) {
    composable(CategoriesEditorSections.CREATE) { from ->
        CategoriesCreate(modifier)
    }
}
