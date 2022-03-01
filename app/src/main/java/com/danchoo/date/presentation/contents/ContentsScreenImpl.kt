package com.danchoo.date.presentation.contents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.button.IconButton
import com.danchoo.contents.domain.model.ContentsModel
import com.danchoo.date.R
import com.danchoo.date.presentation.contents.ContentsContract.ContentsViewEvent

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
                title = { Text(text = stringResource(id = R.string.category_create)) },
                onClickBack = {
                    onViewEvent(ContentsViewEvent.OnClickBack)
                },
                actions = {
                    IconButton(imageVector = Icons.Default.Add) {
                        onViewEvent(ContentsViewEvent.OnClickAdd)
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


