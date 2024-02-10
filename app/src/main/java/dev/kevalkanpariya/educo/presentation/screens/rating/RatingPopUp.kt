package dev.kevalkanpariya.educo.presentation.screens.rating

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.kevalkanpariya.educo.presentation.components.RatingBar

@Preview
@Composable
fun RatingScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        RatingBar( rating = 1)
    }
}