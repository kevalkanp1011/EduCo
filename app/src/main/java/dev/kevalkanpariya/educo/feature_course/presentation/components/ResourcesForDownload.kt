package dev.kevalkanpariya.educo.feature_course.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ResourcesForDownload() {
    Row() {

    }
}

@Preview
@Composable
fun ImgFile() {
    Box(modifier = Modifier
        .background(color = Color(0XFFFF6363), shape = CircleShape)

    ) {
        Text(text = ".img")
    }
}

@Composable
fun PDFFile() {
    Box(modifier = Modifier.background(color = Color(0XFFA0D7FF))) {
        Text(text = ".pdf")
    }
}
