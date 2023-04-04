package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class CreateCommentUseCase @Inject constructor(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(courseId: String, comment: String): SimpleResource {
        if(comment.isBlank()) {
            return Resource.Error(UiText.StringResource(R.string.error_field_empty))
        }
        if(courseId.isBlank()) {
            return Resource.Error(UiText.unknownError())
        }
        return repository.createComment(courseId, comment)
    }
}