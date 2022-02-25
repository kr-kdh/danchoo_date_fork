package com.danchoo.date.presentation.common.gallery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.common.gallery.GalleryContract.GalleryViewEvent
import com.danchoo.date.presentation.common.gallery.domain.model.GALLERY_ITEM_MODEL
import com.danchoo.date.presentation.utils.extension.launchResumed

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