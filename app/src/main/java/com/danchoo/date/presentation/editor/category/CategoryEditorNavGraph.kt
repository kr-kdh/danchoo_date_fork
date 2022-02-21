package com.danchoo.date.presentation.editor.category

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.CategoryEditorScreen
import com.danchoo.date.presentation.MainRoute
import com.danchoo.date.presentation.gallery.GalleryScreen
import com.danchoo.date.presentation.gallery.domain.model.GALLERY_ITEM_MODEL
import com.danchoo.date.presentation.gallery.domain.model.GalleryItemModel
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

private fun NavGraphBuilder.addComposable(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(
        route = CategoryEditorScreen.CREATE,
        enterTransition = EnterTransition.slideInVertical,
        exitTransition = ExitTransition.slideOutVertical
    ) {
        val galleryItemModel: GalleryItemModel? =
            navController
                .currentBackStackEntry
                ?.savedStateHandle
                ?.get(GALLERY_ITEM_MODEL)

        navController
            .currentBackStackEntry
            ?.savedStateHandle
            ?.set(GALLERY_ITEM_MODEL, null)

        CategoryEditorScreen(
            modifier = modifier,
            navController = navController,
            galleryItemModel = galleryItemModel
        )
    }

    composable(
        route = CategoryEditorScreen.GALLERY,
        enterTransition = EnterTransition.slideInVertical,
        exitTransition = ExitTransition.slideOutVertical
    ) {
        GalleryScreen(
            modifier = modifier,
            navController = navController
        )
    }


}

