package com.danchoo.components.ui.cardview

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.theme.RoundedCornerShape8dp
import com.danchoo.components.ui.button.ExpandButton


@Composable
fun CardViewContents(
    modifier: Modifier = Modifier,
    type: CardViewContentsType = CardViewContentsType.Normal,
    title: String,
    titleTextStyle: TextStyle = MaterialTheme.typography.h5,
    description: String = "",
    descriptionTextStyle: TextStyle = MaterialTheme.typography.body1,
    images: List<Any> = emptyList()
) {
    val state = rememberCardViewState(
        title = title,
        titleTextStyle = titleTextStyle,
        description = description,
        descriptionTextStyle = descriptionTextStyle,
        useExpand = type != CardViewContentsType.SmallImage && description.isNotEmpty(),
        images = images
    )

    when (type) {
        CardViewContentsType.Normal -> {
            CardViewNormalContents(
                modifier = modifier,
                state = state,
                onClickExpand = { state.setExpanded(it) },
                onChangeExpendState = { state.setEnableExpandButton(it) }
            )
        }
        CardViewContentsType.SmallImage -> {
            CardViewSmallImageContents(
                modifier = modifier,
                state = state,
                onChangeExpendState = { state.setEnableExpandButton(it) }
            )
        }
        CardViewContentsType.SmallImages -> {
            CardViewSmallImagesContents(
                modifier = modifier,
                state = state,
                onClickExpand = { state.setExpanded(it) },
                onChangeExpendState = { state.setEnableExpandButton(it) }
            )
        }
        CardViewContentsType.BigImage -> {
            CardViewBigImageContents(
                modifier = modifier,
                state = state,
                onClickExpand = { state.setExpanded(it) },
                onChangeExpendState = { state.setEnableExpandButton(it) }
            )
        }
    }
}


@Composable
private fun CardViewNormalContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onClickExpand: (expand: Boolean) -> Unit,
    onChangeExpendState: (enable: Boolean) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        val maxLine = if (state.useExpand) DESCRIPTION_MIN_LINE else DESCRIPTION_MAX_LINE

        CardViewNormalContentsText(
            modifier = modifier
                .padding(
                    start = MyApplicationTheme.spacing.baseLineSpacingMedium,
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing,
                    end = if (state.useExpand) MyApplicationTheme.spacing.baseLineSpacingSmall else MyApplicationTheme.spacing.baseLineSpacingMedium
                )
                .align(Alignment.Top),
            state = state,
            maxLine = if (state.isExpanded()) DESCRIPTION_MAX_LINE else maxLine,
            onChangeExpendState = onChangeExpendState
        )

        if (state.useExpand) {
            ExpandButton(
                modifier = Modifier
                    .padding(
                        top = MyApplicationTheme.spacing.baseLineSpacingSmall,
                        end = MyApplicationTheme.spacing.baseLineSpacing
                    )
                    .defaultMinSize(minHeight = MyApplicationTheme.minSize),
                expanded = state.isExpanded(),
                enable = state.isEnableExpandButton()
            ) {
                onClickExpand(!state.isExpanded())
            }
        }
    }
}

@Composable
private fun RowScope.CardViewNormalContentsText(
    modifier: Modifier = Modifier,
    state: CardViewState,
    maxLine: Int,
    onChangeExpendState: (enable: Boolean) -> Unit
) {
    Column(
        modifier = modifier
            .weight(1f)
            .wrapContentHeight()
    ) {

        Text(
            text = state.title,
            style = state.titleTextStyle
        )

        if (state.description.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = MyApplicationTheme.spacing.baseLineSpacingSmall),
                maxLines = maxLine,
                text = state.description,
                style = state.descriptionTextStyle,
                onTextLayout = {
                    if (state.isExpanded()) {
                        onChangeExpendState(true)
                    } else {
                        onChangeExpendState(it.hasVisualOverflow)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImageContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onChangeExpendState: (enable: Boolean) -> Unit
) {
    Row(modifier) {
        Image(
            modifier = Modifier
                .size(96.dp)
                .padding(
                    start = MyApplicationTheme.spacing.baseLineSpacing,
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing,
                )
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape8dp)
                .border(
                    width = MyApplicationTheme.borderWidth.borderHarf,
                    color = MyApplicationTheme.colors.border,
                    shape = RoundedCornerShape8dp
                ),
            painter = rememberImagePainter(
                data = state.images.first()
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )

        CardViewNormalContentsText(
            modifier = modifier
                .padding(
                    start = MyApplicationTheme.spacing.baseLineSpacing,
                    top = MyApplicationTheme.spacing.baseLineSpacing,
                    bottom = MyApplicationTheme.spacing.baseLineSpacing,
                    end = MyApplicationTheme.spacing.baseLineSpacing
                )
                .align(Alignment.CenterVertically),
            state = state,
            maxLine = 2,
            onChangeExpendState = onChangeExpendState
        )
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImagesContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onClickExpand: (expand: Boolean) -> Unit,
    onChangeExpendState: (enable: Boolean) -> Unit
) {
    Column(modifier) {
        LazyRow(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(state.images) { index, item ->
                Image(
                    modifier = Modifier.size(144.dp),
                    painter = rememberImagePainter(
                        data = item
                    ),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop

                )
            }
        }

        CardViewNormalContents(modifier, state, onClickExpand, onChangeExpendState)
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewBigImageContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onClickExpand: (expand: Boolean) -> Unit,
    onChangeExpendState: (enable: Boolean) -> Unit
) {
    Column(modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(192.dp),
            painter = rememberImagePainter(
                data = state.images.first()
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )

        CardViewNormalContents(modifier, state, onClickExpand, onChangeExpendState)
    }
}