package com.danchoo.date.presentation.ui.components.main.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.ui.appbar.TopAppBar
import com.danchoo.components.ui.appbar.TopAppbarType
import com.danchoo.date.presentation.ui.common.extension.debounce
import com.danchoo.date.presentation.ui.components.common.AddFloatingActionButton
import com.danchoo.date.presentation.ui.components.common.Surface
import com.danchoo.date.presentation.ui.main.category.CategoriesEditorActivity
import com.danchoo.date.presentation.ui.main.category.viewmodel.CategoryViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun Category(
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = hiltViewModel(),
    onSelected: (Long) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier,
                type = TopAppbarType.Back,
                title = "Category"
            ) {
            }
        },
        content = {
            Surface(
                modifier = modifier.fillMaxSize()
            ) {
                // TODO : Test
                val list = viewModel.categoryList().collectAsLazyPagingItems()
                CategoryList(list = list, onSelected = onSelected.debounce())
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            AddFloatingActionButton {
                CategoriesEditorActivity.startActivity(context)
            }
        }
    )
}

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    list: LazyPagingItems<CategoryData>,
    onSelected: (Long) -> Unit
) {
    LazyColumn(
        modifier
            .padding(top = MainTheme.spacing.baseLineSpacingMedium)
            .clipToBounds()
    ) {
        itemsIndexed(list) { index, categoryModel ->
            categoryModel?.let {
                CategoryItem(modifier, categoryModel, onSelected)
            }
        }
//        itemsIndexed(list) { index, categoryModel ->
//            SnackCollection(
//                snackCollection = snackCollection,
//                onSnackClick = onSnackClick,
//                index = index
//            )
//        }
    }
}