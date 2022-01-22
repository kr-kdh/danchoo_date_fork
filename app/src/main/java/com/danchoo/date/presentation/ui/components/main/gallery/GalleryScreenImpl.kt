package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.gallery.GalleryContract.GalleryViewState
import com.danchoo.date.presentation.ui.components.main.gallery.domain.model.GalleryItemModel
import com.danchoo.glideimage.GlideImage

@Composable
fun GalleryScreenImpl(
    modifier: Modifier,
    viewState: GalleryViewState,
    pagingItems: LazyPagingItems<GalleryItemModel>,
    onViewEvent: OnViewEvent
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            BackTopAppBar(
                title = { Text(text = "") },
                onClickBack = {

                },
                actions = {
                    TextButton(onClick = {}) {
                        Text(text = stringResource(id = R.string.confirm))
                    }
                }
            )
        },
        snackbarHost = {}
    ) {

        BoxWithConstraints(modifier = modifier.fillMaxSize()) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                modifier = modifier.padding(it)
            ) {
                items(pagingItems.itemCount) { index ->
                    GlideImage(
                        modifier = Modifier.size(maxWidth / 3),
                        data = pagingItems[index]?.uri ?: "",
                        placeHolder = R.drawable.ic_launcher_background,
                        size = maxWidth / 3,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}