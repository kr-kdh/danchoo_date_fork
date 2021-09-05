package com.danchoo.date.presentation.ui.components.main.contents

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
import com.danchoo.date.domain.model.ContentsModel
import com.danchoo.date.presentation.ui.components.common.CardView
import com.danchoo.date.presentation.ui.theme.MainTheme
import com.danchoo.date.presentation.ui.theme.MyApplicationTheme

@Composable
fun ContentsItem(
    modifier: Modifier = Modifier,
    contentsItem: ContentsModel,
    onSelected: (String) -> Unit
) {
    CardView(
        modifier = modifier
            .padding(16.dp, 8.dp, 8.dp, 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                when (contentsItem) {
                    is ContentsModel.ContentsData -> {
                        Log.d("_SMY", "categoryItem.contentsId = ${contentsItem.contentsId}")
                        onSelected(contentsItem.contentsId)
                    }
                    else -> Unit
                }
            }
    ) {

        when (contentsItem) {
            is ContentsModel.ContentsData -> ContentsDataItem(modifier, contentsItem)
            is ContentsModel.ContentsHeader -> ContentsHeaderItem(modifier, contentsItem)
        }
    }
}

@Composable
private fun ContentsDataItem(
    modifier: Modifier = Modifier,
    contentsItem: ContentsModel.ContentsData
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MainTheme.colors.background)
    ) {
        Text(
            text = contentsItem.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h6,
            color = MainTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )

        Text(
            text = contentsItem.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
            color = MainTheme.colors.textSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )
    }
}


@Composable
private fun ContentsHeaderItem(
    modifier: Modifier = Modifier,
    contentsItem: ContentsModel.ContentsHeader
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MainTheme.colors.background)
    ) {
        Text(
            text = contentsItem.title,
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
private fun ContentsItemPreview() {
    MyApplicationTheme {
        ContentsItem(
            modifier = Modifier,
            contentsItem = ContentsModel.ContentsData()
        ) {

        }
    }
}