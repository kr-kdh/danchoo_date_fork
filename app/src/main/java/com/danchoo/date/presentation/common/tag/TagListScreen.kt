package com.danchoo.date.presentation.common.tag

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun TagListScreen(
    modifier: Modifier = Modifier,
    viewModel: TagListViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {}
) {
    val viewState = viewModel.viewState.value

    TagListScreenImpl(
        modifier = modifier,
        viewState = viewState
    ) { viewEvent ->
        when (viewEvent) {
        }
    }
}