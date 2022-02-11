package com.steleot.jetpackcompose.playground.compose.externallibraries

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.steleot.jetpackcompose.playground.compose.reusable.DefaultScaffold
import com.steleot.jetpackcompose.playground.navigation.ExternalLibrariesNavRoutes

private const val Url = "externallibraries/GoogleMapsScreen.kt"

@Composable
fun GoogleMapsScreen() {
    DefaultScaffold(
        title = ExternalLibrariesNavRoutes.GoogleMaps,
        link = Url,
    ) {
        GoogleMapsExample()
    }
}

@Composable
private fun GoogleMapsExample() {
    var isMapLoaded by remember { mutableStateOf(false) }
    val athens = LatLng(37.983810, 23.727539)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(athens, 8f)
    }
    Box(Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            },
            properties = MapProperties(
                mapType = MapType.NORMAL,
            ),
            uiSettings = MapUiSettings(compassEnabled = false),
        ) {
            Marker(position = athens, title = "Athens")
            Marker(position = LatLng(40.629269, 22.947412), title = "Thessaloniki")
        }
        if (!isMapLoaded) {
            AnimatedVisibility(
                modifier = Modifier
                    .matchParentSize(),
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}