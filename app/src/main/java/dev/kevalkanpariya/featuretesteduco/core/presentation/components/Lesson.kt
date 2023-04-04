package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Lesson
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey600
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800

@Composable
fun Lesson(
    imageLoader: ImageLoader,
    lesson: Lesson
) {
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
                painter = rememberAsyncImagePainter(
                    model = lesson.thumbnail,
                    imageLoader = imageLoader
                ),
                contentDescription = "lesson thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(135.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = lesson.name,
                    color = Grey800,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Lesson ${lesson.lessonNo}", color = Grey600, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = lesson.desc,
            fontSize = 13.sp,
            color = Grey500
        )
    }

}
