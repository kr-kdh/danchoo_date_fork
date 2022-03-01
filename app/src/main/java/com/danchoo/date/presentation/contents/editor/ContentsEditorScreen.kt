package com.danchoo.date.presentation.contents.editor

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.danchoo.date.presentation.contents.ContentsContract


@Composable
fun ContentsEditorScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsEditViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {}
) {
    ContentsEditorScreenImpl(
        modifier = modifier
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsContract.ContentsEditorViewEvent.OnClickBack -> onClickBack()
            else -> Unit
        }
    }
}
