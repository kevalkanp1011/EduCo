package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.Profile
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.UpdateProfileData

class GetProfileForSettings(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(userId: String): Resource<Profile> {
        return profileRepository.getProfile(userId)
    }
}