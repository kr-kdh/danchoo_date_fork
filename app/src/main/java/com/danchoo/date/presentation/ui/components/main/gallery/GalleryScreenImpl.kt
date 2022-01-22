package com.danchoo.date.presentation.ui.components.main.gallery

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

//
//@Composable
//fun StaggeredVerticalGrid(
//    modifier: Modifier = Modifier,
//    maxColumnWidth: Dp,
//    content: @Composable () -> Unit
//) {
//    Layout(
//        content = content,
//        modifier = modifier
//    ) { measurables, constraints ->
//        check(constraints.hasBoundedWidth) {
//            "Unbounded width not supported"
//        }
//        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()
//        val columnWidth = constraints.maxWidth / columns
//
//        val itemConstraints = constraints.copy(maxWidth = columnWidth)
//        val colHeights = IntArray(columns) { 0 } // track each column's height
//        val placeables = measurables.map { measurable ->
//            val column = shortestColumn(colHeights)
//            val placeable = measurable.measure(itemConstraints)
//            colHeights[column] += placeable.height
//            placeable
//        }
//
//        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
//            ?: constraints.minHeight
//        layout(
//            width = constraints.maxWidth,
//            height = height
//        ) {
//            val colY = IntArray(columns) { 0 }
//            placeables.forEach { placeable ->
//                val column = shortestColumn(colY)
//                placeable.place(
//                    x = columnWidth * column,
//                    y = colY[column]
//                )
//                colY[column] += placeable.height
//            }
//        }
//    }
//}
//
//private fun shortestColumn(colHeights: IntArray): Int {
//    var minHeight = Int.MAX_VALUE
//    var column = 0
//    colHeights.forEachIndexed { index, height ->
//        if (height < minHeight) {
//            minHeight = height
//            column = index
//        }
//    }
//    return column
//}