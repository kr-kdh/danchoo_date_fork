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
import com.danchoo.components.theme.MainTheme
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
                        style = MainTheme.typography.title1
                    )
                }
            )
        },
        content = {
            CategoryList(
                modifier = modifier.padding(it),
                list = categoryDataList
            ) { categoryData ->
                when (categoryData) {
                    is CategoryData.CategoryInfoData -> {
                        onViewEvent(
                            CategoryContract.CategoryViewEvent.ItemClick(categoryData.categoryInfoModel.category)
                        )
                    }
                    is CategoryData.CategoryHeader -> {
                        onViewEvent(
                            CategoryContract.CategoryViewEvent.TitleClick
                        )
                    }
                    else -> Unit
                }
            }
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
    onClick: (categoryData: CategoryData) -> Unit = {}
) {
    LazyColumn(
        modifier
            .padding(top = MainTheme.spacing.baseLineSpacingMedium)
            .clipToBounds()
    ) {
        itemsIndexed(list) { index, categoryModel ->
            categoryModel?.let {
                CategoryItem(modifier, categoryModel, onClick)
            }
        }
    }
}