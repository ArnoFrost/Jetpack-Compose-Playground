package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.LocalWindowInsets
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/InsetsAccompanistScreen.kt"

@Composable
fun InsetsAccompanistScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.InsetsAccompanist,
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InsetsExample()
        }
    }
}

@Composable
private fun InsetsExample() {
    val windowInsets = LocalWindowInsets.current
    val systemBarsInsets = windowInsets.systemBars.layoutInsets
    Text(
        text = stringResource(
            id = R.string.system_bar_insets,
            systemBarsInsets.top,
            systemBarsInsets.left,
            systemBarsInsets.right,
            systemBarsInsets.bottom
        )
    )
}