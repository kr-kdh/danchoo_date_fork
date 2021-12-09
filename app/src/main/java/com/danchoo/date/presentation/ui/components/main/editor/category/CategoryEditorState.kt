package com.danchoo.date.presentation.ui.components.main.editor.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

class CategoryEditorState(
    val navController: NavController,
    val titleTextFieldValue: MutableState<TextFieldValue>,
    val descriptionTextFieldValue: MutableState<TextFieldValue>,
    val isVisibility: MutableState<Boolean>
) {
}


@Composable
fun rememberCategoryEditorState(
    navController: NavController,
    titleTextFieldValue: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue()),
    descriptionTextFieldValue: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue()),
    isVisibility: MutableState<Boolean> = mutableStateOf(false)
) = remember(
    navController,
    mutableStateOf(titleTextFieldValue),
    mutableStateOf(descriptionTextFieldValue),
    isVisibility
) {
    CategoryEditorState(navController, titleTextFieldValue, descriptionTextFieldValue, isVisibility)
}

