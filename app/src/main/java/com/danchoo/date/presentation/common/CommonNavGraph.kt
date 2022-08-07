package com.danchoo.date.presentation.common

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.danchoo.components.animation.navagation.EnterTransition
import com.danchoo.components.animation.navagation.ExitTransition
import com.danchoo.date.presentation.CommonScreen
import com.danchoo.date.presentation.common.gallery.GalleryScreen
import com.danchoo.date.presentation.common.tag.TagListScreen
import com.google.accompanist.navigation.animation.composable


fun NavGraphBuilder.addCommonComposable(
    modifier: Modifier,
    navHostController: NavHostController,
) {
    composable(
        route = CommonScreen.GALLERY,
        enterTransition = EnterTransition.slideInVertical,
        exitTransition = ExitTransition.slideOutVertical
    ) {
        GalleryScreen(
            modifier = modifier,
            navController = navHostController
        )
    }

    composable(
        route = CommonScreen.TAG_LIST,
        enterTransition = EnterTransition.slideInVertical,
        exitTransition = ExitTransition.slideOutVertical
    ) {
        TagListScreen(
            modifier = modifier,
            onClickBack = {

            }
        )
    }
}
