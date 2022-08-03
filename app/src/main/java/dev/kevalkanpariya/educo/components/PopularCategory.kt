package dev.kevalkanpariya.educo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.ui.theme.Grey500
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.R


@Composable
fun PopularCategory() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Popular Category\nour in plateform",
            style = MaterialTheme.typography.h6,
            color = Grey900
        )
        TextButton(
            onClick = {},
            modifier = Modifier.offset(y = 15.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "see more", color = Grey500)
        }
    }
}


@Composable
fun CourseCard(
    title: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(170.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .height(140.dp)
        ){
            Image(
                painter = imagePainter,
                contentDescription = "",
                contentScale = ContentScale.Crop

            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 200f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(18.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(
                    color = Color.White,
                    fontSize = 14.sp
                ), fontWeight = FontWeight.Bold)

            }

        }
    }
}

@Preview
@Composable
fun PopularCategory3(){
    PopularCategory()
    Spacer(modifier = Modifier.height(25.dp))
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            CourseCard(
                title = "Interior Design",
                imagePainter = painterResource(id = R.drawable.interiordesign)
            )
        }
        item {
            CourseCard(
                title = "Traditional Art",
                imagePainter = painterResource(id = R.drawable.traditional_art)
            )
        }

    }
}