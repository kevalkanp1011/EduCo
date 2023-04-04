package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class AddToBookmarkedCoursesUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {
    suspend operator fun invoke(
        userId: String,
        courseId: String
    ): SimpleResource {
        return courseRepository.AddToBookmarkedCourses(
            userId = userId,
            courseId = courseId
        )
    }
}