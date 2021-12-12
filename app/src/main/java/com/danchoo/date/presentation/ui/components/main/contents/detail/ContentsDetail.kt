package com.danchoo.date.presentation.ui.components.main.contents.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.date.R
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun ContentsDetail(
    modifier: Modifier = Modifier,
    onSelected: (Long) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) {
        HorizontalPagerWithOffsetTransition(modifier)
    }
}

@Preview
@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun HorizontalPagerWithOffsetTransition(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState()

    Column(modifier = modifier.fillMaxSize()) {

        HorizontalContentsPager(
            modifier,
            pagerState
        )

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        /**
         * TODO
         *  - Contents 관련 텍스트 및 기타 등등
         *  - 댓글
         */
    }
}

@ExperimentalPagerApi
@Composable
fun HorizontalContentsPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    HorizontalPager(
        count = 0,
        state = pagerState,
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) { page ->
        Card(
            modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.90f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth(0.85f)
                .aspectRatio(1f)
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.the_gleaners
                    ),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.fillMaxSize()
                )
            }
        }
    }
}
