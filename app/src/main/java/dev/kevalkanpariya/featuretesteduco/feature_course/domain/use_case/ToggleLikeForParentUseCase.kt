package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class ToggleLikeForParentUseCase @Inject constructor(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(
        parentId: String,
        parentType: Int,
        isLiked: Boolean
    ): SimpleResource {
        return if(isLiked) {
            repository.unlikeParent(parentId, parentType)
        } else {
            repository.likeParent(parentId, parentType)
        }
    }
}