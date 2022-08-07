package com.danchoo.date.presentation.contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.contents.domain.model.ContentsModel

@Composable
fun ContentsScreenImpl(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<ContentsModel>,
    onViewEvent: OnViewEvent = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BackTopAppBar(
                title = { Text(text = "Title") },
                onClickBack = {
                },
                actions = {
                    TextButton(
                        modifier = modifier,
                        enabled = true,
                        onClick = {}
                    ) {
                        Text(text = "TextButton")
                    }
                }
            )
        }
    ) {
        LazyColumn(modifier) {
            itemsIndexed(list) { index, contentsModel ->
                contentsModel?.let {
                    ContentsItem(modifier, contentsModel) {

                    }

                }
            }
        }
    }
}


