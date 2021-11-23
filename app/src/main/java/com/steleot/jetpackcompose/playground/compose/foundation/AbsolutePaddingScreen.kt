package com.steleot.jetpackcompose.playground.compose.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.FoundationNavRoutes

private const val Url = "foundation/AbsolutePaddingScreen.kt"

@Composable
fun AbsolutePaddingScreen() {
    DefaultScaffold(
        title = FoundationNavRoutes.AbsolutePadding,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.background(color = Color.Gray)) {
                Box(
                    Modifier
                        .absolutePadding(
                            left = 20.dp,
                            top = 30.dp,
                            right = 20.dp,
                            bottom = 30.dp
                        )
                        .size(250.dp)
                        .background(MaterialTheme.colors.primary)
                )
            }
        }
    }
}