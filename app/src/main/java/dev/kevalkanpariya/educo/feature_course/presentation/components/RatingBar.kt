package dev.kevalkanpariya.educo.feature_course.presentation.components

import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RatingBar(
    //modifier: Modifier = Modifier,
    rating: Int
) {
    var rating by remember {
        mutableStateOf(rating)
    }
    var isSelected by remember {
        mutableStateOf(false)
    }
    val size by animateDpAsState(
        targetValue = if (isSelected) 72.dp else 64.dp,
        spring(Spring.DampingRatioMediumBouncy)
    )

    Row(modifier = Modifier.fillMaxWidth()) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "star",
                modifier = Modifier
                    .width(size)
                    .height(size)
                    .pointerInteropFilter {
                          when(it.action) {
                              MotionEvent.ACTION_DOWN -> {
                                  isSelected = true
                                  rating = i
                              }
                              MotionEvent.ACTION_UP -> {
                                  isSelected = false
                              }
                          }
                        true
                    },
                tint = if (i< rating) Color(0XFFA927) else Color.White
            )
        }
    }
}