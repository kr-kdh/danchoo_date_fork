package com.danchoo.date.presentation.ui.components.main.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.danchoo.date.domain.model.CategoryModel
import com.danchoo.date.presentation.ui.components.common.CardView
import com.danchoo.date.presentation.ui.components.main.MainBottomBar
import com.danchoo.date.presentation.ui.components.main.MainSections
import com.danchoo.date.presentation.ui.theme.MainTheme
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryModel: CategoryModel
) {

    CardView(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MainTheme.colors.background)
        ) {
            Text(
                text = categoryModel.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = MainTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )

            Text(
                text = categoryModel.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body1,
                color = MainTheme.colors.textSecondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    MyApplicationTheme {
        CategoryItem(
            modifier = Modifier,
            categoryModel = CategoryModel()
        )
    }
}