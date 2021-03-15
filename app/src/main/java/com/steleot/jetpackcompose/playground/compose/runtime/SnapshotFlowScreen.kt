package com.steleot.jetpackcompose.playground.compose.runtime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.steleot.jetpackcompose.playground.RuntimeNavRoutes
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import java.util.Locale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val Url = "runtime/SnapshotFlowScreen.kt"

@Composable
fun SnapshotFlowScreen() {
    DefaultScaffold(
        title = RuntimeNavRoutes.SnapshotFlow.capitalize(Locale.getDefault()),
        link = Url,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SnapshotFlowExample()
        }
    }
}

@OptIn(InternalCoroutinesApi::class)
@Composable
private fun SnapshotFlowExample() {
    var greeting by remember { mutableStateOf("Hello") }
    var person by remember { mutableStateOf("Jetpack Compose Playground") }
    val snapshot = snapshotFlow { "$greeting, $person" }
    val state by snapshot.collectAsState("")
    val scope = rememberCoroutineScope()

    Text(text = state)

    scope.launch(Dispatchers.IO) {
        delay(1_000L)
        Snapshot.withMutableSnapshot {
            greeting = "Ahoy"
            person = "Compose Playground"
        }
    }
}