package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800

@Composable
fun CourseItem(
    course: CourseOverview,
    onNavigate: (String) -> Unit = {},
    imageLoader: ImageLoader
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .clickable {
                onNavigate(Screen.CourseDetailScreen.route + "/${course.courseId}")
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(width = 80.dp)
                .fillMaxHeight()
                ,
            painter = rememberAsyncImagePainter(
                model = course.courseThumbnailUrl,
                imageLoader = imageLoader
            ),
            contentDescription = "course thumbnail"
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = course.courseName,
                fontSize = 18.sp,
                color = Grey800
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = course.courseTeacherName,
                fontSize = 13.sp,
                color = Grey800
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = R.drawable.ic_user_1), contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${course.noOfStudentEnrolled} student",
                    fontSize = 12.sp,
                    color = Grey500
                )
                Spacer(modifier = Modifier.width(20.dp))
                Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = null, tint = Color(0XffFFA927))
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${course.rating}",
                    fontSize = 12.sp,
                    color = Grey500
                )
            }
        }
    }
}
