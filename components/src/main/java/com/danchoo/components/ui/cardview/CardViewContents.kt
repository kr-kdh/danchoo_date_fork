package com.danchoo.components.ui.cardview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.components.event.ViewEvent
import com.danchoo.components.event.onViewEvent
import com.danchoo.components.theme.MainTheme
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
    useExpand: Boolean = false,
    images: List<Any> = emptyList()
) {
    val state = rememberCardViewState(
        title = title,
        description = description,
        useExpand = useExpand,
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
        CardViewContentsType.BigImage -> {}
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

        CardViewNormalContentsText(modifier, state, onViewEvent)

        if (state.useExpand) {
            ExpandButton(
                modifier = modifier
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
    onViewEvent: onViewEvent
) {
    Column(
        modifier = modifier
            .weight(1f)
            .padding(
                top = MainTheme.spacing.baseLineSpacingMedium,
                bottom = MainTheme.spacing.baseLineSpacingMedium
            )
            .defaultMinSize(minHeight = MainTheme.minSize)
    ) {

        Text(modifier, TextType.Title1, state.title)

        if (state.description.isNotEmpty()) {
            val defaultMaxLine = if (state.useExpand) {
                DESCRIPTION_MIN_LINE
            } else {
                DESCRIPTION_MAX_LINE
            }

            Text(
                modifier = modifier.padding(top = MainTheme.spacing.baseLineSpacingSmall),
                type = TextType.Description,
                maxLines = if (state.isExpanded()) DESCRIPTION_MAX_LINE else defaultMaxLine,
                text = state.description
            ) {
                onViewEvent(CardViewEvent.ChangeExpandEnableState(it.hasVisualOverflow))
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
            painter = rememberImagePainter(
                data = state.images.first()
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(96.dp)
        )

        CardViewNormalContents(modifier.weight(1f), state, onViewEvent)
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
        Row(modifier) {
            state.images.forEach {
                Image(
                    painter = rememberImagePainter(
                        data = it
                    ),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.size(96.dp)
                )
            }
        }

        CardViewNormalContents(modifier.weight(1f), state, onViewEvent)
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
