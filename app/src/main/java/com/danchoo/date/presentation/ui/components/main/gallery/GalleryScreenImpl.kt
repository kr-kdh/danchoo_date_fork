package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
                modifier = modifier.padding(it),
                contentPadding = PaddingValues(2.dp)
            ) {
                items(pagingItems.itemCount) { index ->
                    GlideImage(
                        modifier = Modifier
                            .padding(2.dp)
                            .size(maxWidth / 3)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
                            ),
                        data = pagingItems[index]?.uri ?: "",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}