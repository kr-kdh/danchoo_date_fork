package com.danchoo.date.presentation.contents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.contents.ContentsContract.ContentsViewEvent

@Composable
fun ContentsScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
    onClickAdd: (Long) -> Unit = {},
    onClickContent: (Long) -> Unit = {}
) {
    val list = viewModel.contentsList().collectAsLazyPagingItems()

    val viewState by viewModel.viewState


    ContentsScreenImpl(
        modifier = modifier,
        list = list
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsViewEvent.OnClickBack -> onClickBack()
            is ContentsViewEvent.OnClickAdd -> onClickAdd(viewState.categoryId)
            is ContentsViewEvent.OnClickContent -> onClickContent(viewEvent.contentsId)
            else -> Unit
        }
    }
}
