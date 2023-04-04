package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.UpdateProfileData

data class ProfileSettingsState(
    val profileSettingsData: UpdateProfileData? = null,
    val isLoading: Boolean = false
)
