package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.ui.common.extension.launchResumed
import com.danchoo.date.presentation.ui.components.main.gallery.GalleryContract.GalleryViewEvent
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GALLERY_ITEM_MODEL

@Composable
fun GalleryScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: GalleryViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.value

    val pagingItems = viewModel.galleryPagingItems().collectAsLazyPagingItems()

    GalleryScreenImpl(
        modifier = modifier,
        viewState = viewState,
        pagingItems = pagingItems
    ) { viewEvent ->
        when (viewEvent) {
            is GalleryViewEvent.OnClickBackPress -> {}
            is GalleryViewEvent.OnClickGalleryItem -> {
                navController.launchResumed {
                    navController.previousBackStackEntry?.savedStateHandle?.set(
                        GALLERY_ITEM_MODEL,
                        viewEvent.galleryItem
                    )
                    navController.popBackStack()
                }
            }
        }
    }
}