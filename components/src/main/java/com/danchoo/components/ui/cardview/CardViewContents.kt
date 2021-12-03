package com.danchoo.components.ui.cardview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.components.extension.applyAlpha80
import com.danchoo.components.theme.MainTheme


@Composable
fun CardViewContents(
    modifier: Modifier = Modifier,
    type: CardViewContentsType = CardViewContentsType.Normal,
    title: String,
    description: String = "",
    enableExpand: Boolean = false,
    images: List<Any> = emptyList()
) {
    when (type) {
        CardViewContentsType.Normal -> {
            CardViewNormalContents(modifier, title, description, enableExpand)
        }
        CardViewContentsType.SmallImage -> {
            CardViewSmallImageContents(modifier, title, description, enableExpand, images.first())
        }
        CardViewContentsType.SmallImages -> {
            CardViewSmallImagesContents(modifier, title, description, enableExpand, images)
        }
        CardViewContentsType.BigImage -> {}
    }
}

@Composable
private fun CardViewNormalContents(
    modifier: Modifier = Modifier,
    title: String,
    description: String = "",
    enableExpand: Boolean = false
) {
    val expanded = remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = MainTheme.spacing.baseLineSpacingMedium,
                end = MainTheme.spacing.baseLineSpacingMedium
            )
    ) {
        Column(
            modifier
                .weight(1f)
                .padding(
                    top = MainTheme.spacing.baseLineSpacingMedium,
                    bottom = MainTheme.spacing.baseLineSpacingMedium
                )
                .defaultMinSize(minHeight = MainTheme.minSize)
        ) {
            Text(
                modifier = modifier,
                text = title,
                maxLines = 1,
                style = MainTheme.typography.title1Bold,
                overflow = TextOverflow.Ellipsis,
                color = MainTheme.colors.textPrimary
            )

            if (description.isNotEmpty()) {
                val defaultMaxLine = if (enableExpand) {
                    DESCRIPTION_MAX_LINE_EXPAND
                } else {
                    DESCRIPTION_MAX_LINE_DEFAULT
                }

                Text(
                    modifier = modifier
                        .padding(top = MainTheme.spacing.baseLineSpacingSmall),
                    text = description,
                    style = MainTheme.typography.body1,
                    maxLines = if (expanded.value) DESCRIPTION_MAX_LINE_EXPAND else defaultMaxLine,
                    overflow = TextOverflow.Ellipsis,
                    color = MainTheme.colors.textPrimary.applyAlpha80()
                )
            }
        }

        if (enableExpand) {
            IconButton(
                modifier = modifier
                    .padding(top = MainTheme.spacing.baseLineSpacingSmall)
                    .defaultMinSize(minHeight = MainTheme.minSize),
                onClick = { expanded.value = !expanded.value }
            ) {
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImageContents(
    modifier: Modifier = Modifier,
    title: String,
    description: String = "",
    enableExpand: Boolean = false,
    image: Any
) {
    Row(modifier) {
        Image(
            painter = rememberImagePainter(
                data = image
            ),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = modifier.size(96.dp)
        )

        CardViewNormalContents(
            modifier.weight(1f),
            title,
            description,
            enableExpand
        )
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
private fun CardViewSmallImagesContents(
    modifier: Modifier = Modifier,
    title: String,
    description: String = "",
    enableExpand: Boolean = false,
    images: List<Any>
) {
    Column(modifier) {
        Row(modifier) {
            images.forEach {
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

        CardViewNormalContents(
            modifier.weight(1f),
            title,
            description,
            enableExpand
        )
    }
}

enum class CardViewContentsType {
    Normal,
    SmallImage,
    SmallImages,
    BigImage
}

private const val DESCRIPTION_MAX_LINE_DEFAULT = 4
private const val DESCRIPTION_MAX_LINE_EXPAND = 2
