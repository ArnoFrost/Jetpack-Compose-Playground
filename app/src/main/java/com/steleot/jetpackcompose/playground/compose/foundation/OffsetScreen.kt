package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/OffsetScreen.kt"

@Composable
fun OffsetScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Box,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Offset()
            AbsoluteOffset()
            OffsetPx()
            AbsoluteOffsetPx()
        }
    }
}

@Preview
@Composable
private fun Offset() {
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .wrapContentSize(Alignment.Center)
            .offset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun AbsoluteOffset() {
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .wrapContentSize(Alignment.Center)
            .absoluteOffset(10.dp, 20.dp)
    )
}

@Preview
@Composable
private fun OffsetPx() {
    var offset by remember { mutableStateOf(0) }
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .clickable { offset += 10 }
            .offset { IntOffset(offset, offset) }
    )
}

@Preview
@Composable
fun AbsoluteOffsetPx() {
    var offset by remember { mutableStateOf(0) }
    Text(
        stringResource(id = R.string.layout_offset_modifier),
        Modifier
            .clickable { offset += 10 }
            .absoluteOffset { IntOffset(offset, offset) }
    )
}