package com.danchoo.date.presentation.ui.components.main.category

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.date.presentation.ui.components.common.CardView
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.theme.MyApplicationTheme

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData,
    onSelected: (Long) -> Unit
) {
    CardView(
        modifier = modifier
            .padding(16.dp, 8.dp, 8.dp, 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                when (categoryItem) {
                    is CategoryData.CategoryInfoData -> {
                        Log.d(
                            "_SMY",
                            "categoryItem.categoryId = ${categoryItem.categoryInfoModel.category.categoryId}"
                        )
                        onSelected(categoryItem.categoryInfoModel.category.categoryId)
                    }
                    else -> Unit
                }
            }
    ) {

        when (categoryItem) {
            is CategoryData.CategoryInfoData -> CategoryDataItem(modifier, categoryItem)
            is CategoryData.CategoryHeader -> CategoryHeaderItem(modifier, categoryItem)
        }
    }
}

@Composable
private fun CategoryDataItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData.CategoryInfoData
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MainTheme.colors.background)
    ) {
        Text(
            text = categoryItem.categoryInfoModel.category.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
            color = MainTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )

        Text(
            text = categoryItem.categoryInfoModel.category.description,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MainTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )
    }
}


@Composable
private fun CategoryHeaderItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData.CategoryHeader
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MainTheme.colors.background)
    ) {
        Text(
            text = categoryItem.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
            color = MainTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    MyApplicationTheme {
        CategoryItem(
            modifier = Modifier,
            categoryItem = CategoryData.CategoryInfoData()
        ) {

        }
    }
}