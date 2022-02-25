package com.danchoo.date.presentation.contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.components.ui.button.AddFloatingActionButton
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.presentation.utils.extension.debounce

@Composable
fun ContentsScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsViewModel = hiltViewModel(),
    onSelected: (Long) -> Unit
) {
    Scaffold(
        content = {
            Surface(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 56.dp)
            ) {
                // TODO : Test
                val list = viewModel.contentsList().collectAsLazyPagingItems()
                ContentsList(list = list, onSelected = onSelected.debounce())
            }
        },
        floatingActionButton = {
            AddFloatingActionButton {
                viewModel.addContents()
            }
        }
    )

}

@Composable
fun ContentsList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<ContentsModel>,
    onSelected: (Long) -> Unit
) {
    LazyColumn(modifier) {
        itemsIndexed(list) { index, contentsModel ->
            contentsModel?.let {
                ContentsItem(modifier, contentsModel, onSelected)
            }
        }
//        itemsIndexed(list) { index, categoryModel ->
//            SnackCollection(
//                snackCollection = snackCollection,
//                onSnackClick = onSnackClick,
//                index = index
//            )
//        }
    }
}