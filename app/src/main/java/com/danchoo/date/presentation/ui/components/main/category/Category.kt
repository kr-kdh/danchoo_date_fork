package com.danchoo.date.presentation.ui.components.main.category

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.presentation.ui.components.common.AddFloatingActionButton
import com.danchoo.date.presentation.ui.components.common.Surface
import com.danchoo.date.presentation.ui.main.category.viewmodel.CategoryViewModel

@Composable
fun Category(
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    Scaffold(
        content = {
            Surface(modifier = modifier.fillMaxSize()) {
                // TODO : Test
                val list = viewModel.categoryList().collectAsLazyPagingItems()

                CategoryList(list)
            }
        },
        floatingActionButton = {
            AddFloatingActionButton {
                viewModel.addCategory()
            }
        }
    )

}

@Composable
fun CategoryList(
    list: LazyPagingItems<CategoryModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(list) { categoryModel ->
            categoryModel?.let {
                CategoryItem(modifier, categoryModel)
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