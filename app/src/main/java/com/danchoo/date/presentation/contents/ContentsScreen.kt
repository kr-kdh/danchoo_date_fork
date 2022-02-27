package com.danchoo.date.presentation.contents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.contents.ContentsContract.ContentsEditorViewEvent

@Composable
fun ContentsScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {},
    onClickAdd: () -> Unit = {},
    onClickContent: (Long) -> Unit = {}
) {
    val list = viewModel.contentsList().collectAsLazyPagingItems()

    ContentsScreenImpl(
        modifier = modifier,
        list = list
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsEditorViewEvent.OnClickBack -> onClickBack()
            is ContentsEditorViewEvent.OnClickAdd -> onClickAdd()
            is ContentsEditorViewEvent.OnClickContent -> onClickContent(viewEvent.contentsId)
            else -> Unit
        }
    }
}
