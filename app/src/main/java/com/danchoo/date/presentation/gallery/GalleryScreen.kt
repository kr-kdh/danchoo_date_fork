package com.danchoo.date.presentation.gallery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.common.extension.launchResumed
import com.danchoo.date.presentation.gallery.GalleryContract.GalleryViewEvent
import com.danchoo.date.presentation.gallery.domain.model.GALLERY_ITEM_MODEL

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
            is GalleryViewEvent.OnClickBackPress -> {
                navController.launchResumed {
                    navController.popBackStack()
                }
            }
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