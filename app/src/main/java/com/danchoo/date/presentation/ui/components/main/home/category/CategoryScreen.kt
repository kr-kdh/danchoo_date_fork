package com.danchoo.date.presentation.ui.components.main.home.category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.ui.appbar.TopAppBar
import com.danchoo.components.ui.appbar.TopAppbarType
import com.danchoo.components.ui.button.AddFloatingActionButton
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    state: CategoryState,
    viewState: CategoryViewState,
    categoryDataList: LazyPagingItems<CategoryData>,
    onViewEvent: onViewEvent
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier,
                type = TopAppbarType.Title,
                title = "Category"
            ) {
            }
        },
        content = {
            CategoryList(
                list = categoryDataList,
                onViewEvent = onViewEvent
            )
        },
        floatingActionButton = {
            AddFloatingActionButton {
                onViewEvent(CategoryContract.CategoryViewEvent.AddCategory)
            }
        }
    )
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<CategoryData>,
    onViewEvent: onViewEvent
) {
    LazyColumn(
        modifier
            .padding(top = MainTheme.spacing.baseLineSpacingMedium)
            .clipToBounds()
    ) {
        itemsIndexed(list) { index, categoryModel ->
            categoryModel?.let {
                CategoryItem(modifier, categoryModel, onViewEvent)
            }
        }
    }
}