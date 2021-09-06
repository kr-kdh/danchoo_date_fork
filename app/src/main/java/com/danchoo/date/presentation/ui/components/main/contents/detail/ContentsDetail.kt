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
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.danchoo.date.R
import com.danchoo.date.presentation.ui.main.contents.ContentsDetailViewModel
import com.google.accompanist.pager.*
import kotlin.math.absoluteValue

@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun ContentsDetail(
    modifier: Modifier = Modifier,
    viewModel: ContentsDetailViewModel = hiltViewModel(),
    onSelected: (String) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPagerWithOffsetTransition()
    }
}

@Preview
@ExperimentalPagerApi
@ExperimentalCoilApi
@Composable
fun HorizontalPagerWithOffsetTransition() {
    val pagerState = rememberPagerState(
        pageCount = 10,
        // We increase the offscreen limit, to allow pre-loading of images
        initialOffscreenLimit = 2,
    )

    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalContentsPager(pagerState)

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
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
fun HorizontalContentsPager(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) { page ->
        Card(
            Modifier
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
                modifier = Modifier
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
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
