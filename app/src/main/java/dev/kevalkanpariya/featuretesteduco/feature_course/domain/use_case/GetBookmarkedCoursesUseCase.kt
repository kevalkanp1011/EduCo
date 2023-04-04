package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class GetBookmarkedCoursesUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {
    suspend operator fun invoke(
        userId: String,
    ): Resource<List<CourseOverview>> {
        return courseRepository.getBookmarkedCourses(userId = userId)
    }
}