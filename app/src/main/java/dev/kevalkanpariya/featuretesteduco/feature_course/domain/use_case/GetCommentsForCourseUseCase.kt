package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.Comment
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class GetCommentsForCourseUseCase @Inject constructor(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(courseId: String): Resource<List<Comment>> {
        return repository.getCommentsForCourse(courseId)
    }
}