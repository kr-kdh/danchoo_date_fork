package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.gallery.GalleryContract.GalleryViewEvent
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
                    onViewEvent(GalleryViewEvent.OnClickBackPress)
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
        GalleryContents(
            modifier = modifier.padding(it),
            pagingItems = pagingItems
        ) { galleryItemModel ->
            onViewEvent(GalleryViewEvent.OnClickGalleryItem(galleryItemModel))
        }
    }
}

@Composable
fun GalleryContents(
    modifier: Modifier = Modifier,
    pagingItems: LazyPagingItems<GalleryItemModel>,
    onClick: (GalleryItemModel) -> Unit
) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = modifier,
            contentPadding = PaddingValues(2.dp)
        ) {
            items(pagingItems.itemCount) { index ->
                GalleryItem(
                    modifier = modifier
                        .size(maxWidth / 3)
                        .clickable { pagingItems[index]?.let(onClick) }
                ) {
                    GlideImage(
                        modifier = Modifier.fillMaxSize(),
                        data = pagingItems[index]?.uri ?: "",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
fun GalleryItem(
    modifier: Modifier = Modifier,
    check: (@Composable BoxScope.() -> Unit)? = null,
    contents: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            )
    ) {
        contents()

        check?.let {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(MyApplicationTheme.minSize)
            ) {
                it()
            }
        }
    }
}




