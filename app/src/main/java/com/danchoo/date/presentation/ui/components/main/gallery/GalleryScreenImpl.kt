package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.gallery.GalleryContract.GalleryViewState

@Composable
fun GalleryScreenImpl(
    modifier: Modifier,
    viewState: GalleryViewState,
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
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = modifier.padding(it)
        ) {
            items(viewState.galleryItemList) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = rememberAsyncImagePainter(model = it.uri, FilterQuality.None),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun GalleryItem() {
    Image(
        painter = rememberImagePainter(data = Icons.Filled.ArrowBack),
        contentDescription = null
    )
}