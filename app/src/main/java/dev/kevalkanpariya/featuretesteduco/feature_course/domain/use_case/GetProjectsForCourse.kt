package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.Project
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class GetProjectsForCourse @Inject constructor(
    private val courseRepository: CourseRepository
) {
    suspend operator fun invoke(
        courseId: String
    ): Resource<List<Project>> {
        return courseRepository.getProjectsForCourse(courseId)
    }
}