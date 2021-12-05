package com.danchoo.components.ui.cardview

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.components.event.ViewEvent
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MainTheme
import com.danchoo.components.theme.RoundedCornerShape8dp
import com.danchoo.components.ui.button.ExpandButton
import com.danchoo.components.ui.cardview.CardViewConstants.CardViewEvent
import com.danchoo.components.ui.text.Text
import com.danchoo.components.ui.text.TextType


@Composable
fun CardViewContents(
    modifier: Modifier = Modifier,
    type: CardViewContentsType = CardViewContentsType.Normal,
    title: String,
    description: String = "",
    images: List<Any> = emptyList()
) {
    val state = rememberCardViewState(
        title = title,
        description = description,
        useExpand = type != CardViewContentsType.SmallImage,
        images = images
    )

    when (type) {
        CardViewContentsType.Normal -> {
            CardViewNormalContents(modifier, state) { hookViewEvent(state, it) }
        }
        CardViewContentsType.SmallImage -> {
            CardViewSmallImageContents(modifier, state) { hookViewEvent(state, it) }
        }
        CardViewContentsType.SmallImages -> {
            CardViewSmallImagesContents(modifier, state) { hookViewEvent(state, it) }
        }
        CardViewContentsType.BigImage -> {
            CardViewBigImageContents(modifier, state) { hookViewEvent(state, it) }
        }
    }
}

private fun hookViewEvent(
    state: CardViewState,
    event: ViewEvent
) {
    when (event) {
        is CardViewEvent.ClickExpand -> state.setExpanded(event.expand)
        is CardViewEvent.ChangeExpandEnableState -> state.setEnableExpandButton(event.enable)
    }
}


@Composable
private fun CardViewNormalContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onViewEvent: onViewEvent
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = MainTheme.spacing.baseLineSpacingMedium,
                end = MainTheme.spacing.baseLineSpacingMedium
            )
    ) {
        val maxLine = if (state.useExpand) DESCRIPTION_MIN_LINE else DESCRIPTION_MAX_LINE

        CardViewNormalContentsText(
            modifier = modifier
                .padding(
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing,
                    end = MainTheme.spacing.baseLineSpacingSmall
                )
                .align(Alignment.Top),
            state = state,
            maxLine = if (state.isExpanded()) DESCRIPTION_MAX_LINE else maxLine,
            onViewEvent
        )

        if (state.useExpand) {
            ExpandButton(
                modifier = Modifier
                    .padding(top = MainTheme.spacing.baseLineSpacingSmall)
                    .defaultMinSize(minHeight = MainTheme.minSize),
                expanded = state.isExpanded(),
                enable = state.isEnableExpandButton()
            ) {
                onViewEvent(CardViewEvent.ClickExpand(!state.isExpanded()))
            }
        }
    }
}

@Composable
private fun RowScope.CardViewNormalContentsText(
    modifier: Modifier = Modifier,
    state: CardViewState,
    maxLine: Int,
    onViewEvent: onViewEvent
) {
    Column(
        modifier = modifier
            .weight(1f)
            .defaultMinSize(minHeight = MainTheme.minSize)
    ) {

        Text(type = TextType.Title1, text = state.title)

        if (state.description.isNotEmpty()) {
            Text(
                modifier = Modifier.padding(top = MainTheme.spacing.baseLineSpacingSmall),
                type = TextType.Description,
                maxLines = maxLine,
                text = state.description
            ) {
                if (state.isExpanded()) {
                    onViewEvent(CardViewEvent.ChangeExpandEnableState(true))
                } else {
                    onViewEvent(CardViewEvent.ChangeExpandEnableState(it.hasVisualOverflow))
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImageContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onViewEvent: onViewEvent
) {
    Row(modifier) {
        Image(
            modifier = Modifier
                .size(96.dp)
                .padding(
                    start = MainTheme.spacing.baseLineSpacing,
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing,
                )
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape8dp)
                .border(
                    width = MainTheme.borderWidth.borderHarf,
                    color = MainTheme.colors.border,
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
                    start = MainTheme.spacing.baseLineSpacing,
                    top = MainTheme.spacing.baseLineSpacing,
                    bottom = MainTheme.spacing.baseLineSpacing,
                    end = MainTheme.spacing.baseLineSpacing
                )
                .align(Alignment.Top),
            state = state,
            maxLine = 2,
            onViewEvent
        )
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImagesContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onViewEvent: onViewEvent
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

        CardViewNormalContents(modifier, state, onViewEvent)
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewBigImageContents(
    modifier: Modifier = Modifier,
    state: CardViewState,
    onViewEvent: onViewEvent
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

        CardViewNormalContents(modifier, state, onViewEvent)
    }
}

enum class CardViewContentsType {
    Normal,
    SmallImage,
    SmallImages,
    BigImage
}

private const val DESCRIPTION_MAX_LINE = 4
private const val DESCRIPTION_MIN_LINE = 2
