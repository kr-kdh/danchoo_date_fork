package com.danchoo.date.presentation.home.category

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle.State.RESUMED
import androidx.paging.compose.collectAsLazyPagingItems
import com.danchoo.date.presentation.home.category.CategoryContract.CategoryViewEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach


@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = hiltViewModel(),
    onClickCategoryAdd: () -> Unit = {},
    onClickCategory: (Long) -> Unit = {}
) {
    val currentLifecycleState = LocalLifecycleOwner.current.lifecycle.currentState
    val categoryDataList = viewModel.categoryList().collectAsLazyPagingItems()

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect
            .onEach {

            }.collect()
    }

    LaunchedEffect(key1 = currentLifecycleState) {
        if (currentLifecycleState == RESUMED) {
            categoryDataList.refresh()
        }
    }

    CategoryScreenImpl(
        modifier = modifier,
        categoryDataList = categoryDataList
    ) { viewEvent ->

        when (viewEvent) {
            is CategoryViewEvent.OnItemClick -> onClickCategory(viewEvent.category.categoryId)
            is CategoryViewEvent.OnAddCategory -> onClickCategoryAdd()
            else -> Unit
        }
    }
}