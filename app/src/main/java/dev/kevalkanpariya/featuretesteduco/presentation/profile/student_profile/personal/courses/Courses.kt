package dev.kevalkanpariya.featuretesteduco.presentation.profile.student_profile.personal.courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.domain.model.courses
import dev.kevalkanpariya.featuretesteduco.presentation.search.result.CourseItem

@Preview
@Composable
fun Courses() {
    LazyColumn(
        Modifier.padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(courses) {
                course -> CourseItem(
            course_title = course.courseTitle,
            teacher_name = course.course_teacher.name,
            noOfStudentEnrolled = course.noOfStudentEnrolled,
            rating = course.rating,
            image = course.image
        )
        }

    }
}