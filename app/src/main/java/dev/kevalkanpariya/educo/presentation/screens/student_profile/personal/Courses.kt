package dev.kevalkanpariya.educo.presentation.screens.student_profile.personal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.feature_course.domain.models.courses
import dev.kevalkanpariya.educo.presentation.screens.search.CourseItem
import dev.kevalkanpariya.educo.presentation.screens.search.CourseOverviewItem

@Preview
@Composable
fun Courses(
    padding: PaddingValues = PaddingValues(horizontal = 20.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(20.dp)
) {
    LazyColumn(
        modifier = Modifier.padding(padding),
        verticalArrangement = verticalArrangement
    ) {
        items(items = courses, key = { it.id }) { course ->
            CourseItem(
                item = CourseOverviewItem(
                    courseTitle = course.courseTitle,
                    teacherName = course.course_teacher.name,
                    noOfStudentEnrolled = course.noOfStudentEnrolled,
                    rating = course.rating,
                    imageUrl = ""
                )
            )
        }

    }
}