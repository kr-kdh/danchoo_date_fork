package com.danchoo.date.presentation.ui.components.main.gallery

import android.content.Context
import android.graphics.Bitmap
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bumptech.glide.RequestBuilder
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.common.glide.GlideApp
import com.danchoo.date.presentation.ui.common.glide.GlideImage
import com.danchoo.date.presentation.ui.common.glide.GlideImageLoader
import com.danchoo.date.presentation.ui.common.glide.LocalImageLoader
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
                GlideImage(
                    modifier = Modifier.size(100.dp),
                    data = Icons.Default.Close,
                    size = 100.dp
                )
            }
        }
    }
}

class GlideAppImageLoaderImpl: GlideImageLoader {
    override fun getRequestBuilder(context: Context): RequestBuilder<Bitmap> {
        return GlideApp.with(context).asBitmap()
    }
}
@Composable
fun GalleryItem() {
    CompositionLocalProvider(LocalImageLoader provides GlideAppImageLoaderImpl()) {
        Image(
            painter = rememberImagePainter(data = Icons.Filled.ArrowBack),
            contentDescription = null
        )
    }
}