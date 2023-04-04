package dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import javax.inject.Inject

class GetLikesForParentUseCase @Inject constructor(
    private val repository: CourseRepository
) {

    suspend operator fun invoke(parentId: String): Resource<List<UserItem>> {
        return repository.getLikesForParent(parentId)
    }
}