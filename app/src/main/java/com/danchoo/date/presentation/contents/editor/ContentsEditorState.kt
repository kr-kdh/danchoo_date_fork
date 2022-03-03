package com.danchoo.date.presentation.contents.editor

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class ContentsEditorState(
    val categoryDropDownExpended: MutableState<Boolean>
) {
}

@Composable
fun rememberContentsEditorState(
    categoryDropDownExpended: MutableState<Boolean> = mutableStateOf(false)
) = remember(categoryDropDownExpended) {
    ContentsEditorState(categoryDropDownExpended)
}