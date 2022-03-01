package com.danchoo.date.presentation.contents.editor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.danchoo.date.presentation.contents.editor.ContentsEditorContract.ContentsEditorViewEvent


@Composable
fun ContentsEditorScreen(
    modifier: Modifier = Modifier,
    viewModel: ContentsEditViewModel = hiltViewModel(),
    onClickBack: () -> Unit = {}
) {
    val viewState by viewModel.viewState

    ContentsEditorScreenImpl(
        modifier = modifier,
        viewState = viewState
    ) { viewEvent ->
        when (viewEvent) {
            is ContentsEditorViewEvent.OnClickBack -> onClickBack()
            else -> Unit
        }
    }
}
