package com.danchoo.date.presentation.home.category.editor.graph

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.CategoryEditorScreen
import com.danchoo.date.presentation.MainRoute
import com.danchoo.date.presentation.common.gallery.domain.model.GALLERY_ITEM_MODEL
import com.danchoo.date.presentation.common.gallery.domain.model.GalleryItemModel
import com.danchoo.date.presentation.home.category.editor.CategoryEditorActions
import com.danchoo.date.presentation.home.category.editor.CategoryEditorScreen
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation


fun NavGraphBuilder.addCategoryEditorNavGraph(
    modifier: Modifier,
    navHostController: NavHostController,
    actions: CategoryEditorActions
) {
    navigation(
        route = MainRoute.CATEGORY_EDITOR_ROUTE,
        startDestination = CategoryEditorScreen.CREATE
    ) {
        composable(
            route = CategoryEditorScreen.CREATE,
            enterTransition = EnterTransition.slideInVertical,
            exitTransition = ExitTransition.slideOutVertical
        ) {
            val galleryItemModel: GalleryItemModel? =
                navHostController
                    .currentBackStackEntry
                    ?.savedStateHandle
                    ?.get(GALLERY_ITEM_MODEL)

            navHostController
                .currentBackStackEntry
                ?.savedStateHandle
                ?.set(GALLERY_ITEM_MODEL, null)

            CategoryEditorScreen(
                modifier = modifier,
                navController = navHostController,
                galleryItemModel = galleryItemModel,
                moveToGallery = { actions.moveToGallery() }
            )
        }
    }
}

