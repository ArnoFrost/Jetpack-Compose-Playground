package com.steleot.jetpackcompose.playground.compose.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.UiNavRoutes

private const val Url = "ui/ModifierLocalScreen.kt"

@Composable
fun ModifierLocalScreen() {
    DefaultScaffold(
        title = UiNavRoutes.ModifierLocal,
        link = Url,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ModifierLocalExample()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun ModifierLocalExample() {
    val context = LocalContext.current
    val localMessage = modifierLocalOf { context.getString(R.string.unknown) }

    Box(
        Modifier
            .modifierLocalProvider(localMessage) { context.getString(R.string.app_name) }
            .size(150.dp)
            .background(MaterialTheme.colors.primary)
            .composed {
                var message by remember { mutableStateOf("") }
                Modifier
                    .modifierLocalConsumer { message = localMessage.current }
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                context.getString(R.string.hello_with_args, message),
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
            }
    )
}