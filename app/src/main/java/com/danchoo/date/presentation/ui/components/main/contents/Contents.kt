package com.danchoo.date.presentation.ui.components.main.contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.presentation.ui.common.extension.debounce
import com.danchoo.date.presentation.ui.components.common.AddFloatingActionButton
import com.danchoo.date.presentation.ui.components.common.Surface
import com.danchoo.date.presentation.ui.main.contents.ContentsViewModel

@Composable
fun Contents(
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