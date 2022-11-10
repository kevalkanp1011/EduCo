package dev.kevalkanpariya.educo.presentation.screens.student_profile.personal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.domain.model.courses
import dev.kevalkanpariya.educo.presentation.screens.search.CourseItem

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