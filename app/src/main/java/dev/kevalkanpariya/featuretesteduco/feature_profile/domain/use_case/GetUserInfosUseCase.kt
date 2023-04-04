package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.core.util.Resource

class GetUserInfosUseCase(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<UserItem>> {
        return profileRepository.getUserInfos(page = page, pageSize = pageSize)
    }
}