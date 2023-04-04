package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey900

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


    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "star",
                modifier = Modifier
                    .width(size)
                    .height(size)
                    .pointerInteropFilter {
                        when (it.action) {
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
                tint = if (i <= rating) Color(0xFFFFA927) else Color(0XFFA2ADB1)
            )
            
        }
    }
}
@Preview
@Composable
fun RatingPopUp() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xffE6EBF4))
            .padding(horizontal = 12.dp)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Rate the Course", fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Grey900)
        Spacer(modifier = Modifier.height(15.dp))
        RatingBar(rating = 4)
    }


}