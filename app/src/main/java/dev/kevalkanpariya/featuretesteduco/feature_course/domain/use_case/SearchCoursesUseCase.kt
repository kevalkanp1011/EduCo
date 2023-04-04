package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class SearchCoursesUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int
    ): Resource<List<CourseOverview>> {
        return courseRepository.searchCourses(query, page)
    }
}