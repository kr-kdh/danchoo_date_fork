package com.danchoo.date.presentation.ui.components.main.home.category

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.danchoo.components.event.ViewEvent
import com.danchoo.date.presentation.ui.common.extension.launchResumed
import com.danchoo.date.presentation.ui.components.main.CategoryEditorScreen
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewEvent


class CategoryState(
    private val navController: NavController,
    val listState: LazyListState
) {
    fun navigation(viewEvent: ViewEvent) {
        navController.launchResumed {
            when (viewEvent) {
                is CategoryViewEvent.OnAddCategory -> {
                    navigate(CategoryEditorScreen.CREATE)
                }
            }
        }
    }
}

@Composable
fun rememberCategoryState(
    navController: NavController,
    listState: LazyListState = rememberLazyListState(),
) = remember {
    CategoryState(navController, listState)
}

