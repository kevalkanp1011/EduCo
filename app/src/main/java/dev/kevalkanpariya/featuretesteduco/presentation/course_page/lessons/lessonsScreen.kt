package dev.kevalkanpariya.featuretesteduco.presentation.course_page.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey600
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800


@Preview
@Composable
fun LessonsScreen() {
    LazyColumn(
        modifier =Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item {
            Lesson()
        }
        item {
            Lesson()
        }
        item {
            Lesson()
        }
        item {
            Lesson()
        }
        item {
            Lesson()
        }
    }
}

@Preview
@Composable
fun Lesson() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)

            ) {
            Image(
                painter = painterResource(id = R.drawable.ceramic_course),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(135.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Introduction to cimics drawing course",
                    color = Grey800,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Lesson 1", color = Grey600, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Eu lacus ornare sollicitudin dolor mauris fbib fen dum tritique massa euiod suspe mauris nunc ac felis orci eu soft lectus nibh vulputate urna ut sed neque",
            fontSize = 13.sp,
            color = Grey500
        )
    }
    
}
