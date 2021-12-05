package com.danchoo.date.presentation.ui.components.main.category

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.cardview.CardView
import com.danchoo.components.ui.cardview.CardViewContents
import com.danchoo.components.ui.cardview.CardViewContentsType

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

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Row(modifier = modifier.padding(24.dp)) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = extraPadding)
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

        IconButton(onClick = {
            expanded.value = !expanded.value
        }) {
            Icon(
                imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = null
            )
        }
    }
}


@Composable
private fun CategoryHeaderItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData.CategoryHeader
) {
    CardViewContents(
        modifier = modifier,
        type = CardViewContentsType.Normal,
        title = categoryItem.title,
        description = "헤헤헷",
        useExpand = true
    )
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

