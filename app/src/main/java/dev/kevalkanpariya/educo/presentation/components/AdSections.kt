package dev.kevalkanpariya.educo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FreeTrial(
    modifier: Modifier
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .background(color = Color(0xFFFFF1F3))
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Try free trial to enhance\nyour creative journey!",style = MaterialTheme.typography.h6)
        Spacer(modifier = modifier.height(20.dp))
        Text(text = "Get free trial", color = Color.Blue,style = MaterialTheme.typography.h5)
    }
}