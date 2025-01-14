package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.*
import com.steleot.jetpackcompose.playground.navigation.graph.ExternalLibrariesNavRoutes
import com.steleot.jetpackcompose.playground.ui.base.material.DefaultScaffold
import com.steleot.jetpackcompose.playground.utils.randomSampleImageUrl
import kotlin.math.absoluteValue

private const val Url = "externallibraries/PagerAccompanistScreen.kt"

@Composable
fun PagerAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.PagerAccompanist,
        link = Url,
    ) {
        PagerExample()
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalCoilApi::class)
@Composable
private fun PagerExample() {
    val pagerState = rememberPagerState()
    Column(Modifier.fillMaxSize()) {
        HorizontalPager(
            count = 10,
            contentPadding = PaddingValues(horizontal = 32.dp),
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) { page ->
            Card(
                Modifier
                    .graphicsLayer {
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }

            ) {
                Box {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(randomSampleImageUrl(width = 600))
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .aspectRatio(1f)
                    )
                    ProfilePicture(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp)
                            .offset {
                                val pageOffset =
                                    this@HorizontalPager.calculateCurrentOffsetForPage(page)
                                IntOffset(
                                    x = (36.dp * pageOffset).roundToPx(),
                                    y = 0
                                )
                            }
                    )
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            indicatorShape = RoundedCornerShape(0.dp)
        )
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun ProfilePicture(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(4.dp, MaterialTheme.colors.surface)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(randomSampleImageUrl())
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.size(72.dp)
        )
    }
}