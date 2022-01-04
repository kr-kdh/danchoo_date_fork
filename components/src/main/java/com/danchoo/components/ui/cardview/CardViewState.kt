package com.danchoo.components.ui.cardview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle


class CardViewState(
    val title: String,
    val titleTextStyle: TextStyle,
    val description: String,
    val descriptionTextStyle: TextStyle,
    val useExpand: Boolean,
    val images: List<Any> = emptyList(),
    private val expanded: MutableState<Boolean>,
    private val enableExpandButton: MutableState<Boolean>
) {

    fun isExpanded(): Boolean {
        return expanded.value
    }

    fun setExpanded(expanded: Boolean) {
        this.expanded.value = expanded
    }

    fun isEnableExpandButton(): Boolean {
        return enableExpandButton.value
    }

    fun setEnableExpandButton(enable: Boolean) {
        this.enableExpandButton.value = enable
    }

}

@Composable
fun rememberCardViewState(
    title: String = "",
    description: String = "",
    titleTextStyle: TextStyle,
    descriptionTextStyle: TextStyle,
    useExpand: Boolean = true,
    images: List<Any> = emptyList(),
    expanded: MutableState<Boolean> = remember { mutableStateOf(false) },
    enableExpandButton: MutableState<Boolean> = remember { mutableStateOf(true) }
) = remember(expanded, enableExpandButton) {
    CardViewState(
        title,
        titleTextStyle,
        description,
        descriptionTextStyle,
        useExpand,
        images,
        expanded,
        enableExpandButton
    )
}
