package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class GetDiscoverCoursesUseCase @Inject constructor(
    private val courseRepository: CourseRepository
) {

    suspend operator fun invoke(
        filterResult: FilterResult?
    ) = courseRepository.getDiscoverCourses(filterResult)

}