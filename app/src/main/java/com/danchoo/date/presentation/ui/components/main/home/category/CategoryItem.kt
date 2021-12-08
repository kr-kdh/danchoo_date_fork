package com.danchoo.date.presentation.ui.components.main.home.category

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.category.domain.model.CategoryData
import com.danchoo.category.domain.model.CategoryInfoModel
import com.danchoo.category.domain.model.CategoryModel
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.cardview.CardView
import com.danchoo.components.ui.cardview.CardViewContents
import com.danchoo.components.ui.cardview.CardViewContentsType
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.components.main.home.category.CategoryContract.CategoryViewEvent

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData,
    onViewEvent: onViewEvent = {}
) {
    CardView(
        modifier = modifier
            .padding(
                start = MainTheme.spacing.baseLineSpacingMedium,
                top = MainTheme.spacing.baseLineSpacing,
                bottom = MainTheme.spacing.baseLineSpacing,
                end = MainTheme.spacing.baseLineSpacingMedium,
            )
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                when (categoryItem) {
                    is CategoryData.CategoryInfoData -> {
                        onViewEvent(
                            CategoryViewEvent.ItemClick(categoryItem.categoryInfoModel.category)
                        )
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
    CardViewContents(
        modifier = modifier,
        type = CardViewContentsType.BigImage,
        title = categoryItem.categoryInfoModel.category.title,
        description = categoryItem.categoryInfoModel.category.description,
        images = listOf(R.drawable.the_gleaners)
    )
}


@Composable
private fun CategoryHeaderItem(
    modifier: Modifier = Modifier,
    categoryItem: CategoryData.CategoryHeader
) {
    CardViewContents(
        modifier = modifier,
        type = CardViewContentsType.Normal,
        title = categoryItem.title
    )
}

@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CategoryDataItemPreview() {
    MyApplicationTheme {
        CategoryItem(
            modifier = Modifier,
            categoryItem = CategoryData.CategoryInfoData(
                CategoryInfoModel(
                    category = CategoryModel(
                        title = "Category Title",
                        description = "Category Description",
                        coverImage = ""
                    )
                )
            )
        )
    }
}


@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun CategoryHeaderPreview() {
    MyApplicationTheme {
        CategoryItem(
            modifier = Modifier,
            categoryItem = CategoryData.CategoryHeader("Title")
        )
    }
}

