package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/IntrinsicScreen.kt"

@Composable
fun IntrinsicScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.Intrinsic,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .requiredHeight(IntrinsicSize.Max)
                    .requiredWidth(IntrinsicSize.Max)
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Text(
                    text = stringResource(
                        id = R.string.intrinsic_size,
                        stringResource(id = R.string.max)
                    )
                )
                Text(
                    text = stringResource(
                        id = R.string.taking_x_size,
                        stringResource(id = R.string.max)
                    )
                )
            }
            Column(
                modifier = Modifier
                    .requiredHeight(IntrinsicSize.Min)
                    .requiredWidth(IntrinsicSize.Min)
                    .padding(16.dp)
                    .background(Color.Green)
            ) {
                Text(
                    text = stringResource(
                        id = R.string.intrinsic_size,
                        stringResource(id = R.string.min)
                    )
                )
                Text(
                    text = stringResource(
                        id = R.string.taking_x_size,
                        stringResource(id = R.string.min)
                    )
                )
            }
        }
    }
}