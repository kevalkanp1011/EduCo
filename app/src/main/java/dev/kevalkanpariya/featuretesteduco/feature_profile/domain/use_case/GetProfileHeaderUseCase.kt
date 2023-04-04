package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.Profile
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.ProfileHeader
import javax.inject.Inject

class GetProfileHeaderUseCase @Inject constructor(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<ProfileHeader> {
        return repository.getProfileHeader(userId)
    }
}