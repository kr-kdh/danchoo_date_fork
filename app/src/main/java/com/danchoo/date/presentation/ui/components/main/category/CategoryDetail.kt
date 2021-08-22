package com.danchoo.date.presentation.ui.components.main.category

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.danchoo.date.domain.model.CategoryDetailModel
import com.danchoo.date.presentation.ui.components.common.AddFloatingActionButton
import com.danchoo.date.presentation.ui.components.common.Surface

@ExperimentalAnimationApi
@Composable
fun CategoryDetail(
    modifier: Modifier = Modifier,
    categoryId: String,
    upPress: () -> Unit
) {

    Scaffold(
        content = {
            Surface(
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 56.dp)
            ) {
                // TODO : Test
//                CategoryDetailList(list)
            }
        },
        floatingActionButton = {
            AddFloatingActionButton {
            }
        }
    )
}

@Composable
fun CategoryDetailList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<CategoryDetailModel>
) {
    LazyColumn(modifier) {
        items(list) { categoryModel ->
            categoryModel?.let {
            }
        }
    }
}