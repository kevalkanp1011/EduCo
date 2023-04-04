package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case

import android.content.Context
import android.net.Uri
import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.UpdateProfileData

class UpdateProfileDataUseCase(
    private val profileRepository: ProfileRepository
) {

    suspend operator fun invoke(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?,
        context: Context
    ): SimpleResource {
        return profileRepository.updateProfile(
            updateProfileData = updateProfileData,
            bannerImageUri = bannerImageUri,
            profilePictureUri = profilePictureUri,
            context = context
        )
    }
}