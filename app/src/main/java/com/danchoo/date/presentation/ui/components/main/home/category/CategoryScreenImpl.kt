package com.danchoo.date.presentation.ui.components.main.home.category

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.button.AddFloatingActionButton
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewState

@Composable
fun CategoryScreenImpl(
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
                title = {
                    Text(
                        text = stringResource(id = R.string.category_create_title),
                        style = MyApplicationTheme.typography.title1
                    )
                }
            )
        },
        content = {
            CategoryContents(
                modifier = modifier.padding(it),
                list = categoryDataList
            ) { categoryData ->
                when (categoryData) {
                    is CategoryData.CategoryInfoData -> {
                        onViewEvent(
                            CategoryContract.CategoryViewEvent.OnItemClick(categoryData.categoryInfoModel.category)
                        )
                    }
                    is CategoryData.CategoryHeader -> {
                        onViewEvent(
                            CategoryContract.CategoryViewEvent.OnTitleClick
                        )
                    }
                    else -> Unit
                }
            }
        },
        floatingActionButton = {
            AddFloatingActionButton {
                onViewEvent(CategoryContract.CategoryViewEvent.OnAddCategory)
            }
        }
    )
}

@Composable
fun CategoryContents(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<CategoryData>,
    onClick: (categoryData: CategoryData) -> Unit = {}
) {
    LazyColumn(
        modifier
            .padding(top = MyApplicationTheme.spacing.baseLineSpacingMedium)
            .clipToBounds()
    ) {
        itemsIndexed(list) { index, categoryModel ->
            categoryModel?.let {
                CategoryItem(modifier, categoryModel, onClick)
            }
        }
    }
}